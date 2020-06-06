package com.hexinjituan.information.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hexinjituan.common.config.BootdoConfig;
import com.hexinjituan.common.utils.*;
import com.hexinjituan.information.domain.SkillTrainingDO;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hexinjituan.information.domain.CompanyInfoDO;
import com.hexinjituan.information.service.CompanyInfoService;


/**
 * 就业公司表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-05-27 17:12:49
 */
 
@Controller
@RequestMapping("/information/companyInfo")
public class CompanyInfoController {
	@Autowired
	private CompanyInfoService companyInfoService;
	@Autowired
	private BootdoConfig bootdoConfig;


	@GetMapping()
	@RequiresPermissions("information:companyInfo:companyInfo")
	String CompanyInfo(){
	    return "information/companyInfo/companyInfo";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:companyInfo:companyInfo")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<CompanyInfoDO> companyInfoList = companyInfoService.list(query);
		int total = companyInfoService.count(query);
		PageUtils pageUtils = new PageUtils(companyInfoList, total);
		return pageUtils;
	}
	
	@GetMapping("/add")
	@RequiresPermissions("information:companyInfo:add")
	String add(){
	    return "information/companyInfo/add";
	}

	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Integer id,Model model){
		CompanyInfoDO companyInfo = companyInfoService.get(id);
		model.addAttribute("companyInfo", companyInfo);
	    return "information/companyInfo/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("information:companyInfo:add")
	public R save( CompanyInfoDO companyInfo){

		if("COMPANY_JIANJIE".equals(companyInfo.getIfJianjie())){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("ifJianjie","COMPANY_JIANJIE");
			List<CompanyInfoDO> list = companyInfoService.list(map);
			if(list.size()>0){
				companyInfo.setId(list.get(0).getId());
				if(companyInfoService.update(companyInfo)>0){
					return R.ok();
				}
				else
					return R.error();
			}
		}
		companyInfo.setCreateTime(new Date());
		companyInfo.setUpdateTime(new Date());
		companyInfo.setDeleted(0);
		companyInfo.setUserId(ShiroUtils.getUserId());
		try {
			if(companyInfo.getImgFile()!=null && !companyInfo.getImgFile().isEmpty()) {
				String fileName = companyInfo.getImgFile().getOriginalFilename();
				fileName = FileUtil.renameToUUID(fileName);
				FileUtil.uploadFile(companyInfo.getImgFile().getBytes(), bootdoConfig.getUploadPath(), fileName);
				companyInfo.setUrl("/files/" + fileName);
			}
		} catch (Exception e) {
			return R.error();
		}
		if(companyInfoService.save(companyInfo)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update( CompanyInfoDO companyInfo){
		if(companyInfo.getImgFile() != null && companyInfo.getImgFile().getSize() > 0){
			String fileName = companyInfo.getImgFile().getOriginalFilename();
			fileName = FileUtil.renameToUUID(fileName);
			try {
				FileUtil.uploadFile(companyInfo.getImgFile().getBytes(), bootdoConfig.getUploadPath(), fileName);
				companyInfo.setUrl("/files/" + fileName);
			} catch (Exception e) {
				return R.error();
			}

		}
		companyInfoService.update(companyInfo);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Integer id){
		CompanyInfoDO companyInfoDO  =new CompanyInfoDO();
		companyInfoDO.setId(id);
		companyInfoDO.setDeleted(1);
		if(companyInfoService.update(companyInfoDO)>0){
		return R.ok();
		}
		return R.error();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	@RequiresPermissions("information:companyInfo:batchRemove")
	public R remove(@RequestParam("ids[]") Integer[] ids){
		companyInfoService.batchRemove(ids);
		return R.ok();
	}

	/**
	 *  公司信息
	 */
	@GetMapping("/company/{info}/{id}")
	public String companyInfo(@PathVariable("info") String info,@PathVariable("id") Integer id, Model model ){
		model.addAttribute("id",id);
		CompanyInfoDO companyInfoDO = companyInfoService.get(id);
		model.addAttribute("companyInfoDO",companyInfoDO);
		return "information/companyInfo/info";
	}

	/**
	 *  完善公司的信息
	 */

	@PostMapping("/saveCompanyInfo")
	@ResponseBody
	public R saveCompanyInfo(CompanyInfoDO companyInfo){
		if(companyInfoService.update(companyInfo) > 0)
			return R.ok();
		return R.error();
	}

	/**
	 * 集团简介
	 */
	@GetMapping("/jianjie")
	public String jianjie(Model model){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("ifJianjie","COMPANY_JIANJIE");
		CompanyInfoDO companyInfoDO = new CompanyInfoDO();
		List<CompanyInfoDO> list = companyInfoService.list(map);
		if(list.size()>0)
			companyInfoDO = list.get(0);
		model.addAttribute("companyContent",companyInfoDO.getCompanyContent());
		return "information/companyInfo/jianjie";
	}
	
}
