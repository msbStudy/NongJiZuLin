package com.dao;

import com.entity.ShiyongjiaoxueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShiyongjiaoxueVO;
import com.entity.view.ShiyongjiaoxueView;


/**
 * 使用教学
 * 
 * @author 
 * @email 
 * @date 2025-02-24 22:30:40
 */
public interface ShiyongjiaoxueDao extends BaseMapper<ShiyongjiaoxueEntity> {
	
	List<ShiyongjiaoxueVO> selectListVO(@Param("ew") Wrapper<ShiyongjiaoxueEntity> wrapper);
	
	ShiyongjiaoxueVO selectVO(@Param("ew") Wrapper<ShiyongjiaoxueEntity> wrapper);
	
	List<ShiyongjiaoxueView> selectListView(@Param("ew") Wrapper<ShiyongjiaoxueEntity> wrapper);

	List<ShiyongjiaoxueView> selectListView(Pagination page,@Param("ew") Wrapper<ShiyongjiaoxueEntity> wrapper);

	
	ShiyongjiaoxueView selectView(@Param("ew") Wrapper<ShiyongjiaoxueEntity> wrapper);
	

}
