package com.benxiaohai.user.api.controller;

import com.benxiaohai.user.dal.po.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * controller单元测试
 *
 * @author wangz
 * @create 2019/4/23
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getUserById() {
        User user = restTemplate.getForObject("/user/get/{id}", User.class, 1);
        Assert.assertNotNull(user);
    }

    @Test
    public void addUser() {
    }
}