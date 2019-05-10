package com.benxiaohai.user.service;

import com.benxiaohai.user.common.exceptions.ApiException;
import com.benxiaohai.user.dal.mapper.UserRoleMapper;
import com.benxiaohai.user.dal.po.UserRole;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户角色服务实现
 *
 * @author wangzhao
 * @create 2019/5/9
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Resource
    private UserRoleMapper userRoleMapper;

    /**
     * 添加
     *
     * @param userRole 用户角色对象
     * @return userRole
     */
    @Override
    public UserRole addUserRole(UserRole userRole) {
        if (userRoleMapper.insertSelective(userRole) == 0) {
            throw new ApiException("添加失败");
        }
        return userRole;
    }

    /**
     * 更新
     *
     * @param userRole 用户角色对象
     * @return userRole
     */
    @Override
    public UserRole updateUserRole(UserRole userRole) {
        return null;
    }

    /**
     * 移除
     *
     * @param userRoleId 用户角色id
     * @return userRole
     */
    @Override
    public int delUserRole(Integer userRoleId) {
        UserRole userRole = new UserRole();
        userRole.setId(userRoleId);
        userRole.setDeleteFlag((byte) 0);
        return userRoleMapper.updateByPrimaryKeySelective(userRole);
    }
}
