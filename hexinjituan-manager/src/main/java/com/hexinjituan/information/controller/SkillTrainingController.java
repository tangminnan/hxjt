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

import com.hexinjituan.information.domain.SkillTrainingDO;
import com.hexinjituan.information.service.SkillTrainingService;


/**
 * 送技术下乡
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-02 14:22:56
 */
 
@Controller
@RequestMapping("/information/skillTraining")
public class SkillTrainingController {
	@Autowired
	private SkillTrainingService skillTrainingService;
	@Autowired
	private BootdoConfig bootdoConfig;


	@GetMapping("/{trainingClass}")
	@RequiresPermissions("information:skillTraining:skillTraining")
	String SkillTraining(@PathVariable("trainingClass") String trainingClass,Model model){
		model.addAttribute("trainingClass",trainingClass);
		return "information/skillTraining/skillTraining";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:skillTraining:skillTraining")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<SkillTrainingDO> skillTrainingList = skillTrainingService.list(query);
		int total = skillTrainingService.count(query);
		PageUtils pageUtils = new PageUtils(skillTrainingList, total);
		return pageUtils;
	}
	
	@GetMapping("/add/{trainingClass}")
	String add(@PathVariable("trainingClass") String trainingClass,Model model){
		model.addAttribute("trainingClass",trainingClass);
	    return "information/skillTraining/add";
	}

	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Integer id,Model model){
		SkillTrainingDO skillTraining = skillTrainingService.get(id);
		model.addAttribute("skillTraining", skillTraining);
	    return "information/skillTraining/edit";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public R save(SkillTrainingDO skillTraining){

		if("JISHU_XIAXIANG".equals(skillTraining.getTrainingClass())){
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("trainingClass","JISHU_XIAXIANG");
			List<SkillTrainingDO> list = skillTrainingService.list(map);
			if(list.size()>0){
				skillTraining.setId(list.get(0).getId());
				if(skillTrainingService.update(skillTraining)>0){
					return R.ok();
				}
				else
					return R.error();
			}
		}
		try {
			if(skillTraining.getImgFile()!=null && !skillTraining.getImgFile().isEmpty()) {
				String fileName = skillTraining.getImgFile().getOriginalFilename();
				fileName = FileUtil.renameToUUID(fileName);
				FileUtil.uploadFile(skillTraining.getImgFile().getBytes(), bootdoConfig.getUploadPath(), fileName);
				skillTraining.setUrl("/files/" + fileName);
			}
		} catch (Exception e) {
			return R.error();
		}
		skillTraining.setDeleted(0);
		skillTraining.setCreateTime(new Date());
		skillTraining.setUpdateTime(new Date());
		if(skillTrainingService.save(skillTraining)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update( SkillTrainingDO skillTraining){
		if(skillTraining.getImgFile() != null && skillTraining.getImgFile().getSize() > 0){
			String fileName = skillTraining.getImgFile().getOriginalFilename();
			fileName = FileUtil.renameToUUID(fileName);
			try {
				FileUtil.uploadFile(skillTraining.getImgFile().getBytes(), bootdoConfig.getUploadPath(), fileName);
				skillTraining.setUrl("/files/" + fileName);
			} catch (Exception e) {
				return R.error();
			}

		}
		skillTraining.setUpdateTime(new Date());
		skillTrainingService.update(skillTraining);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Integer id){
		SkillTrainingDO skillTrainingDO = new SkillTrainingDO();
		skillTrainingDO.setId(id);
		skillTrainingDO.setDeleted(1);
		if(skillTrainingService.update(skillTrainingDO)>0){
		return R.ok();
		}
		return R.error();
	}

	@GetMapping("/xiaXiang")
	public String  xiaXiang(Model model){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("trainingClass","JISHU_XIAXIANG");
		SkillTrainingDO skillTrainingDO = new SkillTrainingDO();
		List<SkillTrainingDO> list = skillTrainingService.list(map);
		if(list.size()>0)
			skillTrainingDO = list.get(0);
		model.addAttribute("trainingContent",skillTrainingDO.getTrainingContent());
		return "information/skillTraining/jishuxiaxiang";
	}

	/**
	 * 删除
	 */
	@PostMapping( "/batchRemove")
	@ResponseBody
	public R remove(@RequestParam("ids[]") Integer[] ids){
		skillTrainingService.batchRemove(ids);
		return R.ok();
	}
	
}
