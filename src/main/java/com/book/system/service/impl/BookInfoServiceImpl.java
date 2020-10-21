package com.book.system.service.impl;

import com.book.system.entity.BookInfo;
import com.book.system.mapper.BookInfoMapper;
import com.book.system.service.IBookInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lan
 * @since 2020-10-21
 */
@Service
public class BookInfoServiceImpl extends ServiceImpl<BookInfoMapper, BookInfo> implements IBookInfoService {

}
