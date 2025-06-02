package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PingjiafankuiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PingjiafankuiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PingjiafankuiView;


/**
 * 评价反馈
 *
 * @author 
 * @email 
 * @date 2025-02-24 22:30:40
 */
public interface PingjiafankuiService extends IService<PingjiafankuiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PingjiafankuiVO> selectListVO(Wrapper<PingjiafankuiEntity> wrapper);
   	
   	PingjiafankuiVO selectVO(@Param("ew") Wrapper<PingjiafankuiEntity> wrapper);
   	
   	List<PingjiafankuiView> selectListView(Wrapper<PingjiafankuiEntity> wrapper);
   	
   	PingjiafankuiView selectView(@Param("ew") Wrapper<PingjiafankuiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PingjiafankuiEntity> wrapper);

   	

    List<Map<String, Object>> selectValue(Map<String, Object> params,Wrapper<PingjiafankuiEntity> wrapper);

    List<Map<String, Object>> selectTimeStatValue(Map<String, Object> params,Wrapper<PingjiafankuiEntity> wrapper);

    List<Map<String, Object>> selectGroup(Map<String, Object> params,Wrapper<PingjiafankuiEntity> wrapper);



}

