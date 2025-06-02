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


import com.dao.NongjizulinDao;
import com.entity.NongjizulinEntity;
import com.service.NongjizulinService;
import com.entity.vo.NongjizulinVO;
import com.entity.view.NongjizulinView;

@Service("nongjizulinService")
public class NongjizulinServiceImpl extends ServiceImpl<NongjizulinDao, NongjizulinEntity> implements NongjizulinService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<NongjizulinEntity> page = this.selectPage(
                new Query<NongjizulinEntity>(params).getPage(),
                new EntityWrapper<NongjizulinEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<NongjizulinEntity> wrapper) {
		  Page<NongjizulinView> page =new Query<NongjizulinView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<NongjizulinVO> selectListVO(Wrapper<NongjizulinEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public NongjizulinVO selectVO(Wrapper<NongjizulinEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<NongjizulinView> selectListView(Wrapper<NongjizulinEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public NongjizulinView selectView(Wrapper<NongjizulinEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

    @Override
    public List<Map<String, Object>> selectValue(Map<String, Object> params, Wrapper<NongjizulinEntity> wrapper) {
        return baseMapper.selectValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params, Wrapper<NongjizulinEntity> wrapper) {
        return baseMapper.selectTimeStatValue(params, wrapper);
    }

    @Override
    public List<Map<String, Object>> selectGroup(Map<String, Object> params, Wrapper<NongjizulinEntity> wrapper) {
        return baseMapper.selectGroup(params, wrapper);
    }




}
