package com.benxiaohai.user.api;

import com.benxiaohai.user.dal.po.User;
import com.benxiaohai.user.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * UserServiceImplTest
 *
 * @author wangz
 * @create 2019/4/19
 */
public class UserServiceImplTest extends UserApiApplicationTests {

    @Resource
    private UserService userService;

    /**
     *  \\@Transactional 可以实现db回滚
     */
    @Test
    @Transactional
    public void addUser() {
        User user = new User();
        user.setName("admin");
        user.setPassword("123456");
        user.setUserName("admin");
        User addUser = userService.addUser(user);
        Assert.assertTrue(addUser.getName().equals("admin"));
    }

    @Test
    public void getUserById() {
        User userById = userService.getUserById(1);
        Assert.assertEquals(userById.getName(),"admin");
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setId(1);
        user.setName("admin");
        user.setPassword("123456");
        user.setUserName("admin");
        user.setPhoneNo("17621140103");
        userService.updateUser(user);
    }

    @Test
    public void enableUser() {
        int i = userService.enableUser(1);
    }

    @Test
    public void disableUser() {
        int i = userService.disableUser(0);
    }

    @Test
    public void selectByNameAndPwd() {
        User admin = userService.getUserByNameAndPwd("admin", "123456");
        Assert.assertEquals(admin.getName(),"admin");
    }
}