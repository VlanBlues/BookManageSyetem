package com.book.system.service;

import com.book.system.entity.BookComment;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lan
 * @since 2020-10-21
 */
public interface IBookCommentService extends IService<BookComment> {
    List<BookComment> getCommentAndReaderInfoById(@Param("bookId") String bookId);
}
