package com.book.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.system.entity.BookComment;
import com.book.system.service.IBookCommentService;
import com.book.system.util.Result;
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
@RequestMapping("/book/comment")
public class BookCommentController {
    @Resource
    private IBookCommentService bookCommentService;

    @RequestMapping("/getList")
    public Result getList(Integer current,Integer size,String bookId){
        IPage<BookComment> bookCommentPage = new Page<>(current,size);
        IPage page;
        if(null != bookId){
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.eq("book_id",bookId);
            page = bookCommentService.page(bookCommentPage, wrapper);
        }else {
            page = bookCommentService.page(bookCommentPage);
        }
        List<BookComment> bookCommentList = page.getRecords();
        long total = page.getTotal();
        Map<String,Object> map = new HashMap<>();
        map.put("bookCommentList",bookCommentList);
        map.put("total",total);
        return Result.success(map);
    }
    
    @RequestMapping("/getByBookId")
    public Result getByBookId(String bookId){
        List<BookComment> commentAndReaderInfoById = bookCommentService.getCommentAndReaderInfoById(bookId);
        return Result.success(commentAndReaderInfoById);
    }
    
    @RequestMapping("/add")
    public Result<String> addBookComment(@RequestBody BookComment bookComment){
        boolean save = bookCommentService.save(bookComment);
        if(save){
            return Result.success("评论成功！");
        }
        return Result.fail("评论失败！");
    }

    @RequestMapping("/del")
    public Result<String> deleteBookCollection(String BookCommentId){
        boolean del = bookCommentService.removeById(BookCommentId);
        if(del){
            return Result.success("删除评论！");
        }
        return Result.fail("评论删除失败！");
    }
}
