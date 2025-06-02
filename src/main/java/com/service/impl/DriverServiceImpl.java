package com.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.dao.DriverDao;
import com.dao.NewsDao;
import com.entity.ConfigEntity;
import com.entity.DriverEntity;
import com.entity.NewsEntity;
import com.entity.view.NewsView;
import com.entity.vo.NewsVO;
import com.service.DriverService;
import com.service.NewsService;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("driverServiceImpl")
public class DriverServiceImpl extends ServiceImpl<DriverDao, DriverEntity> implements DriverService {
    @Override
    public PageUtils queryPage(Map<String, Object> params, Wrapper<DriverEntity> wrapper) {
        Page<DriverEntity> page = this.selectPage(
                new Query<DriverEntity>(params).getPage(),
                wrapper
        );
        return new PageUtils(page);
    }


}
