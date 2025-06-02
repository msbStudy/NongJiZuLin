package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZulinfuwuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZulinfuwuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZulinfuwuView;


/**
 * 租赁服务
 *
 * @author 
 * @email 
 * @date 2025-02-24 22:30:39
 */
public interface ZulinfuwuService extends IService<ZulinfuwuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZulinfuwuVO> selectListVO(Wrapper<ZulinfuwuEntity> wrapper);
   	
   	ZulinfuwuVO selectVO(@Param("ew") Wrapper<ZulinfuwuEntity> wrapper);
   	
   	List<ZulinfuwuView> selectListView(Wrapper<ZulinfuwuEntity> wrapper);
   	
   	ZulinfuwuView selectView(@Param("ew") Wrapper<ZulinfuwuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZulinfuwuEntity> wrapper);

   	

}

