package com.book.system.service;

import com.book.system.entity.Notice;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lan
 * @since 2020-11-09
 */
public interface INoticeService extends IService<Notice> {
    List<Map> getCountByState();
}
