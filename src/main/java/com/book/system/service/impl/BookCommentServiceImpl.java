package com.book.system.service.impl;

import com.book.system.entity.BookComment;
import com.book.system.mapper.BookCommentMapper;
import com.book.system.service.IBookCommentService;
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
public class BookCommentServiceImpl extends ServiceImpl<BookCommentMapper, BookComment> implements IBookCommentService {

}
