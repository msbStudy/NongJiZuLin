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

import com.entity.NongjileixingEntity;
import com.entity.view.NongjileixingView;

import com.service.NongjileixingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 农机类型
 * 后端接口
 * @author 
 * @email 
 * @date 2025-02-24 22:30:39
 */
@RestController
@RequestMapping("/nongjileixing")
public class NongjileixingController {
    @Autowired
    private NongjileixingService nongjileixingService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,NongjileixingEntity nongjileixing,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<NongjileixingEntity> ew = new EntityWrapper<NongjileixingEntity>();


        //查询结果
		PageUtils page = nongjileixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nongjileixing), params), params));
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
    public R list(@RequestParam Map<String, Object> params,NongjileixingEntity nongjileixing, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<NongjileixingEntity> ew = new EntityWrapper<NongjileixingEntity>();

        //查询结果
		PageUtils page = nongjileixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nongjileixing), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( NongjileixingEntity nongjileixing){
       	EntityWrapper<NongjileixingEntity> ew = new EntityWrapper<NongjileixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( nongjileixing, "nongjileixing")); 
        return R.ok().put("data", nongjileixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(NongjileixingEntity nongjileixing){
        EntityWrapper< NongjileixingEntity> ew = new EntityWrapper< NongjileixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( nongjileixing, "nongjileixing")); 
		NongjileixingView nongjileixingView =  nongjileixingService.selectView(ew);
		return R.ok("查询农机类型成功").put("data", nongjileixingView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        NongjileixingEntity nongjileixing = nongjileixingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(nongjileixing,deSens);
        return R.ok().put("data", nongjileixing);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        NongjileixingEntity nongjileixing = nongjileixingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(nongjileixing,deSens);
        return R.ok().put("data", nongjileixing);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增农机类型") 
    public R save(@RequestBody NongjileixingEntity nongjileixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(nongjileixing);
        nongjileixingService.insert(nongjileixing);
        return R.ok().put("data",nongjileixing.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增农机类型")
    @RequestMapping("/add")
    public R add(@RequestBody NongjileixingEntity nongjileixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(nongjileixing);
        nongjileixingService.insert(nongjileixing);
        return R.ok().put("data",nongjileixing.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改农机类型")
    public R update(@RequestBody NongjileixingEntity nongjileixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(nongjileixing);
        //全部更新
        nongjileixingService.updateById(nongjileixing);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除农机类型")
    public R delete(@RequestBody Long[] ids){
        nongjileixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
