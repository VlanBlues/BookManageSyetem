package com.book.system.mapper;

import com.book.system.entity.Notice;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

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
}
