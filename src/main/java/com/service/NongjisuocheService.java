package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.NongjisuocheEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.NongjisuocheVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.NongjisuocheView;


/**
 * 农机锁车
 *
 * @author 
 * @email 
 * @date 2025-02-24 22:30:41
 */
public interface NongjisuocheService extends IService<NongjisuocheEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<NongjisuocheVO> selectListVO(Wrapper<NongjisuocheEntity> wrapper);
   	
   	NongjisuocheVO selectVO(@Param("ew") Wrapper<NongjisuocheEntity> wrapper);
   	
   	List<NongjisuocheView> selectListView(Wrapper<NongjisuocheEntity> wrapper);
   	
   	NongjisuocheView selectView(@Param("ew") Wrapper<NongjisuocheEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<NongjisuocheEntity> wrapper);

   	

}

