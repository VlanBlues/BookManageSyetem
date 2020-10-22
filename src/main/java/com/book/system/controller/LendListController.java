package com.book.system.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.system.entity.LendList;
import com.book.system.service.ILendListService;
import com.book.system.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/lend-list")
public class LendListController {
    
    @Resource
    private ILendListService lendListService;
    
    
    
    @RequestMapping("all")
    public List<LendList> getAllLendList(){
        return lendListService.list();
    }

    @RequestMapping("pageTests")
    public List<LendList> getPageTest(){
        IPage<LendList> lendListIPage = new Page<>(2,5);
        lendListIPage = lendListService.page(lendListIPage);
        List<LendList> lendLists = lendListIPage.getRecords();
        long total = lendListIPage.getTotal();
        System.out.println(total);
        return lendLists;
    }

}
