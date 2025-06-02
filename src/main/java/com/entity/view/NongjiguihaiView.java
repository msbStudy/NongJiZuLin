package com.entity.view;

import com.entity.NongjiguihaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 农机归还
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2025-02-24 22:30:40
 */
@TableName("nongjiguihai")
public class NongjiguihaiView  extends NongjiguihaiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public NongjiguihaiView(){
	}
 
 	public NongjiguihaiView(NongjiguihaiEntity nongjiguihaiEntity){
 	try {
			BeanUtils.copyProperties(this, nongjiguihaiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
