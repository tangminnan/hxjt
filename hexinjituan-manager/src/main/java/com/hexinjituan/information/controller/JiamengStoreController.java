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
import com.hexinjituan.information.domain.HezuosheShouyeDO;
import com.hexinjituan.information.service.HezuosheService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hexinjituan.information.domain.JiamengStoreDO;
import com.hexinjituan.information.service.JiamengStoreService;


/**
 * 直营加盟店铺
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-08 16:56:43
 */
 
@Controller
@RequestMapping("/information/jiamengStore")
public class JiamengStoreController {
	@Autowired
	private JiamengStoreService jiamengStoreService;
	@Autowired
	private BootdoConfig bootdoConfig;
	@Autowired
	private HezuosheService hezuosheService;
	
	@GetMapping()
	@RequiresPermissions("information:jiamengStore:jiamengStore")
	String JiamengStore(){
	    return "information/jiamengStore/jiamengStore";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:jiamengStore:jiamengStore")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<JiamengStoreDO> jiamengStoreList = jiamengStoreService.list(query);
		int total = jiamengStoreService.count(query);
		PageUtils pageUtils = new PageUtils(jiamengStoreList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:jiamengStore:add")
	String add(){
	    return "information/jiamengStore/add";
	}

	@GetMapping("/edit/{id}")
	@RequiresPermissions("information:jiamengStore:edit")
	String edit(@PathVariable("id") Integer id,Model model){
		JiamengStoreDO jiamengStore = jiamengStoreService.get(id);
		model.addAttribute("jiamengStore", jiamengStore);
	    return "information/jiamengStore/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:jiamengStore:add")
	public R save( JiamengStoreDO jiamengStore){
		try {
			if(jiamengStore.getImgFile()!=null && !jiamengStore.getImgFile().isEmpty()) {
				String fileName = jiamengStore.getImgFile().getOriginalFilename();
				fileName = FileUtil.renameToUUID(fileName);
				FileUtil.uploadFile(jiamengStore.getImgFile().getBytes(), bootdoConfig.getUploadPath(), fileName);
				jiamengStore.setUrl("/files/" + fileName);
			}
		} catch (Exception e) {
			return R.error();
		}
		jiamengStore.setCreateTime(new Date());
		jiamengStore.setUpdateTime(new Date());
		jiamengStore.setDeleted(0);
		if(jiamengStoreService.save(jiamengStore)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	@RequiresPermissions("information:jiamengStore:edit")
	public R update( JiamengStoreDO jiamengStore){
		try {
			if(jiamengStore.getImgFile()!=null && !jiamengStore.getImgFile().isEmpty()) {
				String fileName = jiamengStore.getImgFile().getOriginalFilename();
				fileName = FileUtil.renameToUUID(fileName);
				FileUtil.uploadFile(jiamengStore.getImgFile().getBytes(), bootdoConfig.getUploadPath(), fileName);
				jiamengStore.setUrl("/files/" + fileName);
			}
		} catch (Exception e) {
			return R.error();
		}
		jiamengStore.setUpdateTime(new Date());
		jiamengStoreService.update(jiamengStore);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	@RequiresPermissions("information:jiamengStore:remove")
	public R remove( Integer id){
		JiamengStoreDO jiamengStoreDO = new JiamengStoreDO();
		jiamengStoreDO.setId(id);
		jiamengStoreDO.setDeleted(1);
		if(jiamengStoreService.update(jiamengStoreDO)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:jiamengStore:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		jiamengStoreService.batchRemove(ids);
		return R.ok();
	}

	@GetMapping("/jiameng")
	public String  jiameng(Model model){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("type","JIAMENG");
		HezuosheShouyeDO hezuosheShouyeDO=new HezuosheShouyeDO();
		List<HezuosheShouyeDO> list = hezuosheService.listHezuosheShouyeDO(map);
		if(list.size()>0){
			hezuosheShouyeDO=list.get(0);
		}
		model.addAttribute("hezuosheShouyeDO",hezuosheShouyeDO);
		return "information/jiamengStore/jiameng";
	}

	@PostMapping("/savejiameng")
	@ResponseBody
	public R  savejiameng(HezuosheShouyeDO hezuosheShouyeDO){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("type","JIAMENG");
		List<HezuosheShouyeDO> list = hezuosheService.listHezuosheShouyeDO(map);
		if(list.size()>0){
			hezuosheShouyeDO.setId(list.get(0).getId());
			if(hezuosheService.updateHezuosheShouyeDO(hezuosheShouyeDO)>0)
				return R.ok();
		}else{
			if(hezuosheService.saveHezuosheShouyeDO(hezuosheShouyeDO)>0)
				return  R.ok();
		}
		return R.error();
	}
	
}
