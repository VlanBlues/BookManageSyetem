package com.book.system.controller;


import com.book.system.entity.ReaderNotice;
import com.book.system.service.IReaderNoticeService;
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
 * @since 2020-12-03
 */
@RestController
@RequestMapping("/readNotice")
public class ReaderNoticeController {
    @Resource
    private IReaderNoticeService readNoticeService;
    
    @RequestMapping("/getByReaderIdAndState")
    public Result getByReaderIdAndState(String readerId,String readState,Integer pageIndex,Integer pageSize){
        return readNoticeService.getByReaderIdAndState(readerId,readState,pageIndex,pageSize);
    }

    @RequestMapping("/changeState")
    public Result changeState(ReaderNotice readerNotice){
        boolean b = readNoticeService.saveOrUpdate(readerNotice);
        if(b){
            return Result.success();
        }
        return Result.fail();
    }
    
    @RequestMapping("/read")
    public Result readNotice(ReaderNotice readerNotice){
        boolean save = readNoticeService.save(readerNotice);
        if(save){
            return Result.success();
        }
        return Result.fail();
    }
}
