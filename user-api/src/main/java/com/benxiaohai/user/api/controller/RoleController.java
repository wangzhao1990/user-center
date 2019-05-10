package com.benxiaohai.user.api.controller;

import com.benxiaohai.user.common.response.ResponseVo;
import com.benxiaohai.user.dal.po.Role;
import com.benxiaohai.user.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 角色管理
 *
 * @author wangzhao
 * @create 2019/5/8
 */
@RestController
@RequestMapping("/role")
@Api(tags = "RoleController相关的api")
public class RoleController {

    @Resource
    private RoleService roleService;

    @ApiOperation(value = "查询角色",notes = "根据角色ID查询角色信息")
    @RequestMapping(value = "/get/{id}",method = RequestMethod.GET,produces="application/json")
    @ApiImplicitParam(name = "id", value = "角色ID", paramType = "path", required = true, dataType = "Integer")
    public ResponseVo getRoleById(@PathVariable("id") Integer id){
        return ResponseVo.successResponse(roleService.getRoleById(id));
    }

    @ApiOperation(value = "添加角色",notes = "添加角色")
    @RequestMapping(value = "/add",method = RequestMethod.GET,produces="application/json")
    public ResponseVo addRole(@RequestBody Role role){
        return ResponseVo.successResponse(roleService.addRole(role));
    }

    @ApiOperation(value = "编辑角色",notes = "更新角色信息")
    @ApiImplicitParam(name = "id", value = "角色ID", paramType = "path", required = true, dataType = "Integer")
    @RequestMapping(value = "/update",method = RequestMethod.GET,produces="application/json")
    public ResponseVo updateRole(@RequestBody Role role){
        return ResponseVo.successResponse(roleService.updateRole(role));
    }
}
