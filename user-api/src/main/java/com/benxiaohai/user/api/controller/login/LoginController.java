package com.benxiaohai.user.api.controller.login;

import com.benxiaohai.user.common.response.ResponseVo;
import com.benxiaohai.user.service.biz.LoginBiz;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 登录处理类
 *
 * @author wangzhao
 * @create 2019/5/9
 */
@RestController
@RequestMapping
public class LoginController {

    @Resource
    private LoginBiz loginBiz;

    @ApiOperation(value = "登录", notes = "账号密码登录")
    @PostMapping(value = "/login")
    public ResponseVo login(String name,String password){

        return ResponseVo.successResponse(loginBiz.login(name,password));
    }
    @ApiOperation(value = "登出", notes = "登出")
    @PostMapping(value = "/logout")
    public ResponseVo login(){

        return ResponseVo.successResponse(null);
    }

}
