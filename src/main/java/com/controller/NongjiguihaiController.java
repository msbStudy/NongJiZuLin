package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.utils.ValidatorUtils;
import com.utils.DeSensUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;
import com.annotation.SysLog;

import com.entity.NongjiguihaiEntity;
import com.entity.view.NongjiguihaiView;

import com.service.NongjiguihaiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 农机归还
 * 后端接口
 * @author 
 * @email 
 * @date 2025-02-24 22:30:40
 */
@RestController
@RequestMapping("/nongjiguihai")
public class NongjiguihaiController {
    @Autowired
    private NongjiguihaiService nongjiguihaiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,NongjiguihaiEntity nongjiguihai,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			nongjiguihai.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<NongjiguihaiEntity> ew = new EntityWrapper<NongjiguihaiEntity>();


        //查询结果
		PageUtils page = nongjiguihaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nongjiguihai), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,NongjiguihaiEntity nongjiguihai, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<NongjiguihaiEntity> ew = new EntityWrapper<NongjiguihaiEntity>();

        //查询结果
		PageUtils page = nongjiguihaiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nongjiguihai), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( NongjiguihaiEntity nongjiguihai){
       	EntityWrapper<NongjiguihaiEntity> ew = new EntityWrapper<NongjiguihaiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( nongjiguihai, "nongjiguihai")); 
        return R.ok().put("data", nongjiguihaiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(NongjiguihaiEntity nongjiguihai){
        EntityWrapper< NongjiguihaiEntity> ew = new EntityWrapper< NongjiguihaiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( nongjiguihai, "nongjiguihai")); 
		NongjiguihaiView nongjiguihaiView =  nongjiguihaiService.selectView(ew);
		return R.ok("查询农机归还成功").put("data", nongjiguihaiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        NongjiguihaiEntity nongjiguihai = nongjiguihaiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(nongjiguihai,deSens);
        return R.ok().put("data", nongjiguihai);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        NongjiguihaiEntity nongjiguihai = nongjiguihaiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(nongjiguihai,deSens);
        return R.ok().put("data", nongjiguihai);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增农机归还") 
    public R save(@RequestBody NongjiguihaiEntity nongjiguihai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(nongjiguihai);
        nongjiguihaiService.insert(nongjiguihai);
        return R.ok().put("data",nongjiguihai.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增农机归还")
    @RequestMapping("/add")
    public R add(@RequestBody NongjiguihaiEntity nongjiguihai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(nongjiguihai);
        nongjiguihaiService.insert(nongjiguihai);
        return R.ok().put("data",nongjiguihai.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改农机归还")
    public R update(@RequestBody NongjiguihaiEntity nongjiguihai, HttpServletRequest request){
        //ValidatorUtils.validateEntity(nongjiguihai);
        //全部更新
        nongjiguihaiService.updateById(nongjiguihai);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除农机归还")
    public R delete(@RequestBody Long[] ids){
        nongjiguihaiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
