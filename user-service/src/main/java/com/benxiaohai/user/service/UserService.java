package com.benxiaohai.user.service;

import com.benxiaohai.user.dal.po.User;

/**
 * 用户服接口
 *
 * @author wangz
 * @create 2019/4/19
 */
public interface UserService {

    /**
     * 添加用户
     * @param user 用户信息
     * @return user
     */
    User addUser(User user);

    /**
     * 获取用户信息
     * @param userId 用户id
     * @return user
     */
    User getUserById(Integer userId);

    /**
     * 获取用户信息
     * @param name 用户名
     * @param password 密码
     * @return user
     */
    User getUserByNameAndPwd(String name,String password);

    /**
     * 更新用户
     * @param user 用户信息
     * @return 更新条数
     */
    int updateUser(User user);

    /**
     * 启用用户
     * @param userId 用户id
     * @return 更新条数
     */
    int enableUser(Integer userId);

    /**
     * 停用用户
     * @param userId 用户id
     * @return 更新条数
     */
    int disableUser(Integer userId);
}
