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


import com.dao.NongjisuocheDao;
import com.entity.NongjisuocheEntity;
import com.service.NongjisuocheService;
import com.entity.vo.NongjisuocheVO;
import com.entity.view.NongjisuocheView;

@Service("nongjisuocheService")
public class NongjisuocheServiceImpl extends ServiceImpl<NongjisuocheDao, NongjisuocheEntity> implements NongjisuocheService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NongjisuocheEntity> page = this.selectPage(
                new Query<NongjisuocheEntity>(params).getPage(),
                new EntityWrapper<NongjisuocheEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<NongjisuocheEntity> wrapper) {
		  Page<NongjisuocheView> page =new Query<NongjisuocheView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<NongjisuocheVO> selectListVO(Wrapper<NongjisuocheEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public NongjisuocheVO selectVO(Wrapper<NongjisuocheEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<NongjisuocheView> selectListView(Wrapper<NongjisuocheEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public NongjisuocheView selectView(Wrapper<NongjisuocheEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
