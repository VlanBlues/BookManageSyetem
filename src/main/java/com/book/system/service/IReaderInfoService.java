package com.book.system.service;

import com.book.system.entity.ReaderInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.book.system.util.Result;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author lan
 * @since 2020-10-22
 */
public interface IReaderInfoService extends IService<ReaderInfo> {
    Result updateImg(@RequestParam("file") MultipartFile file, int readerId);

    ReaderInfo getReaderByUsername(ReaderInfo readerInfo);
}
