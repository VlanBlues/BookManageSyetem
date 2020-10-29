package com.book.system.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.system.entity.LendList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

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
    IPage<LendList> getLendInfo(Integer readerId, IPage<LendList> page);
}
