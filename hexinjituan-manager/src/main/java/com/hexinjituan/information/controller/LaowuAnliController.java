package com.hexinjituan.information.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.hexinjituan.common.config.BootdoConfig;
import com.hexinjituan.common.utils.FileUtil;
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

import com.hexinjituan.information.domain.LaowuAnliDO;
import com.hexinjituan.information.service.LaowuAnliService;

/**
 * 劳务案例表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-08 09:59:57
 */
 
@Controller
@RequestMapping("/information/laowuAnli")
public class LaowuAnliController {
	@Autowired
	private LaowuAnliService laowuAnliService;
	@Autowired
	private BootdoConfig bootdoConfig;
	
	@GetMapping("/{id}")
	String LaowuAnli(@PathVariable("id") Integer cateId,Model model){
		model.addAttribute("cateId",cateId);
	    return "information/laowuAnli/laowuAnli";
	}
	
	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<LaowuAnliDO> laowuAnliList = laowuAnliService.list(query);
		int total = laowuAnliService.count(query);
		PageUtils pageUtils = new PageUtils(laowuAnliList, total);
		return pageUtils;
	}
	
	@GetMapping("/add/{cateId}")
	String add(@PathVariable("cateId") Integer cateId,Model model){
		model.addAttribute("cateId",cateId);
	    return "information/laowuAnli/add";
	}

	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Integer id,Model model){
		LaowuAnliDO laowuAnli = laowuAnliService.get(id);
		model.addAttribute("laowuAnli", laowuAnli);
	    return "information/laowuAnli/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public R save( LaowuAnliDO laowuAnli){
		try {
			if(laowuAnli.getImgFile()!=null && !laowuAnli.getImgFile().isEmpty()) {
				String fileName = laowuAnli.getImgFile().getOriginalFilename();
				fileName = FileUtil.renameToUUID(fileName);
				FileUtil.uploadFile(laowuAnli.getImgFile().getBytes(), bootdoConfig.getUploadPath(), fileName);
				laowuAnli.setUrl("/files/" + fileName);
			}
		} catch (Exception e) {
			return R.error();
		}
		laowuAnli.setDeleted(0);
		laowuAnli.setCreateTime(new Date());
		laowuAnli.setUpdateTime(new Date());
		if(laowuAnliService.save(laowuAnli)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update( LaowuAnliDO laowuAnli){
		try {
			if(laowuAnli.getImgFile()!=null && !laowuAnli.getImgFile().isEmpty()) {
				String fileName = laowuAnli.getImgFile().getOriginalFilename();
				fileName = FileUtil.renameToUUID(fileName);
				FileUtil.uploadFile(laowuAnli.getImgFile().getBytes(), bootdoConfig.getUploadPath(), fileName);
				laowuAnli.setUrl("/files/" + fileName);
			}
		} catch (Exception e) {
			return R.error();
		}
		laowuAnli.setUpdateTime(new Date());
		laowuAnliService.update(laowuAnli);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Integer id){
		LaowuAnliDO laowuAnliDO = new LaowuAnliDO();
		laowuAnliDO.setDeleted(1);
		laowuAnliDO.setId(id);
		if(laowuAnliService.update(laowuAnliDO)>0){
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
		laowuAnliService.batchRemove(ids);
		return R.ok();
	}
	
}
