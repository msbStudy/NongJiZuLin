package com.entity.vo;

import com.entity.NongjizulinEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 农机租赁
 * @author 
 * @email 
 * @date 2025-02-24 22:30:40
 */
public class NongjizulinVO  implements Serializable {
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
	 * 农机类型
	 */
	
	private String nongjileixing;
		
	/**
	 * 型号
	 */
	
	private String xinghao;
		
	/**
	 * 押金
	 */
	
	private Integer yajin;
		
	/**
	 * 日租价格
	 */
	
	private Integer rizujiage;
		
	/**
	 * 租赁天数
	 */
	
	private Integer zulintianshu;
		
	/**
	 * 租赁金额
	 */
	
	private Integer zulinjine;
		
	/**
	 * 租赁时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date zulinshijian;
		
	/**
	 * 用户姓名
	 */
	
	private String yonghuxingming;
		
	/**
	 * 用户账号
	 */
	
	private String yonghuzhanghao;
		
	/**
	 * 归还状态
	 */
	
	private String guihaizhuangtai;
		
	/**
	 * 是否支付
	 */
	
	private String ispay;
				
	
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
	 * 设置：押金
	 */
	 
	public void setYajin(Integer yajin) {
		this.yajin = yajin;
	}
	
	/**
	 * 获取：押金
	 */
	public Integer getYajin() {
		return yajin;
	}
				
	
	/**
	 * 设置：日租价格
	 */
	 
	public void setRizujiage(Integer rizujiage) {
		this.rizujiage = rizujiage;
	}
	
	/**
	 * 获取：日租价格
	 */
	public Integer getRizujiage() {
		return rizujiage;
	}
				
	
	/**
	 * 设置：租赁天数
	 */
	 
	public void setZulintianshu(Integer zulintianshu) {
		this.zulintianshu = zulintianshu;
	}
	
	/**
	 * 获取：租赁天数
	 */
	public Integer getZulintianshu() {
		return zulintianshu;
	}
				
	
	/**
	 * 设置：租赁金额
	 */
	 
	public void setZulinjine(Integer zulinjine) {
		this.zulinjine = zulinjine;
	}
	
	/**
	 * 获取：租赁金额
	 */
	public Integer getZulinjine() {
		return zulinjine;
	}
				
	
	/**
	 * 设置：租赁时间
	 */
	 
	public void setZulinshijian(Date zulinshijian) {
		this.zulinshijian = zulinshijian;
	}
	
	/**
	 * 获取：租赁时间
	 */
	public Date getZulinshijian() {
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
	 * 设置：归还状态
	 */
	 
	public void setGuihaizhuangtai(String guihaizhuangtai) {
		this.guihaizhuangtai = guihaizhuangtai;
	}
	
	/**
	 * 获取：归还状态
	 */
	public String getGuihaizhuangtai() {
		return guihaizhuangtai;
	}
				
	
	/**
	 * 设置：是否支付
	 */
	 
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}
			
}
