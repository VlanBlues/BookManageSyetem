package com.book.system.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.book.system.entity.Admin;
import com.book.system.service.IAdminService;
import com.book.system.util.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Author: Vlan
 * Date: 2020/11/10 9:32
 */
@RequestMapping("/admin")
@RestController
public class AdminController {
    @Resource
    private IAdminService adminService;
    
    @RequestMapping("/login")
    public Result login(@RequestBody Admin admin){
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper.eq("username",admin.getUsername());
        wrapper.eq("password",admin.getPassword());
        int count = adminService.count(wrapper);
        if(count>=1){
            return Result.success("登录成功!");
        }
        return Result.fail("用户名或密码错误！");
    }
}
