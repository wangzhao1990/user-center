package com.benxiaohai.user.service;

import com.alibaba.fastjson.JSONObject;
import com.benxiaohai.user.common.exceptions.ApiException;
import com.benxiaohai.user.dal.mapper.UserMapper;
import com.benxiaohai.user.dal.mapper.ext.UserMapperExt;
import com.benxiaohai.user.dal.po.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 *
 * @author wangz
 * @create 2019/4/19
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserMapperExt userMapperExt;

    /**
     * 添加用户
     *
     * @param user 用户信息
     * @return Use
     */
    @Override
    public User addUser(User user) {
        log.info("addUser--start:{}", JSONObject.toJSONString(user));
        if (userMapper.insertSelective(user) == 0) {
            throw new ApiException("添加失败");
        }

        log.info("addUser--end:{}", JSONObject.toJSONString(user));
        return user;
    }

    /**
     * 获取用户信息
     *
     * @param userId 用户id
     * @return user
     */
    @Override
    public User getUserById(Integer userId) {
        log.info("getUserById--start:{}", userId);
        return userMapper.selectByPrimaryKey(userId);
    }

    /**
     * 获取用户信息
     *
     * @param name     用户名
     * @param password 密码
     * @return user
     */
    @Override
    public User getUserByNameAndPwd(String name, String password) {
        log.info("getUserByNameAndPwd--start:{},{}", name,password);
        return userMapperExt.selectByNameAndPwd(name,password);
    }

    /**
     * 更新用户
     *
     * @param user 用户信息
     * @return 更新条数
     */
    @Override
    public int updateUser(User user) {
        log.info("updateUser--start:{}", JSONObject.toJSONString(user));
        int num;
        if ((num = userMapper.updateByPrimaryKeySelective(user)) == 0) {
            throw new ApiException("更新失败");
        }
        return num;
    }

    /**
     * 启用用户
     *
     * @param userId 用户id
     * @return 更新条数
     */
    @Override
    public int enableUser(Integer userId) {
        log.info("enableUser--start:{}", userId);
        User user = new User();
        user.setId(userId);
        user.setDeleteFlag((byte)1);
        return updateUser(user);
    }

    /**
     * 停用用户
     *
     * @param userId 用户id
     * @return 更新条数
     */
    @Override
    public int disableUser(Integer userId) {
        log.info("disableUser--start:{}", userId);
        User user = new User();
        user.setId(userId);
        user.setDeleteFlag((byte)0);
        return updateUser(user);
    }
}
