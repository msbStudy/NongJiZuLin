package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.*;
import java.lang.*;
import java.math.*;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;

import com.entity.NongjizulinEntity;
import com.entity.WeixiushenqingEntity;
import com.entity.ZulinfuwuEntity;
import com.service.*;
import com.utils.*;
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

import com.entity.WeixiufenpeiEntity;
import com.entity.view.WeixiufenpeiView;

import java.io.IOException;

/**
 * 维修分配
 * 后端接口
 * @author 
 * @email 
 * @date 2025-02-24 22:30:40
 */
@RestController
@RequestMapping("/weixiufenpei")
public class WeixiufenpeiController {
    @Autowired
    private WeixiufenpeiService weixiufenpeiService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WeixiufenpeiEntity weixiufenpei,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			weixiufenpei.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        //设置查询条件
        EntityWrapper<WeixiufenpeiEntity> ew = new EntityWrapper<WeixiufenpeiEntity>();


        //查询结果
		PageUtils page = weixiufenpeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weixiufenpei), params), params));
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
    public R list(@RequestParam Map<String, Object> params,WeixiufenpeiEntity weixiufenpei, 
		HttpServletRequest request){
        //设置查询条件
        EntityWrapper<WeixiufenpeiEntity> ew = new EntityWrapper<WeixiufenpeiEntity>();

        //查询结果
		PageUtils page = weixiufenpeiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, weixiufenpei), params), params));
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(page,deSens);
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WeixiufenpeiEntity weixiufenpei){
       	EntityWrapper<WeixiufenpeiEntity> ew = new EntityWrapper<WeixiufenpeiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( weixiufenpei, "weixiufenpei")); 
        return R.ok().put("data", weixiufenpeiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WeixiufenpeiEntity weixiufenpei){
        EntityWrapper< WeixiufenpeiEntity> ew = new EntityWrapper< WeixiufenpeiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( weixiufenpei, "weixiufenpei")); 
		WeixiufenpeiView weixiufenpeiView =  weixiufenpeiService.selectView(ew);
		return R.ok("查询维修分配成功").put("data", weixiufenpeiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WeixiufenpeiEntity weixiufenpei = weixiufenpeiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(weixiufenpei,deSens);
        return R.ok().put("data", weixiufenpei);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WeixiufenpeiEntity weixiufenpei = weixiufenpeiService.selectById(id);
        Map<String, String> deSens = new HashMap<>();
        //给需要脱敏的字段脱敏
        DeSensUtil.desensitize(weixiufenpei,deSens);
        return R.ok().put("data", weixiufenpei);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增维修分配") 
    public R save(@RequestBody WeixiufenpeiEntity weixiufenpei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(weixiufenpei);
        weixiufenpeiService.insert(weixiufenpei);
        return R.ok().put("data",weixiufenpei.getId());
    }
    
    /**
     * 前台保存
     */
    @SysLog("新增维修分配")
    @RequestMapping("/add")
    public R add(@RequestBody WeixiufenpeiEntity weixiufenpei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(weixiufenpei);
        weixiufenpeiService.insert(weixiufenpei);
        return R.ok().put("data",weixiufenpei.getId());
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @SysLog("修改维修分配")
    public R update(@RequestBody WeixiufenpeiEntity weixiufenpei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(weixiufenpei);
        //全部更新
        weixiufenpeiService.updateById(weixiufenpei);
        return R.ok();
    }


    /**
     * 删除
     */
    @RequestMapping("/change")
    @SysLog("申请更换")
    public R change(@RequestBody Long id){
        WeixiufenpeiEntity weixiufenpei = new WeixiufenpeiEntity();
        weixiufenpei.setId(id);
        weixiufenpei.setWeixiuzhuangtai("申请更换");
        weixiufenpeiService.updateById(weixiufenpei);
        return R.ok();
    }
    @Autowired
    private NongjizulinService nongjizulinService;
    @Autowired
    private WeixiushenqingService weixiushenqingService;
    @Autowired
    private ZulinfuwuService zulinfuwuService;
    /**
     * 更换农机
     */
    @RequestMapping("/changeNongji")
    public R changeNongji(@RequestBody WeixiufenpeiEntity weixiufenpei){





        final Long id = weixiufenpei.getId();
          WeixiufenpeiEntity weixiufenpeiEntity = weixiufenpeiService.selectById(id);

          String bianhao = weixiufenpei.getNongjibianhao();
        final List<ZulinfuwuEntity> old = zulinfuwuService.selectList(new EntityWrapper<ZulinfuwuEntity>().eq("nongjibianhao", weixiufenpeiEntity.getNongjibianhao()));

        if(old.size()>0){
            ZulinfuwuEntity zulinfuwu = old.get(0);
            zulinfuwu.setNongjizhuangtai("空闲");
            zulinfuwuService.updateById(zulinfuwu);
        }



        Long shenqing = weixiufenpeiEntity.getCrossrefid();

        final List<ZulinfuwuEntity> nongjibianhao = zulinfuwuService.selectList(new EntityWrapper<ZulinfuwuEntity>().eq("nongjibianhao", weixiufenpei.getNongjibianhao()));
        if(nongjibianhao.size()>0){
            ZulinfuwuEntity zulinfuwu = nongjibianhao.get(0);

            weixiufenpei.setTupian(zulinfuwu.getTupian());
            weixiufenpei.setXinghao(zulinfuwu.getXinghao());
            weixiufenpei.setWeixiuzhuangtai("已完成");
            weixiufenpeiService.updateById(weixiufenpei);

            WeixiushenqingEntity weixiushenqing = new WeixiushenqingEntity();
            weixiushenqing.setNongjibianhao(zulinfuwu.getNongjibianhao());
            weixiushenqing.setNongjileixing(zulinfuwu.getNongjileixing());
            weixiushenqing.setNongjimingcheng(zulinfuwu.getNongjimingcheng());
            weixiushenqing.setTupian(zulinfuwu.getTupian());
            weixiushenqing.setXinghao(zulinfuwu.getXinghao());
            weixiushenqing.setId(shenqing);
            weixiushenqingService.updateById(weixiushenqing);

              WeixiushenqingEntity weixiushenqing1 = weixiushenqingService.selectById(shenqing);
              long id2 = weixiushenqing1.getZlid();
            NongjizulinEntity njzl = new NongjizulinEntity();

            njzl.setNongjibianhao(zulinfuwu.getNongjibianhao());
            njzl.setNongjileixing(zulinfuwu.getNongjileixing());
            njzl.setNongjimingcheng(zulinfuwu.getNongjimingcheng());
            njzl.setTupian(zulinfuwu.getTupian());
            njzl.setXinghao(zulinfuwu.getXinghao());
            njzl.setId(id2);
            nongjizulinService.updateById(njzl);
            zulinfuwu.setNongjizhuangtai("已租赁");
            zulinfuwuService.updateById(zulinfuwu);

        }






        //更新租赁申请
        //更新农机原来状态
        //更新新的农机状态




        return R.ok();
    }



    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除维修分配")
    public R delete(@RequestBody Long[] ids){
        weixiufenpeiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    








}
