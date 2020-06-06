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

import com.hexinjituan.information.domain.HezuosheDO;
import com.hexinjituan.information.service.HezuosheService;

/**
 * 合作社分社
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-06 20:04:23
 */
 
@Controller
@RequestMapping("/information/hezuoshe")
public class HezuosheController {
	@Autowired
	private HezuosheService hezuosheService;
	@Autowired
	private BootdoConfig bootdoConfig;
	
	@GetMapping()
	@RequiresPermissions("information:hezuoshe:hezuoshe")
	String Hezuoshe(){
	    return "information/hezuoshe/hezuoshe";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:hezuoshe:hezuoshe")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<HezuosheDO> hezuosheList = hezuosheService.list(query);
		int total = hezuosheService.count(query);
		PageUtils pageUtils = new PageUtils(hezuosheList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:hezuoshe:add")
	String add(){
	    return "information/hezuoshe/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:hezuoshe:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		HezuosheDO hezuoshe = hezuosheService.get(id);
		model.addAttribute("hezuoshe", hezuoshe);
	    return "information/hezuoshe/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:hezuoshe:add")
	public R save( HezuosheDO hezuoshe){
		try {
			if(hezuoshe.getImgFile()!=null && !hezuoshe.getImgFile().isEmpty()) {
				String fileName = hezuoshe.getImgFile().getOriginalFilename();
				fileName = FileUtil.renameToUUID(fileName);
				FileUtil.uploadFile(hezuoshe.getImgFile().getBytes(), bootdoConfig.getUploadPath(), fileName);
				hezuoshe.setUrl("/files/" + fileName);
			}
		} catch (Exception e) {
			return R.error();
		}
		hezuoshe.setCreateTime(new Date());
		hezuoshe.setUpdateTime(new Date());
		hezuoshe.setDeleted(0);
		if(hezuosheService.save(hezuoshe)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:hezuoshe:edit")
	public R update( HezuosheDO hezuoshe){
		try {
			if(hezuoshe.getImgFile()!=null && !hezuoshe.getImgFile().isEmpty()) {
				String fileName = hezuoshe.getImgFile().getOriginalFilename();
				fileName = FileUtil.renameToUUID(fileName);
				FileUtil.uploadFile(hezuoshe.getImgFile().getBytes(), bootdoConfig.getUploadPath(), fileName);
				hezuoshe.setUrl("/files/" + fileName);
			}
		} catch (Exception e) {
			return R.error();
		}
		hezuoshe.setUpdateTime(new Date());
		hezuosheService.update(hezuoshe);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:hezuoshe:remove")
	public R remove( Integer id){
		HezuosheDO hezuosheDO = new HezuosheDO();
		hezuosheDO.setId(id);
		hezuosheDO.setDeleted(1);
		if(hezuosheService.update(hezuosheDO)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:hezuoshe:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		hezuosheService.batchRemove(ids);
		return R.ok();
	}
	
}
