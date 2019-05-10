package com.benxiaohai.user.service;

import com.benxiaohai.user.dal.po.UserRole;

/**
 * 用户角色服务类
 *
 * @author wangzhao
 * @create 2019/5/9
 */
public interface UserRoleService {

    /**
     * 添加
     * @param userRole 用户角色对象
     * @return userRole
     */
    UserRole addUserRole(UserRole userRole);
    /**
     * 更新
     * @param userRole 用户角色对象
     * @return userRole
     */
    @Deprecated
    UserRole updateUserRole(UserRole userRole);
    /**
     * 移除
     * @param userRoleId 用户角色id
     * @return userRole
     */
    int delUserRole(Integer userRoleId);
}
