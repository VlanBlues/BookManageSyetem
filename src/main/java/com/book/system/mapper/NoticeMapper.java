package com.book.system.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.system.entity.Notice;
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
 * @since 2020-11-09
 */
public interface NoticeMapper extends BaseMapper<Notice> {
    List<Map> getCountByState();

    List<Notice> getByReaderIdAndState(Page<Notice> page,@Param("state") Integer state,@Param("readerId") String readerId);
}
