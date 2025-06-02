package com.dao;

import com.entity.ZulinfuwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZulinfuwuVO;
import com.entity.view.ZulinfuwuView;


/**
 * 租赁服务
 * 
 * @author 
 * @email 
 * @date 2025-02-24 22:30:39
 */
public interface ZulinfuwuDao extends BaseMapper<ZulinfuwuEntity> {
	
	List<ZulinfuwuVO> selectListVO(@Param("ew") Wrapper<ZulinfuwuEntity> wrapper);
	
	ZulinfuwuVO selectVO(@Param("ew") Wrapper<ZulinfuwuEntity> wrapper);
	
	List<ZulinfuwuView> selectListView(@Param("ew") Wrapper<ZulinfuwuEntity> wrapper);

	List<ZulinfuwuView> selectListView(Pagination page,@Param("ew") Wrapper<ZulinfuwuEntity> wrapper);

	
	ZulinfuwuView selectView(@Param("ew") Wrapper<ZulinfuwuEntity> wrapper);
	

}
