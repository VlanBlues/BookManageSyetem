package com.book.system.mapper;

import com.book.system.entity.ReaderInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author lan
 * @since 2020-10-22
 */
public interface ReaderInfoMapper extends BaseMapper<ReaderInfo> {
    
    ReaderInfo getReaderByUsername(ReaderInfo readerInfo);
    
    int updateReaderImg(@Param("img") String img,@Param("readerId") int readerId);
}
