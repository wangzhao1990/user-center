package com.benxiaohai.user.service;

import com.alibaba.fastjson.JSONObject;
import com.benxiaohai.user.common.exceptions.ApiException;
import com.benxiaohai.user.dal.mapper.RoleMapper;
import com.benxiaohai.user.dal.po.Role;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 角色服务实现
 *
 * @author wangzhao
 * @create 2019/5/8
 */
@Slf4j
@Service
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleMapper roleMapper;

    /**
     * 通过id获取角色信息
     *
     * @param id 角色id
     * @return 角色对象
     */
    @Override
    public Role getRoleById(Integer id) {
        log.info("getRoleById--start:{}", id);
        return roleMapper.selectByPrimaryKey(id);
    }

    /**
     * 添加角色
     *
     * @param role 角色对象
     * @return 角色对象
     */
    @Override
    public Role addRole(Role role) {
        log.info("addRole--start:{}", JSONObject.toJSONString(role));
        if (roleMapper.insertSelective(role) == 0) {
            throw new ApiException("添加失败");
        }
        return role;
    }

    /**
     * 更新角色
     *
     * @param role 角色信息
     * @return 更新条数
     */
    @Override
    public int updateRole(Role role) {
        log.info("updateRole--start:{}", JSONObject.toJSONString(role));
        int num;
        if ((num = roleMapper.updateByPrimaryKeySelective(role)) == 0) {
            throw new ApiException("更新失败");
        }
        return num;
    }
}
