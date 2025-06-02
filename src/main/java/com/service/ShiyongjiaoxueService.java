package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShiyongjiaoxueEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShiyongjiaoxueVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShiyongjiaoxueView;


/**
 * 使用教学
 *
 * @author 
 * @email 
 * @date 2025-02-24 22:30:40
 */
public interface ShiyongjiaoxueService extends IService<ShiyongjiaoxueEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShiyongjiaoxueVO> selectListVO(Wrapper<ShiyongjiaoxueEntity> wrapper);
   	
   	ShiyongjiaoxueVO selectVO(@Param("ew") Wrapper<ShiyongjiaoxueEntity> wrapper);
   	
   	List<ShiyongjiaoxueView> selectListView(Wrapper<ShiyongjiaoxueEntity> wrapper);
   	
   	ShiyongjiaoxueView selectView(@Param("ew") Wrapper<ShiyongjiaoxueEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShiyongjiaoxueEntity> wrapper);

   	

}

