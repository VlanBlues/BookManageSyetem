package com.book.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.system.entity.BookInfo;
import com.book.system.service.IBookInfoService;
import com.book.system.util.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Arrays;
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
    public Result addBook(@RequestBody BookInfo bookInfo){
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

    @RequestMapping("/delList")
    public Result delListByReaderId(String bookIdList){
        List<String> list = Arrays.asList(bookIdList.split(","));
        System.out.println(list);
        boolean b = bookInfoService.removeByIds(list);
        if(b){
            return Result.success();
        }
        return Result.fail();
    }
    
    @RequestMapping("/getList")
    public Result getList(String bookName,Integer pageIndex,Integer pageSize){
        Result bookInfoServiceList = bookInfoService.getList(bookName, pageIndex, pageSize);
        return bookInfoServiceList;
    }

    @RequestMapping("/update/bookImg")
    public Result updateImg(@RequestParam("file") MultipartFile file){
        System.out.println("update");
        return bookInfoService.updateImg(file);
    }
}
