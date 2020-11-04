package com.book.system;

import com.book.system.controller.ClassInfoController;
import com.book.system.entity.ReaderInfo;
import com.book.system.service.ILendListService;
import com.book.system.service.IReaderInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ClassUtils;

import javax.annotation.Resource;

@SpringBootTest
class SystemApplicationTests {
    
    @Resource
    ILendListService lendListService;
    
    @Resource
    ClassInfoController classInfoController;
    
    @Test
    void contextLoads() {
        //String path = ClassUtils.getDefaultClassLoader().getResource("").getHost();
        //System.out.println(path);
        System.out.println(classInfoController.getAllClassInfo());
    }
    
}
