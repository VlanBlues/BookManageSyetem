package com.book.system;

import com.book.system.controller.ClassInfoController;
import com.book.system.entity.BookInfo;
import com.book.system.entity.ReaderInfo;
import com.book.system.mapper.NoticeMapper;
import com.book.system.service.ILendListService;
import com.book.system.service.IReaderInfoService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ClassUtils;

import javax.annotation.Resource;
import java.lang.reflect.Field;

@SpringBootTest
class SystemApplicationTests {
    
    @Resource
    ILendListService lendListService;
    
    @Resource
    private ClassInfoController classInfoController;
    
    @Resource
    private NoticeMapper noticeMapper;
    
    @Test
    void contextLoads() {
        //String path = ClassUtils.getDefaultClassLoader().getResource("").getHost();
        //System.out.println(path);
        //System.out.println(classInfoController.getAllClassInfo());
        System.out.println(noticeMapper.getCountByState());
    }
    
    
}
