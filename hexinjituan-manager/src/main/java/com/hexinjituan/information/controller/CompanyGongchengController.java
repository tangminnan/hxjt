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

import com.hexinjituan.information.domain.CompanyGongchengDO;
import com.hexinjituan.information.service.CompanyGongchengService;
import org.springframework.web.multipart.MultipartFile;


/**
 * 业务工程表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-01 13:39:38
 */
 
@Controller
@RequestMapping("/information/companyGongcheng")
public class CompanyGongchengController {
	@Autowired
	private CompanyGongchengService companyGongchengService;
	@Autowired
	private BootdoConfig bootdoConfig;
	
	@GetMapping("/{id}")
	String CompanyGongcheng(@PathVariable("id") Long id,Model model){
		model.addAttribute("id",id);
	    return "information/companyGongcheng/companyGongcheng";
	}
	
	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<CompanyGongchengDO> companyGongchengList = companyGongchengService.list(query);
		int total = companyGongchengService.count(query);
		PageUtils pageUtils = new PageUtils(companyGongchengList, total);
		return pageUtils;
	}
	
	@GetMapping("/add/{companyId}")
	String add(@PathVariable("companyId") Long companyId,Model model){
		model.addAttribute("companyId",companyId);
	    return "information/companyGongcheng/add";
	}

	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Integer id,Model model){
		CompanyGongchengDO companyGongcheng = companyGongchengService.get(id);
		model.addAttribute("companyGongcheng", companyGongcheng);
	    return "information/companyGongcheng/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public R save( CompanyGongchengDO companyGongcheng){
		try {
			String iurl = "";
			List<MultipartFile> imgFileList  = companyGongcheng.getImgFileList();
			for(MultipartFile m :imgFileList){
				if(!m.isEmpty()) {
					String fileName = m.getOriginalFilename();
					fileName = FileUtil.renameToUUID(fileName);
					FileUtil.uploadFile(m.getBytes(), bootdoConfig.getUploadPath(), fileName);
					companyGongcheng.setUrl("/files/" + fileName);
					iurl+="/files/" + fileName+"::";
				}
			}
			companyGongcheng.setIurl(iurl);
		} catch (Exception e) {
			return R.error();
		}
		companyGongcheng.setDeleted(0);
		companyGongcheng.setCreateTime(new Date());
		companyGongcheng.setUpdateTime(new Date());
		if(companyGongchengService.save(companyGongcheng)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update(CompanyGongchengDO companyGongcheng){
		try {
			String iurl = "";
			List<MultipartFile> imgFileList  = companyGongcheng.getImgFileList();
			for(MultipartFile m :imgFileList){
				if(!m.isEmpty()) {
					String fileName = m.getOriginalFilename();
					fileName = FileUtil.renameToUUID(fileName);
					FileUtil.uploadFile(m.getBytes(), bootdoConfig.getUploadPath(), fileName);
					companyGongcheng.setUrl("/files/" + fileName);
					iurl+="/files/" + fileName+"::";
				}
			}
			companyGongcheng.setIurl(iurl);
		} catch (Exception e) {
			return R.error();
		}
		companyGongchengService.update(companyGongcheng);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Integer id){
		CompanyGongchengDO companyGongchengDO  =new CompanyGongchengDO();
		companyGongchengDO.setId(id);
		companyGongchengDO.setDeleted(1);
		if(companyGongchengService.update(companyGongchengDO)>0){
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
		companyGongchengService.batchRemove(ids);
		return R.ok();
	}
	
}
