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

import com.entity.WeixiushenqingEntity;
import com.entity.view.WeixiushenqingView;

import com.service.WeixiushenqingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 维修申请
 * 后端接口
 * @author 
 * @email 
 * @date 2025-02-24 22:30:40
 */
@RestController
@RequestMapping("/weixiushenqing")
public class WeixiushenqingController {
    @Autowired
    private WeixiushenqingService weixiushenqingService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WeixiushenqingEntity weixiushenqing,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			weixiushenqing.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<WeixiushenqingEntity> ew = new EntityWrapper<WeixiushenqingEntity>();


        //查询结果
		PageUtils page = weixiushenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weixiushenqing), params), params));
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
    public R list(@RequestParam Map<String, Object> params,WeixiushenqingEntity weixiushenqing, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<WeixiushenqingEntity> ew = new EntityWrapper<WeixiushenqingEntity>();

        //查询结果
		PageUtils page = weixiushenqingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weixiushenqing), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WeixiushenqingEntity weixiushenqing){
       	EntityWrapper<WeixiushenqingEntity> ew = new EntityWrapper<WeixiushenqingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( weixiushenqing, "weixiushenqing")); 
        return R.ok().put("data", weixiushenqingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WeixiushenqingEntity weixiushenqing){
        EntityWrapper< WeixiushenqingEntity> ew = new EntityWrapper< WeixiushenqingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( weixiushenqing, "weixiushenqing")); 
		WeixiushenqingView weixiushenqingView =  weixiushenqingService.selectView(ew);
		return R.ok("查询维修申请成功").put("data", weixiushenqingView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WeixiushenqingEntity weixiushenqing = weixiushenqingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(weixiushenqing,deSens);
        return R.ok().put("data", weixiushenqing);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WeixiushenqingEntity weixiushenqing = weixiushenqingService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(weixiushenqing,deSens);
        return R.ok().put("data", weixiushenqing);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增维修申请") 
    public R save(@RequestBody WeixiushenqingEntity weixiushenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(weixiushenqing);
        weixiushenqingService.insert(weixiushenqing);
        return R.ok().put("data",weixiushenqing.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增维修申请")
    @RequestMapping("/add")
    public R add(@RequestBody WeixiushenqingEntity weixiushenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(weixiushenqing);
        weixiushenqingService.insert(weixiushenqing);



        return R.ok().put("data",weixiushenqing.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改维修申请")
    public R update(@RequestBody WeixiushenqingEntity weixiushenqing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(weixiushenqing);
        //全部更新
        weixiushenqingService.updateById(weixiushenqing);
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    @SysLog("审核维修申请")
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<WeixiushenqingEntity> list = new ArrayList<WeixiushenqingEntity>();
        for(Long id : ids) {
            WeixiushenqingEntity weixiushenqing = weixiushenqingService.selectById(id);
            weixiushenqing.setSfsh(sfsh);
            weixiushenqing.setShhf(shhf);
            list.add(weixiushenqing);
        }
        weixiushenqingService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除维修申请")
    public R delete(@RequestBody Long[] ids){
        weixiushenqingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
