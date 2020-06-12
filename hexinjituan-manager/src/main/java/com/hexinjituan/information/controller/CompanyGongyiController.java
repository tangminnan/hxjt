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

import com.hexinjituan.information.domain.CompanyGongyiDO;
import com.hexinjituan.information.service.CompanyGongyiService;

/**
 * 慈善公益表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-01 16:08:42
 */
 
@Controller
@RequestMapping("/information/companyGongyi")
public class CompanyGongyiController {
	@Autowired
	private CompanyGongyiService companyGongyiService;
	@Autowired
	private BootdoConfig bootdoConfig;
	
	@GetMapping()
	@RequiresPermissions("information:companyGongyi:companyGongyi")
	String CompanyGongyi(Model model){
	    CompanyGongyiDO companyGongyiDO = new CompanyGongyiDO();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("gongyiClass","GONGYI_XINGDONG");
        List<CompanyGongyiDO> list = companyGongyiService.list(map);
        if(list.size()>0)
            companyGongyiDO=list.get(0);
        model.addAttribute("data",companyGongyiDO);
	    return "information/companyGongyi/companyGongyi";
	}
	
	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("information:companyGongyi:companyGongyi")
	public PageUtils list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);
		List<CompanyGongyiDO> companyGongyiList = companyGongyiService.list(query);
		int total = companyGongyiService.count(query);
		PageUtils pageUtils = new PageUtils(companyGongyiList, total);
		return pageUtils;
	}
	
	@GetMapping("/addz")
	String addz(){
	    return "information/companyGongyi/addz";
	}

	@GetMapping("/add")
	String add(){
		return "information/companyGongyi/add";
	}

	@GetMapping("/edit/{id}")
	String edit(@PathVariable("id") Integer id,Model model){
		CompanyGongyiDO companyGongyi = companyGongyiService.get(id);
		model.addAttribute("companyGongyi", companyGongyi);
	    return "information/companyGongyi/edit";
	}

		@GetMapping("/editz/{id}")
		String editz(@PathVariable("id") Integer id,Model model){
		CompanyGongyiDO companyGongyi = companyGongyiService.get(id);
		model.addAttribute("companyGongyi", companyGongyi);
		return "information/companyGongyi/editz";
	}
	
	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	public R save( CompanyGongyiDO companyGongyi){
        if("GONGYI_XINGDONG".equals(companyGongyi.getGongyiClass())){//公益在行动
            Map<String,Object> map = new HashMap<String,Object>();
                map.put("gongyiClass","GONGYI_XINGDONG");
                List<CompanyGongyiDO> list = companyGongyiService.list(map);
                if(list.size()>0){
                companyGongyi.setId(list.get(0).getId());
                if(companyGongyiService.update(companyGongyi)>0)
                    return R.ok();
            }else{
                companyGongyi.setDeleted(0);
                if(companyGongyiService.save(companyGongyi)>0)
                    return R.ok();
            }
            return R.error();
        }
        try {
			if(companyGongyi.getImgFile()!=null && !companyGongyi.getImgFile().isEmpty()) {
				String fileName = companyGongyi.getImgFile().getOriginalFilename();
				fileName = FileUtil.renameToUUID(fileName);
				FileUtil.uploadFile(companyGongyi.getImgFile().getBytes(), bootdoConfig.getUploadPath(), fileName);
				companyGongyi.setUrl("/files/" + fileName);
			}
		} catch (Exception e) {
			return R.error();
		}
		companyGongyi.setDeleted(0);
		companyGongyi.setCreateTime(new Date());
		companyGongyi.setUpdateTime(new Date());
		if(companyGongyiService.save(companyGongyi)>0){
			return R.ok();
		}
		return R.error();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	public R update(CompanyGongyiDO companyGongyi){
		try {
			if(companyGongyi.getImgFile()!=null && !companyGongyi.getImgFile().isEmpty()) {
				String fileName = companyGongyi.getImgFile().getOriginalFilename();
				fileName = FileUtil.renameToUUID(fileName);
				FileUtil.uploadFile(companyGongyi.getImgFile().getBytes(), bootdoConfig.getUploadPath(), fileName);
				companyGongyi.setUrl("/files/" + fileName);
			}
		} catch (Exception e) {
			return R.error();
		}
		companyGongyi.setUpdateTime(new Date());
		companyGongyiService.update(companyGongyi);
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@PostMapping( "/remove")
	@ResponseBody
	public R remove( Integer id){
		CompanyGongyiDO companyGongyiDO = new CompanyGongyiDO();
		companyGongyiDO.setId(id);
		companyGongyiDO.setDeleted(1);
		if(companyGongyiService.update(companyGongyiDO)>0){
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
		companyGongyiService.batchRemove(ids);
		return R.ok();
	}
	
}
