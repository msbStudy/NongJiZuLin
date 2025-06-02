package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.entity.ConfigEntity;
import com.entity.DriverEntity;
import com.entity.NewsEntity;
import com.entity.view.NewsView;
import com.entity.vo.NewsVO;
import com.utils.PageUtils;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 公告信息
 *
 * @author 
 * @email 
 * @date 2025-02-24 22:30:41
 */
public interface DriverService extends IService<DriverEntity> {


    PageUtils queryPage(Map<String, Object> params,Wrapper<DriverEntity> wrapper);
   	

}

