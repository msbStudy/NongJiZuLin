package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import com.entity.TokenEntity;
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

import com.entity.WeixiurenyuanEntity;
import com.entity.view.WeixiurenyuanView;

import com.service.WeixiurenyuanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 维修人员
 * 后端接口
 * @author 
 * @email 
 * @date 2025-02-24 22:30:39
 */
@RestController
@RequestMapping("/weixiurenyuan")
public class WeixiurenyuanController {
    @Autowired
    private WeixiurenyuanService weixiurenyuanService;






    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		// 根据登录查询用户信息
        WeixiurenyuanEntity u = weixiurenyuanService.selectOne(new EntityWrapper<WeixiurenyuanEntity>().eq("weixiuzhanghao", username));
        // 当用户不存在或md5方式验证密码不通过时
        if(u==null || !u.getMima().equals(EncryptUtil.md5(password))) {
            //账号或密码不正确提示
			return R.error("账号或密码不正确");
		}
        // 获取登录token
		String token = tokenService.generateToken(u.getId(), username,"weixiurenyuan",  "维修人员" );
        //返回token
		return R.ok().put("token", token);
	}


	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody WeixiurenyuanEntity weixiurenyuan){
    	//ValidatorUtils.validateEntity(weixiurenyuan);
        //根据登录账号获取用户信息判断是否存在该用户，否则返回错误信息
    	WeixiurenyuanEntity u = weixiurenyuanService.selectOne(new EntityWrapper<WeixiurenyuanEntity>().eq("weixiuzhanghao", weixiurenyuan.getWeixiuzhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		weixiurenyuan.setId(uId);
        //设置登录密码md5方式加密
        weixiurenyuan.setMima(EncryptUtil.md5(weixiurenyuan.getMima()));
        //保存用户
        weixiurenyuanService.insert(weixiurenyuan);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        WeixiurenyuanEntity u = weixiurenyuanService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	//根据登录账号判断是否存在用户信息，否则返回错误信息
        WeixiurenyuanEntity u = weixiurenyuanService.selectOne(new EntityWrapper<WeixiurenyuanEntity>().eq("weixiuzhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        //重置密码为123456，并使用md5方式加密
        u.setMima(EncryptUtil.md5("123456"));
        weixiurenyuanService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WeixiurenyuanEntity weixiurenyuan,
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<WeixiurenyuanEntity> ew = new EntityWrapper<WeixiurenyuanEntity>();


        //查询结果
		PageUtils page = weixiurenyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weixiurenyuan), params), params));
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
    public R list(@RequestParam Map<String, Object> params,WeixiurenyuanEntity weixiurenyuan, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<WeixiurenyuanEntity> ew = new EntityWrapper<WeixiurenyuanEntity>();

        //查询结果
		PageUtils page = weixiurenyuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weixiurenyuan), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WeixiurenyuanEntity weixiurenyuan){
       	EntityWrapper<WeixiurenyuanEntity> ew = new EntityWrapper<WeixiurenyuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( weixiurenyuan, "weixiurenyuan")); 
        return R.ok().put("data", weixiurenyuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WeixiurenyuanEntity weixiurenyuan){
        EntityWrapper< WeixiurenyuanEntity> ew = new EntityWrapper< WeixiurenyuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( weixiurenyuan, "weixiurenyuan")); 
		WeixiurenyuanView weixiurenyuanView =  weixiurenyuanService.selectView(ew);
		return R.ok("查询维修人员成功").put("data", weixiurenyuanView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WeixiurenyuanEntity weixiurenyuan = weixiurenyuanService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(weixiurenyuan,deSens);
        return R.ok().put("data", weixiurenyuan);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WeixiurenyuanEntity weixiurenyuan = weixiurenyuanService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(weixiurenyuan,deSens);
        return R.ok().put("data", weixiurenyuan);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增维修人员") 
    public R save(@RequestBody WeixiurenyuanEntity weixiurenyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(weixiurenyuan);
        //验证账号唯一性，否则返回错误信息
        WeixiurenyuanEntity u = weixiurenyuanService.selectOne(new EntityWrapper<WeixiurenyuanEntity>().eq("weixiuzhanghao", weixiurenyuan.getWeixiuzhanghao()));
        if(u!=null) {
            return R.error("用户已存在");
        }
    	weixiurenyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
		weixiurenyuan.setId(new Date().getTime());
        //密码使用md5方式加密
        weixiurenyuan.setMima(EncryptUtil.md5(weixiurenyuan.getMima()));
        weixiurenyuanService.insert(weixiurenyuan);
        return R.ok().put("data",weixiurenyuan.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增维修人员")
    @RequestMapping("/add")
    public R add(@RequestBody WeixiurenyuanEntity weixiurenyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(weixiurenyuan);
        //验证账号唯一性，否则返回错误信息
        WeixiurenyuanEntity u = weixiurenyuanService.selectOne(new EntityWrapper<WeixiurenyuanEntity>().eq("weixiuzhanghao", weixiurenyuan.getWeixiuzhanghao()));
        if(u!=null) {
            return R.error("用户已存在");
        }
    	weixiurenyuan.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
		weixiurenyuan.setId(new Date().getTime());
        //密码使用md5方式加密
        weixiurenyuan.setMima(EncryptUtil.md5(weixiurenyuan.getMima()));
        weixiurenyuanService.insert(weixiurenyuan);
        return R.ok().put("data",weixiurenyuan.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改维修人员")
    public R update(@RequestBody WeixiurenyuanEntity weixiurenyuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(weixiurenyuan);
	    WeixiurenyuanEntity weixiurenyuanEntity = weixiurenyuanService.selectById(weixiurenyuan.getId());
        //如果密码不为空，则判断是否和输入密码一致，不一致则重新设置
        if(StringUtils.isNotBlank(weixiurenyuan.getMima()) && !weixiurenyuan.getMima().equals(weixiurenyuanEntity.getMima())) {
            //密码使用md5方式加密
            weixiurenyuan.setMima(EncryptUtil.md5(weixiurenyuan.getMima()));
        }
        //全部更新
        weixiurenyuanService.updateById(weixiurenyuan);
        if(null!=weixiurenyuan.getWeixiuzhanghao())
        {
            // 修改token
            TokenEntity tokenEntity = new TokenEntity();
            tokenEntity.setUsername(weixiurenyuan.getWeixiuzhanghao());
            tokenService.update(tokenEntity, new EntityWrapper<TokenEntity>().eq("userid", weixiurenyuan.getId()));
        }
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除维修人员")
    public R delete(@RequestBody Long[] ids){
        weixiurenyuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
