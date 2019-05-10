package com.benxiaohai.user.api.controller;

import com.benxiaohai.user.common.response.ResponseVo;
import com.benxiaohai.user.dal.po.User;
import com.benxiaohai.user.facade.feign.Test;
import com.benxiaohai.user.facade.feign.TestService;
import com.benxiaohai.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.annotation.Id;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户管理
 */
@RestController
@RequestMapping("/user")
@Api(tags = "UserController相关的api")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private TestService testService;

    @ApiOperation(value = "查询用户",notes = "根据用户ID查询用户信息")
    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET,produces="application/json")
    @ApiImplicitParam(name = "id", value = "用户ID", paramType = "path", required = true, dataType = "Integer")
    public ResponseVo getUserById(@PathVariable("id") Integer id){
        return ResponseVo.successResponse(userService.getUserById(id));
    }

    @ApiOperation(value = "添加用户",notes = "添加用户信息")
    @RequestMapping(value = "/add",method = RequestMethod.POST,consumes="application/json",produces="application/json")
    public ResponseVo addUser(@RequestBody User user){
        userService.addUser(user);
        return ResponseVo.successResponse(user);
    }

    @ApiOperation(value = "编辑用户",notes = "修改用户信息")
    @RequestMapping(value = "/",method = RequestMethod.POST,consumes="application/json",produces="application/json")
    public ResponseVo updateUser(@RequestBody User user){
        userService.updateUser(user);
        return ResponseVo.successResponse(user);
    }

    @ApiOperation(value = "启用用户",notes = "启用用户")
    @RequestMapping(value = "/enable/{id}",method = RequestMethod.POST,consumes="application/json",produces="application/json")
    public ResponseVo enableUser(@PathVariable("id") Integer id){
        userService.enableUser(id);
        return ResponseVo.successResponse(id);
    }

    @ApiOperation(value = "冻结用户",notes = "冻结用户")
    @RequestMapping(value = "/disable/{id}",method = RequestMethod.POST,consumes="application/json",produces="application/json")
    public ResponseVo disableUser(@PathVariable("id") Integer id){
        userService.disableUser(id);
        return ResponseVo.successResponse(id);
    }

    @ApiOperation(value = "测试",notes = "测试Hystrix")
    @RequestMapping(value = "/test/{id}",method = RequestMethod.GET,produces="application/json")
    public Test addUser(@PathVariable("id") Integer id){
        Test testById = testService.getTestById(id);
        return testById;
    }


}
