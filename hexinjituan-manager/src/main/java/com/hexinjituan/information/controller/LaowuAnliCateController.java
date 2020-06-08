package com.hexinjituan.information.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hexinjituan.common.utils.PageUtils;
import com.hexinjituan.common.utils.Query;
import com.hexinjituan.common.utils.R;
import com.hexinjituan.information.service.LaowuAnliService;
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

import com.hexinjituan.information.domain.LaowuAnliCateDO;
import com.hexinjituan.information.service.LaowuAnliCateService;


/**
 * 劳务案例分裂表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-08 11:24:45
 */
 
@Controller
@RequestMapping("/information/laowuAnliCate")
public class LaowuAnliCateController {
	@Autowired
	private LaowuAnliCateService laowuAnliCateService;
	@Autowired
	private LaowuAnliService laowuAnliService;
	
	@GetMapping()
	@RequiresPermissions("information:laowuAnliCate:laowuAnliCate")
	String LaowuAnliCate(){
	    return "information/laowuAnliCate/laowuAnliCate";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:laowuAnliCate:laowuAnliCate")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<LaowuAnliCateDO> laowuAnliCateList = laowuAnliCateService.list(query);
		int total = laowuAnliCateService.count(query);
		PageUtils pageUtils = new PageUtils(laowuAnliCateList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:laowuAnliCate:add")
	String add(){
	    return "information/laowuAnliCate/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:laowuAnliCate:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		LaowuAnliCateDO laowuAnliCate = laowuAnliCateService.get(id);
		model.addAttribute("laowuAnliCate", laowuAnliCate);
	    return "information/laowuAnliCate/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:laowuAnliCate:add")
	public R save( LaowuAnliCateDO laowuAnliCate){
		laowuAnliCate.setCreateTime(new Date());
		laowuAnliCate.setUpdateTime(new Date());
		laowuAnliCate.setDeleted(0);
		if(laowuAnliCateService.save(laowuAnliCate)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:laowuAnliCate:edit")
	public R update( LaowuAnliCateDO laowuAnliCate){
		laowuAnliCate.setUpdateTime(new Date());
		laowuAnliCateService.update(laowuAnliCate);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:laowuAnliCate:remove")
	public R remove( Integer id){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("cateId",id);
		map.put("deleted",0);
		int count = laowuAnliService.count(map);
		if(count>0){
			return R.error("该分类下有案例，删除所有分类写的案例后，才可将这个分类删除");
		}
		LaowuAnliCateDO laowuAnliCateDO = new LaowuAnliCateDO();
		laowuAnliCateDO.setId(id);
		laowuAnliCateDO.setDeleted(1);
		if(laowuAnliCateService.update(laowuAnliCateDO)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:laowuAnliCate:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		laowuAnliCateService.batchRemove(ids);
		return R.ok();
	}
	
}
