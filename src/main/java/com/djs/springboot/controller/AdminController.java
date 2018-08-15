package com.djs.springboot.controller;

import com.djs.springboot.entity.Admin;
import com.djs.springboot.entity.Result;
import com.djs.springboot.service.AdminService;
import com.djs.springboot.utils.ResultUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * controller
 * @since 2018年8月9日
 * @author Mr.zhao
 */
@RestController
@RequestMapping("/admin")
@Api(value = "Admin", description = "测试AdminController")
public class AdminController {
    @Autowired
    private AdminService adminService;


    @GetMapping("/selectAll")
    @ApiOperation(value = "查询管理员信息接口",notes = "查询管理员信息接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "header", dataType="string", name = "token", value = "访问凭证", required = true),
    })
    public Result selectAll(){

        return ResultUtil.success(adminService.selectAll());
    }
    @ApiOperation(value = "增加管理员信息接口",notes = "增加管理员信息接口")
    @PostMapping("/insert")
    public  Result insert(Admin admin){

        try {
            adminService.insert(admin);
            return ResultUtil.success(admin);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.parameterError();
        }

    }

    @PutMapping("/update")
    @ApiOperation(value = "修改个人信息接口",notes = "修改个人信息接口")
    public Result update(Admin admin){

        System.out.println("修改的"+admin);
        try{
            adminService.update(admin);
            return ResultUtil.success(admin);
        }catch (Exception e){
            e.printStackTrace();
           return  ResultUtil.parameterError();
        }

    }

    @ApiOperation(value = "删除管理员接口",notes = "删除管理员接口")
    @DeleteMapping("/delete/{ids}")
    public Result delete(@PathVariable("ids")String [] ids){
        try {
            adminService.delete(ids);
            return ResultUtil.success(ids);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.parameterError();
        }
    }


}
