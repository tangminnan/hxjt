package com.hexinjituan.information.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hexinjituan.common.config.BootdoConfig;
import com.hexinjituan.common.utils.FileUtil;
import com.hexinjituan.common.utils.PageUtils;
import com.hexinjituan.common.utils.Query;
import com.hexinjituan.common.utils.R;
import groovy.util.IFileNameFinder;
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

import com.hexinjituan.information.domain.RespurcesDO;
import com.hexinjituan.information.service.RespurcesService;
import org.springframework.web.multipart.MultipartFile;


/**
 * 人力资源表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-11 17:30:27
 */
 
@Controller
@RequestMapping("/information/respurces")
public class RespurcesController {
	@Autowired
	private RespurcesService respurcesService;
	@Autowired
	private BootdoConfig bootdoConfig;
	
	@GetMapping()
	@RequiresPermissions("information:respurces:respurces")
	String Respurces(){
	    return "information/respurces/respurces";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:respurces:respurces")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<RespurcesDO> respurcesList = respurcesService.list(query);
		int total = respurcesService.count(query);
		PageUtils pageUtils = new PageUtils(respurcesList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:respurces:add")
	String add(){
	    return "information/respurces/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:respurces:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		RespurcesDO respurces = respurcesService.get(id);
		model.addAttribute("respurces", respurces);
	    return "information/respurces/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:respurces:add")
	public R save(RespurcesDO respurces){
		if(respurcesService.save(respurces)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:respurces:edit")
	public R update( RespurcesDO respurces){
		respurcesService.update(respurces);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:respurces:remove")
	public R remove( Integer id){
		if(respurcesService.remove(id)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:respurces:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		respurcesService.batchRemove(ids);
		return R.ok();
	}

	/**
	 * 人力资源
	 * @return
	 */
	@GetMapping("/renliziyuan")
	public String renliziyuan(Model model){
		RespurcesDO respurcesDO = new RespurcesDO();
		List<RespurcesDO> list  = respurcesService.list(new HashMap<String,Object>());
		if(list.size()>0)
			respurcesDO=list.get(0);
		if(respurcesDO.getUrl()==null)
			respurcesDO.setUrl("/img/tousu-pic1.jpg");
		model.addAttribute("data",respurcesDO);
		return "information/respurces/renliziyuan";
	}

	/**
	 *	保存人力资源
	 */
	@PostMapping("/saveRenliziyuan")
	@ResponseBody
	public R saveRenliziyuan(RespurcesDO respurcesDO){
		try {
			String iurl = "";
			List<MultipartFile> imgFileList  = respurcesDO.getImgFileList();
			for(MultipartFile m :imgFileList){
				if(!m.isEmpty()) {
					String fileName = m.getOriginalFilename();
					fileName = FileUtil.renameToUUID(fileName);
					FileUtil.uploadFile(m.getBytes(), bootdoConfig.getUploadPath(), fileName);
					respurcesDO.setUrl("/files/" + fileName);
					iurl+="/files/" + fileName+"::";
				}
			}
			respurcesDO.setIurl(iurl);
		} catch (Exception e) {
			return R.error();
		}

		if(respurcesDO.getImgFile() != null && respurcesDO.getImgFile().getSize() > 0){
			String fileName = respurcesDO.getImgFile().getOriginalFilename();
			fileName = FileUtil.renameToUUID(fileName);
			try {
				FileUtil.uploadFile(respurcesDO.getImgFile().getBytes(), bootdoConfig.getUploadPath(), fileName);
				respurcesDO.setUrl("/files/" + fileName);
			} catch (Exception e) {
				return R.error();
			}

		}
		if(respurcesDO.getId()!=null){//修改
			respurcesDO.setUpdateTime(new Date());
			respurcesService.update(respurcesDO);
		}else{//增加
			respurcesDO.setDeleted(0);
			respurcesDO.setCreateTime(new Date());
			respurcesDO.setUpdateTime(new Date());
			respurcesService.save(respurcesDO);
		}
		return R.ok();
	}
}
