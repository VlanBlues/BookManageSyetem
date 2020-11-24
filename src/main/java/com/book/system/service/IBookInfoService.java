package com.book.system.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.system.entity.BookInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.book.system.util.Result;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lan
 * @since 2020-10-21
 */
public interface IBookInfoService extends IService<BookInfo> {
    List<BookInfo> getBookByClassOrSearchContent(String classId,String content);

    Result getList(String bookName,String readerId, Integer current, Integer size);

    Result updateImg(MultipartFile file);
}
