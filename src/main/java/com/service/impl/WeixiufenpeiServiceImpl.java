package com.service.impl;

import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.WeixiufenpeiDao;
import com.entity.WeixiufenpeiEntity;
import com.service.WeixiufenpeiService;
import com.entity.vo.WeixiufenpeiVO;
import com.entity.view.WeixiufenpeiView;

@Service("weixiufenpeiService")
public class WeixiufenpeiServiceImpl extends ServiceImpl<WeixiufenpeiDao, WeixiufenpeiEntity> implements WeixiufenpeiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WeixiufenpeiEntity> page = this.selectPage(
                new Query<WeixiufenpeiEntity>(params).getPage(),
                new EntityWrapper<WeixiufenpeiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WeixiufenpeiEntity> wrapper) {
		  Page<WeixiufenpeiView> page =new Query<WeixiufenpeiView>(params).getPage();




	        page.setRecords(baseMapper.selectListView(page,wrapper));
		for (WeixiufenpeiEntity w:page.getRecords()){
			if("未完成".equals(w.getWeixiuzhuangtai())){
				Date d1 = new Date();
				Date d2 = w.getAddtime();
				long abs = Math.abs(d1.getTime() - d2.getTime());
				long d = abs/(1000*60*60*24);
				if(d>=1){
					w.setShowChange("1");
				}
			}


		}
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<WeixiufenpeiVO> selectListVO(Wrapper<WeixiufenpeiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WeixiufenpeiVO selectVO(Wrapper<WeixiufenpeiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WeixiufenpeiView> selectListView(Wrapper<WeixiufenpeiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WeixiufenpeiView selectView(Wrapper<WeixiufenpeiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
