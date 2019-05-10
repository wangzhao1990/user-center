package com.benxiaohai.user.facade.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * TODO: 请添加描述
 *
 * @author wangz
 * @create 2019/4/24
 */
@FeignClient(value = "test-service",fallback = TestServiceHystrix.class)
public interface TestService {

    @GetMapping(value = "/test/{id}")
    Test getTestById(@PathVariable("id") Integer id);
}
