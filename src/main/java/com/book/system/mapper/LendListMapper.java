package com.book.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.system.entity.LendList;
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
public interface LendListMapper extends BaseMapper<LendList> {
    List<LendList> getLendInfo(@Param("readerId") Integer readerId,Page<LendList> page);
    
}
