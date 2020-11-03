package com.book.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.system.entity.BookInfo;
import com.book.system.service.IBookInfoService;
import com.book.system.util.Result;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lan
 * @since 2020-10-21
 */
@RestController
@RequestMapping("/book/info")
public class BookInfoController {
    
    @Resource
    private IBookInfoService bookInfoService;
    
    @RequestMapping("/search")
    public Result searchBook(String classId,String searchContent){
        List<BookInfo> bookByClassOrSearchContent = bookInfoService.getBookByClassOrSearchContent(classId, searchContent);
        return Result.success(bookByClassOrSearchContent);
    }
    
    @RequestMapping("/saveOrUpdate")
    public Result addBook(BookInfo bookInfo){
        boolean b = bookInfoService.saveOrUpdate(bookInfo);
        if(b){
            return Result.success(b);
        }
        return Result.fail();
    }

    @RequestMapping("/del")
    public Result deleteBookInfo(Integer bookId){
        boolean b = bookInfoService.removeById(bookId);
        if(b){
            return Result.success("删除成功！");
        }
        return Result.fail("删除失败！");
    }
    @RequestMapping("/getList")
    public Result getList(String bookName,Integer pageIndex,Integer pageSize){
        Result bookInfoServiceList = bookInfoService.getList(bookName, pageIndex, pageSize);
        return bookInfoServiceList;
    }
}
