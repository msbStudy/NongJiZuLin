package com.controller;

import com.annotation.IgnoreAuth;
import com.annotation.SysLog;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.entity.DriverEntity;
import com.entity.NewsEntity;
import com.entity.StoreupEntity;
import com.entity.view.NewsView;
import com.service.DriverService;
import com.service.NewsService;
import com.service.StoreupService;
import com.utils.DeSensUtil;
import com.utils.MPUtil;
import com.utils.PageUtils;
import com.utils.R;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 公告信息
 * 后端接口
 * @author 
 * @email 
 * @date 2025-02-24 22:30:41
 */
@RestController
@RequestMapping("/driver")
public class DriverController {
    @Autowired
    private DriverService driverService;






    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, DriverEntity news,
                  HttpServletRequest request){
        //设置查询条件
        EntityWrapper<DriverEntity> ew = new EntityWrapper<DriverEntity>();

        PageUtils page = driverService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, news), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DriverEntity news){
       	EntityWrapper<DriverEntity> ew = new EntityWrapper<DriverEntity>();

        return R.ok().put("data", driverService.selectList(ew));
    }


	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DriverEntity news = driverService.selectById(id);

        return R.ok().put("data", news);
    }




    /**
     * 后台保存
     */
    @RequestMapping("/save")
    @SysLog("新增公告信息") 
    public R save(@RequestBody DriverEntity news, HttpServletRequest request){
        //ValidatorUtils.validateEntity(news);
        driverService.insert(news);
        return R.ok().put("data",news.getId());
    }
    




    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DriverEntity news, HttpServletRequest request){

        //全部更新
        driverService.updateById(news);
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @SysLog("删除公告信息")
    public R delete(@RequestBody Long[] ids){
        driverService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    







}
