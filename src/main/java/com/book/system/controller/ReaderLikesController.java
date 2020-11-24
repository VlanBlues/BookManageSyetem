package com.book.system.controller;


import com.book.system.service.IReaderLikesService;
import com.book.system.util.Result;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lan
 * @since 2020-10-21
 */
@RestController
@RequestMapping("/book/likes")
public class ReaderLikesController {
    private IReaderLikesService readerLikesService;
    @RequestMapping("/getByReaderId")
    public Result ClassName(String readerId){
        readerLikesService.list();
        return null;
    }
}
