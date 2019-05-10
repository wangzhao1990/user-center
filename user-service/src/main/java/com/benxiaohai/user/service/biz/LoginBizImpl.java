package com.benxiaohai.user.service.biz;

import com.alibaba.fastjson.JSONObject;
import com.benxiaohai.user.common.utils.redis.RedisHelper;
import com.benxiaohai.user.dal.po.Permission;
import com.benxiaohai.user.dal.po.Role;
import com.benxiaohai.user.dal.po.User;
import com.benxiaohai.user.facade.dto.UserInfo;
import com.benxiaohai.user.service.UserService;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * 登录业务实现类
 *
 * @author wangzhao
 * @create 2019/5/9
 */
@Slf4j
@Service
public class LoginBizImpl implements LoginBiz {

    @Resource
    private UserService userService;

    @Resource
    private RedisHelper redisHelper;

    @Override
    public String login(String name, String password) {
        // 1. 校验用户账号密码
        User user = userService.getUserByNameAndPwd(name, password);
        if (null == user) {
            log.info("未查询到用户信息：name={},password={}",name,password);
            return "";
        }
        log.info("查询到的用户信息：user={}",JSONObject.toJSONString(user));

        // todo 2. 获取用户角色信息+权限信息
        List<Role> roles = Lists.newArrayList();

        List<Permission> permissions = Lists.newArrayList();

        // 3. 将用户信息+用户权限存储到redis中
        String sessionId = UUID.randomUUID().toString().replace("-","");
        UserInfo userInfo = UserInfo.builder().user(user).roles(roles).permissions(permissions).build();

        redisHelper.set(sessionId, JSONObject.toJSONString(userInfo));
        log.info("存入缓存成功：key={}",sessionId);
        return sessionId;
    }

    @Override
    public void logout(String sessionId) {
        // 清除缓存
        redisHelper.del(sessionId);
    }
}
