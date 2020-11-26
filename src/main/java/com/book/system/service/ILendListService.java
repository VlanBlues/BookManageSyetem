package com.book.system.service;

import com.book.system.entity.LendList;
import com.baomidou.mybatisplus.extension.service.IService;
import com.book.system.util.Result;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lan
 * @since 2020-10-21
 */
public interface ILendListService extends IService<LendList> {
    Result getLendInfo(Integer readerId,Integer state,Integer current,Integer size);
}
