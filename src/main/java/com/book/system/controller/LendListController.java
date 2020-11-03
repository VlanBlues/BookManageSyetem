package com.book.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.system.entity.LendList;
import com.book.system.service.ILendListService;
import com.book.system.util.MD5Util;
import com.book.system.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lan
 * @since 2020-10-21
 */
@RestController
@RequestMapping("/lendList")
public class LendListController {
    
    @Resource
    private ILendListService lendListService;
    
    @RequestMapping("/readerId/{readerId}")
    public Result getByReaderId(@PathVariable String readerId){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("reader_id",readerId);
        List list = lendListService.list(wrapper);
        return Result.success(list);
    }
    
    @RequestMapping("/getList")
    public Result getLendList(Integer readerId,Integer current,Integer size){
        Result lendInfo = lendListService.getLendInfo(readerId,current,size);
        return lendInfo;
    }
}
