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


import com.dao.ShiyongjiaoxueDao;
import com.entity.ShiyongjiaoxueEntity;
import com.service.ShiyongjiaoxueService;
import com.entity.vo.ShiyongjiaoxueVO;
import com.entity.view.ShiyongjiaoxueView;

@Service("shiyongjiaoxueService")
public class ShiyongjiaoxueServiceImpl extends ServiceImpl<ShiyongjiaoxueDao, ShiyongjiaoxueEntity> implements ShiyongjiaoxueService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShiyongjiaoxueEntity> page = this.selectPage(
                new Query<ShiyongjiaoxueEntity>(params).getPage(),
                new EntityWrapper<ShiyongjiaoxueEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShiyongjiaoxueEntity> wrapper) {
		  Page<ShiyongjiaoxueView> page =new Query<ShiyongjiaoxueView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ShiyongjiaoxueVO> selectListVO(Wrapper<ShiyongjiaoxueEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShiyongjiaoxueVO selectVO(Wrapper<ShiyongjiaoxueEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShiyongjiaoxueView> selectListView(Wrapper<ShiyongjiaoxueEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShiyongjiaoxueView selectView(Wrapper<ShiyongjiaoxueEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
