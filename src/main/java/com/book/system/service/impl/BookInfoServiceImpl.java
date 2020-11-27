package com.book.system.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.system.entity.BookInfo;
import com.book.system.mapper.BookInfoMapper;
import com.book.system.service.IBookInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.book.system.util.RandomUtil;
import com.book.system.util.Result;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

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

    @Resource
    private BookInfoMapper bookInfoMapper;
    
    @Override
    public List<BookInfo> getBookByClassOrSearchContent(String classId, String content) {
        return bookInfoMapper.getBookByClassOrSearchContent(classId,content);
    }

    @Override
    public Result getList(String bookName,String readerId,Integer current, Integer size) {
        Page<BookInfo> bookInfoPage = new Page<>(current,size);
        Page<BookInfo> bookInfoPage1 = bookInfoPage.setRecords(bookInfoMapper.getList(bookName,readerId, bookInfoPage));
        return Result.success(bookInfoPage1);
    }
    
    @Override
    public Result getListByReaderId(String readerId, Integer current, Integer size) {
        Page<BookInfo> bookInfoPage = new Page<>(current,size);
        Page<BookInfo> bookInfoPage1 = bookInfoPage.setRecords(bookInfoMapper.getListByReaderId(readerId, bookInfoPage));
        return Result.success(bookInfoPage1);
    }

    @Override
    public Result getRecommend() {
        return Result.success(bookInfoMapper.getRecommend());
    }

    @Override
    public Result updateImg(MultipartFile file) {
        String local = "F:/img/book/";
        //String local = "F:/img/test/";
        String fileName = file.getOriginalFilename();
        String fileType = "." + fileName.substring(fileName.lastIndexOf(".") + 1);
        // 存储图片
        //String filename = DateUtil.getStringToday().trim() + fileType;
        String filename = RandomUtil.getTenRandom() + fileType;

        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, Paths.get(local + filename), // 这里指定了下载的位置
                    StandardCopyOption.REPLACE_EXISTING);
            filename ="http://localhost:8081/b/img/"+ filename;
            //int i = bookInfoMapper.updateBookImg(filename, bookId);
            return Result.success(filename);
        } catch (IOException e) {
            System.out.println("上传失败");
            return Result.fail("上传失败");
        }
    }
}
