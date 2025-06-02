package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.NongjizulinEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.NongjizulinVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.NongjizulinView;


/**
 * 农机租赁
 *
 * @author 
 * @email 
 * @date 2025-02-24 22:30:40
 */
public interface NongjizulinService extends IService<NongjizulinEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<NongjizulinVO> selectListVO(Wrapper<NongjizulinEntity> wrapper);
   	
   	NongjizulinVO selectVO(@Param("ew") Wrapper<NongjizulinEntity> wrapper);
   	
   	List<NongjizulinView> selectListView(Wrapper<NongjizulinEntity> wrapper);
   	
   	NongjizulinView selectView(@Param("ew") Wrapper<NongjizulinEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<NongjizulinEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<NongjizulinEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<NongjizulinEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<NongjizulinEntity> wrapper);



}

