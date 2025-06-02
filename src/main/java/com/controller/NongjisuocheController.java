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

import com.entity.NongjisuocheEntity;
import com.entity.view.NongjisuocheView;

import com.service.NongjisuocheService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 农机锁车
 * 后端接口
 * @author 
 * @email 
 * @date 2025-02-24 22:30:41
 */
@RestController
@RequestMapping("/nongjisuoche")
public class NongjisuocheController {
    @Autowired
    private NongjisuocheService nongjisuocheService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,NongjisuocheEntity nongjisuoche,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			nongjisuoche.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<NongjisuocheEntity> ew = new EntityWrapper<NongjisuocheEntity>();


        //查询结果
		PageUtils page = nongjisuocheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nongjisuoche), params), params));
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
    public R list(@RequestParam Map<String, Object> params,NongjisuocheEntity nongjisuoche, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<NongjisuocheEntity> ew = new EntityWrapper<NongjisuocheEntity>();

        //查询结果
		PageUtils page = nongjisuocheService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, nongjisuoche), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( NongjisuocheEntity nongjisuoche){
       	EntityWrapper<NongjisuocheEntity> ew = new EntityWrapper<NongjisuocheEntity>();
      	ew.allEq(MPUtil.allEQMapPre( nongjisuoche, "nongjisuoche")); 
        return R.ok().put("data", nongjisuocheService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(NongjisuocheEntity nongjisuoche){
        EntityWrapper< NongjisuocheEntity> ew = new EntityWrapper< NongjisuocheEntity>();
 		ew.allEq(MPUtil.allEQMapPre( nongjisuoche, "nongjisuoche")); 
		NongjisuocheView nongjisuocheView =  nongjisuocheService.selectView(ew);
		return R.ok("查询农机锁车成功").put("data", nongjisuocheView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        NongjisuocheEntity nongjisuoche = nongjisuocheService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(nongjisuoche,deSens);
        return R.ok().put("data", nongjisuoche);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        NongjisuocheEntity nongjisuoche = nongjisuocheService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(nongjisuoche,deSens);
        return R.ok().put("data", nongjisuoche);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增农机锁车") 
    public R save(@RequestBody NongjisuocheEntity nongjisuoche, HttpServletRequest request){
        //ValidatorUtils.validateEntity(nongjisuoche);
        nongjisuoche.setStatus("已锁车");
        nongjisuocheService.insert(nongjisuoche);
        return R.ok().put("data",nongjisuoche.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增农机锁车")
    @RequestMapping("/add")
    public R add(@RequestBody NongjisuocheEntity nongjisuoche, HttpServletRequest request){
        //ValidatorUtils.validateEntity(nongjisuoche);
        nongjisuocheService.insert(nongjisuoche);
        return R.ok().put("data",nongjisuoche.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改农机锁车")
    public R update(@RequestBody NongjisuocheEntity nongjisuoche, HttpServletRequest request){
        //ValidatorUtils.validateEntity(nongjisuoche);
        //全部更新
        nongjisuocheService.updateById(nongjisuoche);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除农机锁车")
    public R delete(@RequestBody Long[] ids){
        nongjisuocheService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }





    /**
     * 删除
     */
    @RequestMapping("/changeStatus")
    @SysLog("农机解锁")
    public R changeStatus(@RequestBody Long id){
        NongjisuocheEntity nongjisuoche = new NongjisuocheEntity();
        nongjisuoche.setStatus("已解锁");
        nongjisuoche.setId(id);
        nongjisuocheService.updateById(nongjisuoche);
        return R.ok();
    }





}
