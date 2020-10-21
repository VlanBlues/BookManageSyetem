package com.book.system.service.impl;

import com.book.system.entity.BookCollection;
import com.book.system.mapper.BookCollectionMapper;
import com.book.system.service.IBookCollectionService;
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
public class BookCollectionServiceImpl extends ServiceImpl<BookCollectionMapper, BookCollection> implements IBookCollectionService {

}
