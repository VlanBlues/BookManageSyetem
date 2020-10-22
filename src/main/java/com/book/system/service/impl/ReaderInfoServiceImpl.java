package com.book.system.service.impl;

import com.book.system.entity.ReaderInfo;
import com.book.system.mapper.ReaderInfoMapper;
import com.book.system.service.IReaderInfoService;
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

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lan
 * @since 2020-10-22
 */
@Service
public class ReaderInfoServiceImpl extends ServiceImpl<ReaderInfoMapper, ReaderInfo> implements IReaderInfoService {
    
    @Resource
    private ReaderInfoMapper readerInfoMapper;

    /**
     * 修改读者头像
     * @param file
     * @param readerId
     * @return
     */
    @Override
    public Result updateImg(MultipartFile file, int readerId) {
        String local = "F:/img/user_img/";
        //String local = "F:/img/test/";
        String fileName = file.getOriginalFilename();
        String fileType = "." + fileName.substring(fileName.lastIndexOf(".") + 1);
        // 存储图片
        //String filename = DateUtil.getStringToday().trim() + fileType;
        String filename = RandomUtil.getTenRandom() + fileType;

        try (InputStream inputStream = file.getInputStream()) {
            Files.copy(inputStream, Paths.get(local + filename), // 这里指定了下载的位置
                    StandardCopyOption.REPLACE_EXISTING);
            filename ="http://localhost:8080/u/img/"+ filename;
            int i = readerInfoMapper.updateReaderImg(filename, readerId);
            if(i == 1){
                return Result.success("上传成功");
            }else {
                return Result.fail("上传失败");
            }
        } catch (IOException e) {
            System.out.println("上传失败");
            return Result.fail("上传失败");
        }
    }
    
    @Override
    public ReaderInfo getReaderByUsername(ReaderInfo readerInfo) {
        return readerInfoMapper.getReaderByUsername(readerInfo);
    }
}
