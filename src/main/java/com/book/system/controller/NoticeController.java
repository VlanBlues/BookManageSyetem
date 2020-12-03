package com.book.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.system.entity.Notice;
import com.book.system.service.INoticeService;
import com.book.system.util.DateUtil;
import com.book.system.util.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lan
 * @since 2020-11-09
 */
@RestController
@RequestMapping("/notice")
public class NoticeController {
    @Resource
    private INoticeService noticeService;
    
    @RequestMapping("/state")
    public Result getUnpublished(Integer pageIndex,Integer pageSize,Integer state){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("state",state);
        IPage<Notice> noticeIPage = new Page<>(pageIndex,pageSize);
        IPage page = noticeService.page(noticeIPage, wrapper);
        
        return Result.success(page);
    }
    
    @RequestMapping("/add")
    public Result addNotice(@RequestBody Notice notice){
        notice.setCreateDate(DateUtil.getStringDate());
        boolean b = noticeService.save(notice);
        if(b){
            return Result.success();
        }
        return Result.fail();
    }
    
    @RequestMapping("/changeState")
    public Result changeState(@RequestBody Notice notice){
        if(notice.getState() == 1){
            notice.setPublishedDate(DateUtil.getStringDate());
        }
        boolean b = noticeService.saveOrUpdate(notice);
        if(b){
            return Result.success();
        }
        return Result.fail();
    }

    @RequestMapping("/getByReaderIdAndState")
    public Result getByReaderIdAndState(String readerId,Integer state,Integer pageIndex,Integer pageSize){
        return noticeService.getByReaderIdAndState(readerId,state,pageIndex,pageSize);
    }
    
    @RequestMapping("/getNewNotice")
    public Result getNewNotice(){
        QueryWrapper<Notice> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("published_date").last("limit 1");
        Notice notice = noticeService.getOne(wrapper);

        Date date = DateUtil.strToDateLong(DateUtil.getNextDay(DateUtil.getStringDate(), "1"));
        if(DateUtil.strToDateLong(notice.getPublishedDate()).after(date)){
            System.out.println(111);
        }else{
            System.out.println(222);
        }
        return Result.success();
    }
}
