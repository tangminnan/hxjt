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
import com.hexinjituan.information.domain.SkillTrainingDO;
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
import org.springframework.web.multipart.MultipartFile;


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
	@Autowired
	private BootdoConfig bootdoConfig;
	@GetMapping()
	String JiezhengFuwu(){
	    return "information/jiezhengFuwu/jiezhengFuwu";
	}
	
	@ResponseBody
	@GetMapping("/list")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		query.put("leixing","1");
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
		if("SHOUYE".equals(jiezhengFuwu.getLeixing())){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("leixing","SHOUYE");
			List<JiezhengFuwuDO> list = jiezhengFuwuService.list(map);
			if(list.size()>0){
				jiezhengFuwu.setId(list.get(0).getId());
				if(jiezhengFuwuService.update(jiezhengFuwu)>0){
					return R.ok();
				}
			}else{
				jiezhengFuwu.setDeleted(0);
				if(jiezhengFuwuService.save(jiezhengFuwu)>0)
					return R.ok();
			}
			return R.error();
		}


		try {//保存案例图
			String iurl = "";
			List<MultipartFile> imgFileList  = jiezhengFuwu.getImgFileList();
			for(MultipartFile m :imgFileList){
				if(!m.isEmpty()) {
					String fileName = m.getOriginalFilename();
					fileName = FileUtil.renameToUUID(fileName);
					FileUtil.uploadFile(m.getBytes(), bootdoConfig.getUploadPath(), fileName);
					jiezhengFuwu.setUrl("/files/" + fileName);
					iurl+="/files/" + fileName+"::";
				}
			}
			jiezhengFuwu.setIurl(iurl);
		} catch (Exception e) {
			return R.error();
		}

		if(jiezhengFuwu.getImgFile() != null && jiezhengFuwu.getImgFile().getSize() > 0){
			String fileName = jiezhengFuwu.getImgFile().getOriginalFilename();
			fileName = FileUtil.renameToUUID(fileName);
			try {
				FileUtil.uploadFile(jiezhengFuwu.getImgFile().getBytes(), bootdoConfig.getUploadPath(), fileName);
				jiezhengFuwu.setUrl("/files/" + fileName);
			} catch (Exception e) {
				return R.error();
			}

		}
		jiezhengFuwu.setCreateTime(new Date());
		jiezhengFuwu.setUpdateTime(new Date());
		jiezhengFuwu.setDeleted(0);
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
		try {//保存案例图
			String iurl = "";
			List<MultipartFile> imgFileList  = jiezhengFuwu.getImgFileList();
			for(MultipartFile m :imgFileList){
				if(!m.isEmpty()) {
					String fileName = m.getOriginalFilename();
					fileName = FileUtil.renameToUUID(fileName);
					FileUtil.uploadFile(m.getBytes(), bootdoConfig.getUploadPath(), fileName);
					jiezhengFuwu.setUrl("/files/" + fileName);
					iurl+="/files/" + fileName+"::";
				}
			}
			jiezhengFuwu.setIurl(iurl);
		} catch (Exception e) {
			return R.error();
		}

		if(jiezhengFuwu.getImgFile() != null && jiezhengFuwu.getImgFile().getSize() > 0){
			String fileName = jiezhengFuwu.getImgFile().getOriginalFilename();
			fileName = FileUtil.renameToUUID(fileName);
			try {
				FileUtil.uploadFile(jiezhengFuwu.getImgFile().getBytes(), bootdoConfig.getUploadPath(), fileName);
				jiezhengFuwu.setUrl("/files/" + fileName);
			} catch (Exception e) {
				return R.error();
			}

		}
		jiezhengFuwu.setUpdateTime(new Date());
		jiezhengFuwuService.update(jiezhengFuwu);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Integer id){
		JiezhengFuwuDO jiezhengFuwuDO = new JiezhengFuwuDO();
		jiezhengFuwuDO.setId(id);
		jiezhengFuwuDO.setDeleted(1);
		if(jiezhengFuwuService.update(jiezhengFuwuDO)>0){
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

	@GetMapping("/shouye")
	public String shouye(Model model){
		Map<String,Object> map = new HashMap<String,Object>();
		JiezhengFuwuDO jiezhengFuwuDO = new JiezhengFuwuDO();
		map.put("leixing","SHOUYE");
		List<JiezhengFuwuDO> list = jiezhengFuwuService.list(map);
		if(list.size()>0){
			jiezhengFuwuDO = list.get(0);
		}
		model.addAttribute("jiezhengFuwuDO",jiezhengFuwuDO);
		return "information/jiezhengFuwu/shouye";
	}
	
}
