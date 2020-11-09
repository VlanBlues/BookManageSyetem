package com.book.system.service.impl;

import com.book.system.entity.Notice;
import com.book.system.mapper.NoticeMapper;
import com.book.system.service.INoticeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lan
 * @since 2020-11-09
 */
@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements INoticeService {

    @Resource
    private NoticeMapper noticeMapper;
    
    @Override
    public List<Map> getCountByState() {
        return noticeMapper.getCountByState();
    }
}
