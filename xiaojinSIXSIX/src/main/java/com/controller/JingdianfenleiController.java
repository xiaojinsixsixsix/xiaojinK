package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
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

import com.entity.JingdianfenleiEntity;
import com.entity.view.JingdianfenleiView;

import com.service.JingdianfenleiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 景点分类
 * 后端接口
 * @author 
 * @email 
 * @date 2024-05-06 14:36:31
 */
@RestController
@RequestMapping("/jingdianfenlei")
public class JingdianfenleiController {
    @Autowired
    private JingdianfenleiService jingdianfenleiService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JingdianfenleiEntity jingdianfenlei,
		HttpServletRequest request){
        EntityWrapper<JingdianfenleiEntity> ew = new EntityWrapper<JingdianfenleiEntity>();

		PageUtils page = jingdianfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingdianfenlei), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JingdianfenleiEntity jingdianfenlei, 
		HttpServletRequest request){
        EntityWrapper<JingdianfenleiEntity> ew = new EntityWrapper<JingdianfenleiEntity>();

		PageUtils page = jingdianfenleiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jingdianfenlei), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JingdianfenleiEntity jingdianfenlei){
       	EntityWrapper<JingdianfenleiEntity> ew = new EntityWrapper<JingdianfenleiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jingdianfenlei, "jingdianfenlei")); 
        return R.ok().put("data", jingdianfenleiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JingdianfenleiEntity jingdianfenlei){
        EntityWrapper< JingdianfenleiEntity> ew = new EntityWrapper< JingdianfenleiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jingdianfenlei, "jingdianfenlei")); 
		JingdianfenleiView jingdianfenleiView =  jingdianfenleiService.selectView(ew);
		return R.ok("查询景点分类成功").put("data", jingdianfenleiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JingdianfenleiEntity jingdianfenlei = jingdianfenleiService.selectById(id);
        return R.ok().put("data", jingdianfenlei);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JingdianfenleiEntity jingdianfenlei = jingdianfenleiService.selectById(id);
        return R.ok().put("data", jingdianfenlei);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JingdianfenleiEntity jingdianfenlei, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jingdianfenlei);
        jingdianfenleiService.insert(jingdianfenlei);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JingdianfenleiEntity jingdianfenlei, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(jingdianfenlei);
        jingdianfenleiService.insert(jingdianfenlei);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody JingdianfenleiEntity jingdianfenlei, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jingdianfenlei);
        jingdianfenleiService.updateById(jingdianfenlei);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jingdianfenleiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
