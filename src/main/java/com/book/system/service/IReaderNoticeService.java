package com.book.system.service;

import com.book.system.entity.ReaderNotice;
import com.baomidou.mybatisplus.extension.service.IService;
import com.book.system.util.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lan
 * @since 2020-12-03
 */
public interface IReaderNoticeService extends IService<ReaderNotice> {
    Result getByReaderIdAndState(String readerId,String readState,Integer pageIndex,Integer pageSize);
}
