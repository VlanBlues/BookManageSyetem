package com.book.system.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.system.entity.LendList;
import com.book.system.entity.LoginLog;
import com.book.system.entity.ReaderInfo;
import com.book.system.service.ILoginLogService;
import com.book.system.service.IReaderInfoService;
import com.book.system.util.DateUtil;
import com.book.system.util.IpUtil;
import com.book.system.util.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.Reader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    
    @Resource
    private ILoginLogService loginLogService;

    @RequestMapping("/login")
    public Result Login(@RequestBody ReaderInfo readerInfo , HttpServletRequest request){
        ReaderInfo readerByUsername = readerInfoService.getReaderByUsername(readerInfo);
        if(null == readerByUsername){
            return Result.fail("用户名密码错误！");
        }
        LoginLog loginLog = new LoginLog();
        loginLog.setDate(DateUtil.getStringDateShort());
        loginLog.setIp(IpUtil.getIpAddr(request));
        loginLog.setReaderId(readerByUsername.getReaderId());
        loginLogService.save(loginLog);
        return Result.success(readerByUsername);
    }

    @RequestMapping("/updateOrSave")
    public Result updateOrSave(@RequestBody ReaderInfo readerInfo){
        int countByUserName = readerInfoService.getCountByUserName(readerInfo.getUsername());
        if(countByUserName >= 1 && readerInfo.getReaderId() == null){
            return Result.fail("用户名已存在！");
        }
        if(readerInfo.getRegisterDate() == null){
            readerInfo.setRegisterDate(DateUtil.getStringDateShort());
        }
        boolean i = readerInfoService.saveOrUpdate(readerInfo);
        if(i){
            return Result.success("成功！");
        }
        return Result.fail("");
    }

    @RequestMapping("/update/img")
    public Result updateImg(@RequestParam("file") MultipartFile file, int readerId){
        
        return readerInfoService.updateImg(file,readerId);
    }

    @RequestMapping("/getList")
    public Result getReaderList(Integer pageIndex,Integer pageSize,String name){
        IPage<ReaderInfo> readerInfoIPage = new Page<>(pageIndex,pageSize);
        IPage<ReaderInfo> page;
        if (name == null || "".equals(name)) {
            page = readerInfoService.page(readerInfoIPage);
        }else {
            QueryWrapper wrapper = new QueryWrapper();
            wrapper.like("name",name);
            page = readerInfoService.page(readerInfoIPage,wrapper);
        }
        List<ReaderInfo> readerInfoList = page.getRecords();
        long total = page.getTotal();
        Map<String,Object> map = new HashMap<>();
        map.put("readerInfoList",readerInfoList);
        map.put("total",total);
        return Result.success(map);
    }
    @RequestMapping("/del")
    public Result delByReaderId(String readerId){
        boolean b = readerInfoService.removeById(readerId);
        if(b){
            return Result.success();
        }
        return Result.fail();
    }
    @RequestMapping("/delList")
    public Result delListByReaderId(String readerIdList){
        System.out.println(readerIdList);
        List<String> list = Arrays.asList(readerIdList.split(","));
        System.out.println(list);
        boolean b = readerInfoService.removeByIds(list);
        if(b){
            return Result.success();
        }
        return Result.fail();
    }
}
