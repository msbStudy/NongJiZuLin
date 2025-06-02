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
 * 使用教学
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2025-02-24 22:30:40
 */
@TableName("shiyongjiaoxue")
public class ShiyongjiaoxueEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ShiyongjiaoxueEntity() {
		
	}
	
	public ShiyongjiaoxueEntity(T t) {
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
