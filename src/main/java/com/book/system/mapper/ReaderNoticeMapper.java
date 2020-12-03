package com.book.system.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.system.entity.ReaderNotice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lan
 * @since 2020-12-03
 */
public interface ReaderNoticeMapper extends BaseMapper<ReaderNotice> {
    List<ReaderNotice> getByReaderIdAndState(@Param("readerId") String readerId, @Param("readState") String readState, Page<ReaderNotice> page);
}
