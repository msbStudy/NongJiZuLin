package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 农机锁车
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-02-24 22:30:41
 */
@TableName("nongjisuoche")
public class NongjisuocheEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public NongjisuocheEntity() {
		
	}
	
	public NongjisuocheEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
	private Long id;
	/**
	 * 租赁编号
	 */
					
	private String zulinbianhao;
	
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
	 * 状态 锁车 已解锁
	 */
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

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
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：租赁编号
	 */
	public void setZulinbianhao(String zulinbianhao) {
		this.zulinbianhao = zulinbianhao;
	}
	/**
	 * 获取：租赁编号
	 */
	public String getZulinbianhao() {
		return zulinbianhao;
	}
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
