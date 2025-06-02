package com.dao;

import com.entity.NongjisuocheEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.NongjisuocheVO;
import com.entity.view.NongjisuocheView;


/**
 * 农机锁车
 * 
 * @author 
 * @email 
 * @date 2025-02-24 22:30:41
 */
public interface NongjisuocheDao extends BaseMapper<NongjisuocheEntity> {
	
	List<NongjisuocheVO> selectListVO(@Param("ew") Wrapper<NongjisuocheEntity> wrapper);
	
	NongjisuocheVO selectVO(@Param("ew") Wrapper<NongjisuocheEntity> wrapper);
	
	List<NongjisuocheView> selectListView(@Param("ew") Wrapper<NongjisuocheEntity> wrapper);

	List<NongjisuocheView> selectListView(Pagination page,@Param("ew") Wrapper<NongjisuocheEntity> wrapper);

	
	NongjisuocheView selectView(@Param("ew") Wrapper<NongjisuocheEntity> wrapper);
	

}
