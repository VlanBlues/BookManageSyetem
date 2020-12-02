package com.book.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.system.entity.LoginLog;
import com.book.system.service.ILoginLogService;
import com.book.system.util.Result;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lan
 * @since 2020-11-10
 */
@RestController
@RequestMapping("/log")
public class LoginLogController {
    @Resource
    private ILoginLogService logService;
    
    @RequestMapping("/getAll")
    public Result getAll(Integer pageIndex,Integer pageSize){
        IPage<LoginLog> page = new Page<>(pageIndex,pageSize);
        QueryWrapper<LoginLog> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("date");
        IPage<LoginLog> page1 = logService.page(page, wrapper);
        return Result.success(page1);
    }
}
