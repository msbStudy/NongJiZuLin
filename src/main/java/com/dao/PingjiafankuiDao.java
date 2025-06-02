package com.dao;

import com.entity.PingjiafankuiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PingjiafankuiVO;
import com.entity.view.PingjiafankuiView;


/**
 * 评价反馈
 * 
 * @author 
 * @email 
 * @date 2025-02-24 22:30:40
 */
public interface PingjiafankuiDao extends BaseMapper<PingjiafankuiEntity> {
	
	List<PingjiafankuiVO> selectListVO(@Param("ew") Wrapper<PingjiafankuiEntity> wrapper);
	
	PingjiafankuiVO selectVO(@Param("ew") Wrapper<PingjiafankuiEntity> wrapper);
	
	List<PingjiafankuiView> selectListView(@Param("ew") Wrapper<PingjiafankuiEntity> wrapper);

	List<PingjiafankuiView> selectListView(Pagination page,@Param("ew") Wrapper<PingjiafankuiEntity> wrapper);

	
	PingjiafankuiView selectView(@Param("ew") Wrapper<PingjiafankuiEntity> wrapper);
	

    List<Map<String, Object>> selectValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<PingjiafankuiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<PingjiafankuiEntity> wrapper);

    List<Map<String, Object>> selectGroup(@Param("params") Map<String, Object> params,@Param("ew") Wrapper<PingjiafankuiEntity> wrapper);



}
