package com.book.system.mapper;

import com.book.system.entity.BookComment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lan
 * @since 2020-10-21
 */
public interface BookCommentMapper extends BaseMapper<BookComment> {
    List<BookComment> getCommentAndReaderInfoById(@Param("bookId") String bookId);
}
