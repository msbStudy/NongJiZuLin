package com.entity.vo;

import com.entity.ShiyongjiaoxueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 使用教学
 * @author 
 * @email 
 * @date 2025-02-24 22:30:40
 */
public class ShiyongjiaoxueVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 农机类型
	 */
	
	private String nongjileixing;
		
	/**
	 * 型号
	 */
	
	private String xinghao;
		
	/**
	 * 注意事项
	 */
	
	private String zhuyishixiang;
		
	/**
	 * 操作手册
	 */
	
	private String caozuoshouce;
		
	/**
	 * 操作视频
	 */
	
	private String caozuoshipin;
		
	/**
	 * 收藏数
	 */
	
	private Integer storeupnum;
				
	
	/**
	 * 设置：图片
	 */
	 
	public void setTupian(String tupian) {
		this.tupian = tupian;
	}
	
	/**
	 * 获取：图片
	 */
	public String getTupian() {
		return tupian;
	}
				
	
	/**
	 * 设置：农机类型
	 */
	 
	public void setNongjileixing(String nongjileixing) {
		this.nongjileixing = nongjileixing;
	}
	
	/**
	 * 获取：农机类型
	 */
	public String getNongjileixing() {
		return nongjileixing;
	}
				
	
	/**
	 * 设置：型号
	 */
	 
	public void setXinghao(String xinghao) {
		this.xinghao = xinghao;
	}
	
	/**
	 * 获取：型号
	 */
	public String getXinghao() {
		return xinghao;
	}
				
	
	/**
	 * 设置：注意事项
	 */
	 
	public void setZhuyishixiang(String zhuyishixiang) {
		this.zhuyishixiang = zhuyishixiang;
	}
	
	/**
	 * 获取：注意事项
	 */
	public String getZhuyishixiang() {
		return zhuyishixiang;
	}
				
	
	/**
	 * 设置：操作手册
	 */
	 
	public void setCaozuoshouce(String caozuoshouce) {
		this.caozuoshouce = caozuoshouce;
	}
	
	/**
	 * 获取：操作手册
	 */
	public String getCaozuoshouce() {
		return caozuoshouce;
	}
				
	
	/**
	 * 设置：操作视频
	 */
	 
	public void setCaozuoshipin(String caozuoshipin) {
		this.caozuoshipin = caozuoshipin;
	}
	
	/**
	 * 获取：操作视频
	 */
	public String getCaozuoshipin() {
		return caozuoshipin;
	}
				
	
	/**
	 * 设置：收藏数
	 */
	 
	public void setStoreupnum(Integer storeupnum) {
		this.storeupnum = storeupnum;
	}
	
	/**
	 * 获取：收藏数
	 */
	public Integer getStoreupnum() {
		return storeupnum;
	}
			
}
