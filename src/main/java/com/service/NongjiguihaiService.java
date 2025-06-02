package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.NongjiguihaiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.NongjiguihaiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.NongjiguihaiView;


/**
 * 农机归还
 *
 * @author 
 * @email 
 * @date 2025-02-24 22:30:40
 */
public interface NongjiguihaiService extends IService<NongjiguihaiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<NongjiguihaiVO> selectListVO(Wrapper<NongjiguihaiEntity> wrapper);
   	
   	NongjiguihaiVO selectVO(@Param("ew") Wrapper<NongjiguihaiEntity> wrapper);
   	
   	List<NongjiguihaiView> selectListView(Wrapper<NongjiguihaiEntity> wrapper);
   	
   	NongjiguihaiView selectView(@Param("ew") Wrapper<NongjiguihaiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<NongjiguihaiEntity> wrapper);

   	

}

