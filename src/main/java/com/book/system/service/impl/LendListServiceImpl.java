package com.book.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.book.system.entity.LendList;
import com.book.system.mapper.LendListMapper;
import com.book.system.service.ILendListService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.book.system.util.Result;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lan
 * @since 2020-10-21
 */
@Service
public class LendListServiceImpl extends ServiceImpl<LendListMapper, LendList> implements ILendListService {

    @Resource
    private LendListMapper lendListMapper;
    @Override
    public Result<Map<String, Object>> getLendInfo(Integer readerId) {
        Page<LendList> lendListPage = new Page<>(1,2);
        IPage<LendList> lendInfo = lendListMapper.getLendInfo(readerId, lendListPage);
        List<LendList> records = lendInfo.getRecords();
        long total = lendInfo.getTotal();
        Map<String,Object> map = new HashMap<>();
        map.put("lendList",records);
        map.put("total",total);
        return Result.success(map);
    }
}
