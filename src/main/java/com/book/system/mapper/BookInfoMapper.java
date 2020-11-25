package com.book.system.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.system.entity.BookInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lan
 * @since 2020-10-21
 */
public interface BookInfoMapper extends BaseMapper<BookInfo> {
    List<BookInfo> getBookByClassOrSearchContent(@Param("classId") String classId,@Param("content") String content);
    
    List<BookInfo> getList(@Param("bookName") String bookName,@Param("readerId") String readerId,Page<BookInfo> page);
    
    List<BookInfo> getListByReaderId(@Param("readerId") String readerId,Page<BookInfo> page);

    int updateBookImg(@Param("bookImg") String bookImg,@Param("bookId") Integer bookId);
}
