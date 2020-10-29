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
    public Result getAllLendList(Integer current,Integer size){
        IPage<LendList> lendListIPage = new Page<>(current,size);
        IPage<LendList> page = lendListService.page(lendListIPage);
        List<LendList> lendLists = page.getRecords();
        long total = page.getTotal();
        Map<String,Object> map = new HashMap<>();
        map.put("lendLists",lendLists);
        map.put("total",total);
        return Result.success(map);
    }
    
    @RequestMapping("/get")
    public Result getLendList(Integer readerId){
        Result<Map<String, Object>> lendInfo = lendListService.getLendInfo(readerId);
        return lendInfo;
    }
}
