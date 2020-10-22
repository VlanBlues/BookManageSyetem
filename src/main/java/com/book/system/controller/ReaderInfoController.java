package com.book.system.controller;


import com.book.system.entity.ReaderInfo;
import com.book.system.service.IReaderInfoService;
import com.book.system.util.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.Reader;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author lan
 * @since 2020-10-22
 */
@RestController
@RequestMapping("/reader")
public class ReaderInfoController {
    
    @Resource
    private IReaderInfoService readerInfoService;

    @RequestMapping("/login")
    public Result Login(@RequestBody ReaderInfo readerInfo){
        ReaderInfo readerByUsername = readerInfoService.getReaderByUsername(readerInfo);
        if("".equals(readerByUsername.getUsername()) || null == readerByUsername.getUsername()){
            return Result.fail("用户名密码错误！");
        }
        return Result.success("登录成功！！");
    }

    @RequestMapping("/updateOrSave")
    public Result updateOrSave(@RequestBody ReaderInfo readerInfo){
        System.out.println(readerInfo.toString());
        boolean i = readerInfoService.saveOrUpdate(readerInfo);
        if(i){
            return Result.success(i);
        }
        return Result.fail(i);
    }

    @RequestMapping("/update/img")
    public Result updateImg(@RequestParam("file") MultipartFile file, int readerId){
        
        return readerInfoService.updateImg(file,readerId);
    }
}
