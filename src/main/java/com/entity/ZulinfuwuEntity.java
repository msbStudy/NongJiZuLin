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
 * 租赁服务
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-02-24 22:30:39
 */
@TableName("zulinfuwu")
public class ZulinfuwuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ZulinfuwuEntity() {
		
	}
	
	public ZulinfuwuEntity(T t) {
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
	 * 性能参数
	 */
					
	private String xingnengcanshu;
	
	/**
	 * 押金
	 */
					
	private Integer yajin;
	
	/**
	 * 日租价格
	 */
					
	private Integer rizujiage;
	
	/**
	 * 农机状态
	 */
					
	private String nongjizhuangtai;
	
	/**
	 * 农机详情
	 */
					
	private String nongjixiangqing;
	
	/**
	 * 最近点击时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date clicktime;
	
	/**
	 * 收藏数
	 */
					
	private Integer storeupnum;
	
	
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
	 * 设置：性能参数
	 */
	public void setXingnengcanshu(String xingnengcanshu) {
		this.xingnengcanshu = xingnengcanshu;
	}
	/**
	 * 获取：性能参数
	 */
	public String getXingnengcanshu() {
		return xingnengcanshu;
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
	 * 设置：农机状态
	 */
	public void setNongjizhuangtai(String nongjizhuangtai) {
		this.nongjizhuangtai = nongjizhuangtai;
	}
	/**
	 * 获取：农机状态
	 */
	public String getNongjizhuangtai() {
		return nongjizhuangtai;
	}
	/**
	 * 设置：农机详情
	 */
	public void setNongjixiangqing(String nongjixiangqing) {
		this.nongjixiangqing = nongjixiangqing;
	}
	/**
	 * 获取：农机详情
	 */
	public String getNongjixiangqing() {
		return nongjixiangqing;
	}
	/**
	 * 设置：最近点击时间
	 */
	public void setClicktime(Date clicktime) {
		this.clicktime = clicktime;
	}
	/**
	 * 获取：最近点击时间
	 */
	public Date getClicktime() {
		return clicktime;
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
