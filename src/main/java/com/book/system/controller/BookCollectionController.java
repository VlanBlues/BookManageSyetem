package com.book.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.system.entity.BookCollection;
import com.book.system.service.IBookCollectionService;
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
 * 前端控制器
 * </p>
 *
 * @author lan
 * @since 2020-10-21
 */
@RestController
@RequestMapping("/book/collection")
public class BookCollectionController {
    @Resource
    private IBookCollectionService bookCollectionService;

    @RequestMapping("/getList")
    public Result getList(Integer current,Integer size,String readerId){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("reader_id", readerId);
        IPage<BookCollection> bookCommentPage = new Page<>(current,size);
        IPage page = bookCollectionService.page(bookCommentPage, wrapper);
        List<BookCollection> bookCommentList = page.getRecords();
        long total = page.getTotal();
        Map<String,Object> map = new HashMap<>();
        map.put("bookCommentList",bookCommentList);
        map.put("total",total);
        return Result.success(map);
    }
    
    @RequestMapping("/getByReaderId")
    public Result getByReaderId(String readerId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("reader_id", readerId);
        return Result.success(bookCollectionService.list(wrapper));
    }

    @RequestMapping("/add")
    public Result addBookCollection(@RequestBody BookCollection bookCollection) {
        boolean save = bookCollectionService.save(bookCollection);
        if (save) {
            return Result.success("收藏成功！");
        }
        return Result.fail("收藏失败！");
    }

    @RequestMapping("/del")
    public Result deleteBookCollection(String collectionId) {
        boolean del = bookCollectionService.removeById(collectionId);
        if (del) {
            return Result.success("取消收藏！");
        }
        return Result.fail("取消收藏失败！");
    }
}
