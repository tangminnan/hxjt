package com.hexinjituan.information.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.hexinjituan.carousel.domain.BannerDO;
import com.hexinjituan.common.config.BootdoConfig;
import com.hexinjituan.common.utils.*;
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

import com.hexinjituan.information.domain.StudentsElegantDO;
import com.hexinjituan.information.service.StudentsElegantService;
/**
 * 轮播图表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-02 10:21:35
 */
 
@Controller
@RequestMapping("/information/studentsElegant")
public class StudentsElegantController {
	@Autowired
	private StudentsElegantService studentsElegantService;
	@Autowired
	private BootdoConfig bootdoConfig;
	
	@GetMapping("/{typeName}")
	@RequiresPermissions("information:studentsElegant:studentsElegant")
	String StudentsElegant(@PathVariable("typeName") String typeName,Model model){
		model.addAttribute("typeName",typeName);
	    return "information/studentsElegant/studentsElegant";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:studentsElegant:studentsElegant")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<StudentsElegantDO> studentsElegantList = studentsElegantService.list(query);
		int total = studentsElegantService.count(query);
		PageUtils pageUtils = new PageUtils(studentsElegantList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:studentsElegant:add")
	String add(){
	    return "information/studentsElegant/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:studentsElegant:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		StudentsElegantDO studentsElegant = studentsElegantService.get(id);
		model.addAttribute("studentsElegant", studentsElegant);
	    return "information/studentsElegant/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:studentsElegant:add")
	public R save(StudentsElegantDO studentsElegant){
		if(studentsElegant.getImgFile() != null && studentsElegant.getImgFile().getSize() > 0){
			String fileName = studentsElegant.getImgFile().getOriginalFilename();
			fileName = FileUtil.renameToUUID(fileName);
			try {
				FileUtil.uploadFile(studentsElegant.getImgFile().getBytes(), bootdoConfig.getUploadPath(), fileName);
				studentsElegant.setUrl("/files/" + fileName);
			} catch (Exception e) {
				return R.error();
			}

		}
		studentsElegant.setUserId(ShiroUtils.getUserId());
		studentsElegant.setAddTime(new Date());
		studentsElegant.setUpdateTime(new Date());
		studentsElegant.setDeleteFlag(0);
		if(studentsElegantService.save(studentsElegant)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:studentsElegant:edit")
	public R update( StudentsElegantDO studentsElegant){
		System.out.println("================");
		if(studentsElegant.getImgFile() != null && studentsElegant.getImgFile().getSize() > 0){
			String fileName = studentsElegant.getImgFile().getOriginalFilename();
			fileName = FileUtil.renameToUUID(fileName);
			try {
				FileUtil.uploadFile(studentsElegant.getImgFile().getBytes(), bootdoConfig.getUploadPath(), fileName);
				studentsElegant.setUrl("/files/" + fileName);
			} catch (Exception e) {
				return R.error();
			}

		}
		studentsElegant.setUpdateTime(new Date());
		studentsElegantService.update(studentsElegant);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:studentsElegant:remove")
	public R remove( Integer id){
		StudentsElegantDO studentsElegantDO = new StudentsElegantDO();
		studentsElegantDO.setDeleteFlag(1);
		studentsElegantDO.setId(id);
		if(studentsElegantService.update(studentsElegantDO)>0){
		return R.ok();
		}
		return R.error();
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping(value="/updateEnable")
	public R updateEnable(Integer id,Integer enable) {
		StudentsElegantDO studentsElegantDO = studentsElegantService.get(id);
		studentsElegantDO.setIsEnable(enable);
		studentsElegantService.update(studentsElegantDO);
		return R.ok();
	}


	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:studentsElegant:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		studentsElegantService.batchRemove(ids);
		return R.ok();
	}
	
}
