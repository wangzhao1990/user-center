package com.benxiaohai.user.facade.dto;

import com.benxiaohai.user.dal.po.Permission;
import com.benxiaohai.user.dal.po.Role;
import com.benxiaohai.user.dal.po.User;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * 用户信息
 *
 * @author wangzhao
 * @create 2019/5/9
 */
@Data
@Builder
public class UserInfo {

    /**
     * 基础信息
     */
    private User user;

    /**
     * 角色集合
     */
    private List<Role> roles;

    /**
     * 权限集合
     */
    private List<Permission> permissions;
}
