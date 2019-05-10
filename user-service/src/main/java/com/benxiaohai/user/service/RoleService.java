package com.benxiaohai.user.service;

import com.benxiaohai.user.dal.po.Role;

/**
 * 角色服务接口
 *
 * @author wangzhao
 * @create 2019/5/8
 */
public interface RoleService {

    /**
     * 通过id获取角色信息
     * @param id 角色id
     * @return 角色对象
     */
    Role getRoleById(Integer id);

    /**
     * 添加角色
     * @param role 角色对象
     * @return 角色对象
     */
    Role addRole(Role role);


    /**
     * 更新角色
     * @param role 角色信息
     * @return 更新条数
     */
    int updateRole(Role role);


}
