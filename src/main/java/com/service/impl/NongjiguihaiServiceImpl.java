package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.NongjiguihaiDao;
import com.entity.NongjiguihaiEntity;
import com.service.NongjiguihaiService;
import com.entity.vo.NongjiguihaiVO;
import com.entity.view.NongjiguihaiView;

@Service("nongjiguihaiService")
public class NongjiguihaiServiceImpl extends ServiceImpl<NongjiguihaiDao, NongjiguihaiEntity> implements NongjiguihaiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NongjiguihaiEntity> page = this.selectPage(
                new Query<NongjiguihaiEntity>(params).getPage(),
                new EntityWrapper<NongjiguihaiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<NongjiguihaiEntity> wrapper) {
		  Page<NongjiguihaiView> page =new Query<NongjiguihaiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<NongjiguihaiVO> selectListVO(Wrapper<NongjiguihaiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public NongjiguihaiVO selectVO(Wrapper<NongjiguihaiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<NongjiguihaiView> selectListView(Wrapper<NongjiguihaiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public NongjiguihaiView selectView(Wrapper<NongjiguihaiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
