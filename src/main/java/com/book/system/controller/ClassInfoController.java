package com.book.system.controller;


import com.book.system.entity.ClassInfo;
import com.book.system.service.IClassInfoService;
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
@RequestMapping("/class/info")
public class ClassInfoController {
    @Resource
    private IClassInfoService classInfoService;
    
    @RequestMapping("/all")
    public Result getAllClassInfo(){
        List<ClassInfo> list = classInfoService.list();
        return Result.success(list);
    }
    
    @RequestMapping("/saveOrUpdate")
    public Result saveOrUpdate(ClassInfo classInfo){
        boolean b = classInfoService.saveOrUpdate(classInfo);
        if (b){
            return Result.success(b);
        }
        return Result.fail(b);
    }
}
