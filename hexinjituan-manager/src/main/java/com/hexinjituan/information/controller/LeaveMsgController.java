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

import com.hexinjituan.information.domain.LeaveMsgDO;
import com.hexinjituan.information.service.LeaveMsgService;


/**
 * 留言表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-08 19:38:13
 */
 
@Controller
@RequestMapping("/information/leaveMsg")
public class LeaveMsgController {
	@Autowired
	private LeaveMsgService leaveMsgService;
	
	@GetMapping()
	String LeaveMsg(){
	    return "information/leaveMsg/leaveMsg";
	}
	
	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<LeaveMsgDO> leaveMsgList = leaveMsgService.list(query);
		int total = leaveMsgService.count(query);
		PageUtils pageUtils = new PageUtils(leaveMsgList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	String add(){
	    return "information/leaveMsg/add";
	}

	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Integer id,Model model){
		LeaveMsgDO leaveMsg = leaveMsgService.get(id);
		model.addAttribute("leaveMsg", leaveMsg);
	    return "information/leaveMsg/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public R save( LeaveMsgDO leaveMsg){
		if(leaveMsgService.save(leaveMsg)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update( LeaveMsgDO leaveMsg){
		leaveMsgService.update(leaveMsg);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Integer id){
		LeaveMsgDO leaveMsgDO = new LeaveMsgDO();
		leaveMsgDO.setId(id);
		leaveMsgDO.setDeleted(1);
		if(leaveMsgService.update(leaveMsgDO)>0){
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
		leaveMsgService.batchRemove(ids);
		return R.ok();
	}
	
}
