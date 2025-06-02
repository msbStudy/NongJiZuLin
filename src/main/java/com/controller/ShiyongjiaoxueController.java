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

import com.entity.ShiyongjiaoxueEntity;
import com.entity.view.ShiyongjiaoxueView;

import com.service.ShiyongjiaoxueService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 使用教学
 * 后端接口
 * @author 
 * @email 
 * @date 2025-02-24 22:30:40
 */
@RestController
@RequestMapping("/shiyongjiaoxue")
public class ShiyongjiaoxueController {
    @Autowired
    private ShiyongjiaoxueService shiyongjiaoxueService;

    @Autowired
    private StoreupService storeupService;





    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShiyongjiaoxueEntity shiyongjiaoxue,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ShiyongjiaoxueEntity> ew = new EntityWrapper<ShiyongjiaoxueEntity>();


        //查询结果
		PageUtils page = shiyongjiaoxueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shiyongjiaoxue), params), params));
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
    public R list(@RequestParam Map<String, Object> params,ShiyongjiaoxueEntity shiyongjiaoxue, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<ShiyongjiaoxueEntity> ew = new EntityWrapper<ShiyongjiaoxueEntity>();

        //查询结果
		PageUtils page = shiyongjiaoxueService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shiyongjiaoxue), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShiyongjiaoxueEntity shiyongjiaoxue){
       	EntityWrapper<ShiyongjiaoxueEntity> ew = new EntityWrapper<ShiyongjiaoxueEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shiyongjiaoxue, "shiyongjiaoxue")); 
        return R.ok().put("data", shiyongjiaoxueService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShiyongjiaoxueEntity shiyongjiaoxue){
        EntityWrapper< ShiyongjiaoxueEntity> ew = new EntityWrapper< ShiyongjiaoxueEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shiyongjiaoxue, "shiyongjiaoxue")); 
		ShiyongjiaoxueView shiyongjiaoxueView =  shiyongjiaoxueService.selectView(ew);
		return R.ok("查询使用教学成功").put("data", shiyongjiaoxueView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShiyongjiaoxueEntity shiyongjiaoxue = shiyongjiaoxueService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shiyongjiaoxue,deSens);
        return R.ok().put("data", shiyongjiaoxue);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShiyongjiaoxueEntity shiyongjiaoxue = shiyongjiaoxueService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(shiyongjiaoxue,deSens);
        return R.ok().put("data", shiyongjiaoxue);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增使用教学") 
    public R save(@RequestBody ShiyongjiaoxueEntity shiyongjiaoxue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shiyongjiaoxue);
        shiyongjiaoxueService.insert(shiyongjiaoxue);
        return R.ok().put("data",shiyongjiaoxue.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增使用教学")
    @RequestMapping("/add")
    public R add(@RequestBody ShiyongjiaoxueEntity shiyongjiaoxue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shiyongjiaoxue);
        shiyongjiaoxueService.insert(shiyongjiaoxue);
        return R.ok().put("data",shiyongjiaoxue.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改使用教学")
    public R update(@RequestBody ShiyongjiaoxueEntity shiyongjiaoxue, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shiyongjiaoxue);
        //全部更新
        shiyongjiaoxueService.updateById(shiyongjiaoxue);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除使用教学")
    public R delete(@RequestBody Long[] ids){
        shiyongjiaoxueService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
