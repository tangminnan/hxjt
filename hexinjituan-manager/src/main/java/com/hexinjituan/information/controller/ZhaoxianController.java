package com.hexinjituan.information.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.hexinjituan.common.utils.PageUtils;
import com.hexinjituan.common.utils.Query;
import com.hexinjituan.common.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hexinjituan.information.domain.ZhaoxianDO;
import com.hexinjituan.information.service.ZhaoxianService;

/**
 * 招聘表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-08 14:10:07
 */
 
@Controller
@RequestMapping("/information/zhaoxian")
public class ZhaoxianController {
	@Autowired
	private ZhaoxianService zhaoxianService;
	
	@GetMapping()
	@RequiresPermissions("information:zhaoxian:zhaoxian")
	String Zhaoxian(){
	    return "information/zhaoxian/zhaoxian";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:zhaoxian:zhaoxian")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<ZhaoxianDO> zhaoxianList = zhaoxianService.list(query);
		int total = zhaoxianService.count(query);
		PageUtils pageUtils = new PageUtils(zhaoxianList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:zhaoxian:add")
	String add(){
	    return "information/zhaoxian/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:zhaoxian:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		ZhaoxianDO zhaoxian = zhaoxianService.get(id);
		model.addAttribute("zhaoxian", zhaoxian);
	    return "information/zhaoxian/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:zhaoxian:add")
	public R save( ZhaoxianDO zhaoxian){
		zhaoxian.setCreateTime(new Date());
		zhaoxian.setUpdateTime(new Date());
		zhaoxian.setDeleted(0);
		if(zhaoxianService.save(zhaoxian)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:zhaoxian:edit")
	public R update( ZhaoxianDO zhaoxian){
		zhaoxian.setUpdateTime(new Date());
		zhaoxianService.update(zhaoxian);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:zhaoxian:remove")
	public R remove( Integer id){
		ZhaoxianDO zhaoxianDO = new ZhaoxianDO();
		zhaoxianDO.setDeleted(1);
		zhaoxianDO.setId(id);
		if(zhaoxianService.update(zhaoxianDO)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:zhaoxian:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		zhaoxianService.batchRemove(ids);
		return R.ok();
	}
	
}
