package com.hexinjituan.information.controller;

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

import com.hexinjituan.information.domain.JiezhengFuwuDO;
import com.hexinjituan.information.service.JiezhengFuwuService;


/**
 * 家政服务表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-08 20:22:37
 */
 
@Controller
@RequestMapping("/information/jiezhengFuwu")
public class JiezhengFuwuController {
	@Autowired
	private JiezhengFuwuService jiezhengFuwuService;
	
	@GetMapping()
	String JiezhengFuwu(){
	    return "information/jiezhengFuwu/jiezhengFuwu";
	}
	
	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<JiezhengFuwuDO> jiezhengFuwuList = jiezhengFuwuService.list(query);
		int total = jiezhengFuwuService.count(query);
		PageUtils pageUtils = new PageUtils(jiezhengFuwuList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	String add(){
	    return "information/jiezhengFuwu/add";
	}

	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Integer id,Model model){
		JiezhengFuwuDO jiezhengFuwu = jiezhengFuwuService.get(id);
		model.addAttribute("jiezhengFuwu", jiezhengFuwu);
	    return "information/jiezhengFuwu/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public R save(JiezhengFuwuDO jiezhengFuwu){
		if(jiezhengFuwuService.save(jiezhengFuwu)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update( JiezhengFuwuDO jiezhengFuwu){
		jiezhengFuwuService.update(jiezhengFuwu);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Integer id){
		if(jiezhengFuwuService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	public R remove(@RequestParam("ids[]") Integer[] ids){
		jiezhengFuwuService.batchRemove(ids);
		return R.ok();
	}
	
}
