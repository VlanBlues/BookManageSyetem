package com.book.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.system.entity.LendList;
import com.book.system.service.ILendListService;
import com.book.system.util.DateUtil;
import com.book.system.util.MD5Util;
import com.book.system.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("/subscribe")
public class LendListController {
    
    @Resource
    private ILendListService lendListService;
    
    @RequestMapping("/getIsSubscribe")
    public Result getByReaderId(String bookId,String readerId){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("book_id",bookId);
        wrapper.eq("reader_id",readerId);
        wrapper.ne("state",2);
        List list = lendListService.list(wrapper);
        if(list.size() >= 1){
            return Result.success("yes");
        }
        return Result.success("no");
    }
    
    @RequestMapping("/getListByState")
    public Result getLendList(Integer readerId,Integer state,Integer pageIndex,Integer pageSize){
        Result lendInfo = lendListService.getLendInfo(readerId,state,pageIndex,pageSize);
        return lendInfo;
    }
    
    @RequestMapping("/saveOrUpdate")
    public Result add(@RequestBody LendList lendList){
        if(null == lendList.getLendDate()){
            lendList.setLendDate(DateUtil.getStringDateShort());
        }else if("1".equals(lendList.getState().toString())){
            lendList.setApprovalDate(DateUtil.getStringDateShort());
        }else if("2".equals(lendList.getState().toString())){
            lendList.setBackDate(DateUtil.getStringDateShort());
        }
        boolean b = lendListService.saveOrUpdate(lendList);
        if(b){
            return Result.success();
        }
        return Result.fail();
    }
}
