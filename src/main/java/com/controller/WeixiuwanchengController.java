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

import com.entity.WeixiuwanchengEntity;
import com.entity.view.WeixiuwanchengView;

import com.service.WeixiuwanchengService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 维修完成
 * 后端接口
 * @author 
 * @email 
 * @date 2025-02-24 22:30:41
 */
@RestController
@RequestMapping("/weixiuwancheng")
public class WeixiuwanchengController {
    @Autowired
    private WeixiuwanchengService weixiuwanchengService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WeixiuwanchengEntity weixiuwancheng,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			weixiuwancheng.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<WeixiuwanchengEntity> ew = new EntityWrapper<WeixiuwanchengEntity>();


        //查询结果
		PageUtils page = weixiuwanchengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weixiuwancheng), params), params));
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
    public R list(@RequestParam Map<String, Object> params,WeixiuwanchengEntity weixiuwancheng, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<WeixiuwanchengEntity> ew = new EntityWrapper<WeixiuwanchengEntity>();

        //查询结果
		PageUtils page = weixiuwanchengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weixiuwancheng), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WeixiuwanchengEntity weixiuwancheng){
       	EntityWrapper<WeixiuwanchengEntity> ew = new EntityWrapper<WeixiuwanchengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( weixiuwancheng, "weixiuwancheng")); 
        return R.ok().put("data", weixiuwanchengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WeixiuwanchengEntity weixiuwancheng){
        EntityWrapper< WeixiuwanchengEntity> ew = new EntityWrapper< WeixiuwanchengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( weixiuwancheng, "weixiuwancheng")); 
		WeixiuwanchengView weixiuwanchengView =  weixiuwanchengService.selectView(ew);
		return R.ok("查询维修完成成功").put("data", weixiuwanchengView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WeixiuwanchengEntity weixiuwancheng = weixiuwanchengService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(weixiuwancheng,deSens);
        return R.ok().put("data", weixiuwancheng);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WeixiuwanchengEntity weixiuwancheng = weixiuwanchengService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(weixiuwancheng,deSens);
        return R.ok().put("data", weixiuwancheng);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增维修完成") 
    public R save(@RequestBody WeixiuwanchengEntity weixiuwancheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(weixiuwancheng);
        weixiuwanchengService.insert(weixiuwancheng);
        return R.ok().put("data",weixiuwancheng.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增维修完成")
    @RequestMapping("/add")
    public R add(@RequestBody WeixiuwanchengEntity weixiuwancheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(weixiuwancheng);
        weixiuwanchengService.insert(weixiuwancheng);
        return R.ok().put("data",weixiuwancheng.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改维修完成")
    public R update(@RequestBody WeixiuwanchengEntity weixiuwancheng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(weixiuwancheng);
        //全部更新
        weixiuwanchengService.updateById(weixiuwancheng);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除维修完成")
    public R delete(@RequestBody Long[] ids){
        weixiuwanchengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
