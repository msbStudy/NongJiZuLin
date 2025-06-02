package com.entity.vo;

import com.entity.NongjisuocheEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 农机锁车
 * @author 
 * @email 
 * @date 2025-02-24 22:30:41
 */
public class NongjisuocheVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 农机编号
	 */
	
	private String nongjibianhao;
		
	/**
	 * 农机名称
	 */
	
	private String nongjimingcheng;
		
	/**
	 * 图片
	 */
	
	private String tupian;
		
	/**
	 * 型号
	 */
	
	private String xinghao;
		
	/**
	 * 租赁时间
	 */
	
	private String zulinshijian;
		
	/**
	 * 用户姓名
	 */
	
	private String yonghuxingming;
		
	/**
	 * 用户账号
	 */
	
	private String yonghuzhanghao;
		
	/**
	 * 锁车时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date suocheshijian;
		
	/**
	 * 锁车原因
	 */
	
	private String suocheyuanyin;
				
	
	/**
	 * 设置：农机编号
	 */
	 
	public void setNongjibianhao(String nongjibianhao) {
		this.nongjibianhao = nongjibianhao;
	}
	
	/**
	 * 获取：农机编号
	 */
	public String getNongjibianhao() {
		return nongjibianhao;
	}
				
	
	/**
	 * 设置：农机名称
	 */
	 
	public void setNongjimingcheng(String nongjimingcheng) {
		this.nongjimingcheng = nongjimingcheng;
	}
	
	/**
	 * 获取：农机名称
	 */
	public String getNongjimingcheng() {
		return nongjimingcheng;
	}
				
	
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
	 * 设置：租赁时间
	 */
	 
	public void setZulinshijian(String zulinshijian) {
		this.zulinshijian = zulinshijian;
	}
	
	/**
	 * 获取：租赁时间
	 */
	public String getZulinshijian() {
		return zulinshijian;
	}
				
	
	/**
	 * 设置：用户姓名
	 */
	 
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
				
	
	/**
	 * 设置：用户账号
	 */
	 
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
				
	
	/**
	 * 设置：锁车时间
	 */
	 
	public void setSuocheshijian(Date suocheshijian) {
		this.suocheshijian = suocheshijian;
	}
	
	/**
	 * 获取：锁车时间
	 */
	public Date getSuocheshijian() {
		return suocheshijian;
	}
				
	
	/**
	 * 设置：锁车原因
	 */
	 
	public void setSuocheyuanyin(String suocheyuanyin) {
		this.suocheyuanyin = suocheyuanyin;
	}
	
	/**
	 * 获取：锁车原因
	 */
	public String getSuocheyuanyin() {
		return suocheyuanyin;
	}
			
}
