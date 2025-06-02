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


import com.dao.ZulinfuwuDao;
import com.entity.ZulinfuwuEntity;
import com.service.ZulinfuwuService;
import com.entity.vo.ZulinfuwuVO;
import com.entity.view.ZulinfuwuView;

@Service("zulinfuwuService")
public class ZulinfuwuServiceImpl extends ServiceImpl<ZulinfuwuDao, ZulinfuwuEntity> implements ZulinfuwuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZulinfuwuEntity> page = this.selectPage(
                new Query<ZulinfuwuEntity>(params).getPage(),
                new EntityWrapper<ZulinfuwuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZulinfuwuEntity> wrapper) {
		  Page<ZulinfuwuView> page =new Query<ZulinfuwuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ZulinfuwuVO> selectListVO(Wrapper<ZulinfuwuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZulinfuwuVO selectVO(Wrapper<ZulinfuwuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZulinfuwuView> selectListView(Wrapper<ZulinfuwuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZulinfuwuView selectView(Wrapper<ZulinfuwuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
