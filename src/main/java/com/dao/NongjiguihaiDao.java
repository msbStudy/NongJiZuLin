package com.dao;

import com.entity.NongjiguihaiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.NongjiguihaiVO;
import com.entity.view.NongjiguihaiView;


/**
 * 农机归还
 * 
 * @author 
 * @email 
 * @date 2025-02-24 22:30:40
 */
public interface NongjiguihaiDao extends BaseMapper<NongjiguihaiEntity> {
	
	List<NongjiguihaiVO> selectListVO(@Param("ew") Wrapper<NongjiguihaiEntity> wrapper);
	
	NongjiguihaiVO selectVO(@Param("ew") Wrapper<NongjiguihaiEntity> wrapper);
	
	List<NongjiguihaiView> selectListView(@Param("ew") Wrapper<NongjiguihaiEntity> wrapper);

	List<NongjiguihaiView> selectListView(Pagination page,@Param("ew") Wrapper<NongjiguihaiEntity> wrapper);

	
	NongjiguihaiView selectView(@Param("ew") Wrapper<NongjiguihaiEntity> wrapper);
	

}
