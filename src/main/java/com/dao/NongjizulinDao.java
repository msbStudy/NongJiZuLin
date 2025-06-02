package com.dao;

import com.entity.NongjizulinEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.NongjizulinVO;
import com.entity.view.NongjizulinView;


/**
 * 农机租赁
 * 
 * @author 
 * @email 
 * @date 2025-02-24 22:30:40
 */
public interface NongjizulinDao extends BaseMapper<NongjizulinEntity> {
	
	List<NongjizulinVO> selectListVO(@Param("ew") Wrapper<NongjizulinEntity> wrapper);
	
	NongjizulinVO selectVO(@Param("ew") Wrapper<NongjizulinEntity> wrapper);
	
	List<NongjizulinView> selectListView(@Param("ew") Wrapper<NongjizulinEntity> wrapper);

	List<NongjizulinView> selectListView(Pagination page,@Param("ew") Wrapper<NongjizulinEntity> wrapper);

	
	NongjizulinView selectView(@Param("ew") Wrapper<NongjizulinEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<NongjizulinEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<NongjizulinEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<NongjizulinEntity> wrapper);



}
