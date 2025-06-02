package com.entity.view;

import com.entity.ZulinfuwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 租赁服务
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-02-24 22:30:39
 */
@TableName("zulinfuwu")
public class ZulinfuwuView  extends ZulinfuwuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZulinfuwuView(){
	}
 
 	public ZulinfuwuView(ZulinfuwuEntity zulinfuwuEntity){
 	try {
			BeanUtils.copyProperties(this, zulinfuwuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
