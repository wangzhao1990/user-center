package com.benxiaohai.user.facade.feign;

import org.springframework.stereotype.Component;

/**
 * TODO: 请添加描述
 *
 * @author wangz
 * @create 2019/4/24
 */
@Component
public class TestServiceHystrix implements TestService {
    @Override
    public Test getTestById(Integer id) {
        return Test.builder().id(1).name("test").build();
    }
}
