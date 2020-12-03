package com.book.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.system.entity.ReaderNotice;
import com.book.system.mapper.ReaderNoticeMapper;
import com.book.system.service.IReaderNoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.book.system.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lan
 * @since 2020-12-03
 */
@Service
public class ReaderNoticeServiceImpl extends ServiceImpl<ReaderNoticeMapper, ReaderNotice> implements IReaderNoticeService {

    @Resource
    private ReaderNoticeMapper readerNoticeMapper;
    
    @Override
    public Result getByReaderIdAndState(String readerId,String readState,Integer pageIndex,Integer pageSize) {
        Page<ReaderNotice> readerNoticePage = new Page<>(pageIndex,pageSize);
        Page<ReaderNotice> readerNoticePage1 = readerNoticePage.setRecords(readerNoticeMapper.getByReaderIdAndState(readerId, readState, readerNoticePage));
        return Result.success(readerNoticePage1);
    }
}
