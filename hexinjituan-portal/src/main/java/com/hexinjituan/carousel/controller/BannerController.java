package com.hexinjituan.carousel.controller;

import com.hexinjituan.carousel.domain.BannerDO;
import com.hexinjituan.carousel.service.BannerService;
import com.hexinjituan.common.config.BootdoConfig;
import com.hexinjituan.common.controller.BaseController;
import com.hexinjituan.common.utils.FileUtil;
import com.hexinjituan.common.utils.PageUtils;
import com.hexinjituan.common.utils.Query;
import com.hexinjituan.common.utils.R;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 轮播图
 * 
 * @author wjl
 */
@Controller
@RequestMapping("/carousel/banner")
public class BannerController extends BaseController {

	@Autowired
	private BannerService bannerService;

	@Autowired
	private BootdoConfig bootdoConfig;

	@GetMapping()
	@RequiresPermissions("carousel:banner:banner")
	String sysFile(Model model) {
		Map<String, Object> params = new HashMap<>(16);
		return "carousel/banner/banner";
	}

	@ResponseBody
	@GetMapping("/list")
	@RequiresPermissions("carousel:banner:banner")
	public PageUtils list(@RequestParam Map<String, Object> params) {
		// 查询列表数据
		Query query = new Query(params);
		List<BannerDO> sysFileList = bannerService.list(query);
		int total = bannerService.count(query);
		PageUtils pageUtils = new PageUtils(sysFileList, total);
		return pageUtils;
	}

	@GetMapping("/add")
	@RequiresPermissions("carousel:banner:add")
	String add() {
		return "carousel/banner/add";
	}

	@GetMapping("/edit/{id}")
	// @RequiresPermissions("carousel:bComments")
	String edit(@PathVariable("id") Long id, Model model) {
		BannerDO sysFile = bannerService.get(id);
		model.addAttribute("model", sysFile);
		return "carousel/banner/edit";
	}
	@GetMapping("/rocket/{id}")
	// @RequiresPermissions("carousel:bComments")
	String rocket(@PathVariable("id") Long id, Model model) {
		BannerDO sysFile = bannerService.get(id);
		model.addAttribute("model", sysFile);
		return "carousel/banner/rocket";
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("carousel:info")
	public R info(@PathVariable("id") Long id) {
		BannerDO sysFile = bannerService.get(id);
		return R.ok().put("sysFile", sysFile);
	}

	/**
	 * 保存
	 */
	@ResponseBody
	@PostMapping("/save")
	@RequiresPermissions("carousel:banner:add")
	public R save(BannerDO sysFile) {
		try {
			if(sysFile.getImgFile()!=null && !sysFile.getImgFile().isEmpty()) {
				String fileName = sysFile.getImgFile().getOriginalFilename();
				fileName = FileUtil.renameToUUID(fileName);
				FileUtil.uploadFile(sysFile.getImgFile().getBytes(), bootdoConfig.getUploadPath(), fileName);
				sysFile.setUrl("/files/" + fileName);
			}
		} catch (Exception e) {
			return R.error();
		}
		sysFile.setAddTime(new Date());
		sysFile.setUpdateTime(new Date());
		sysFile.setUserId(this.getUserId());
		sysFile.setDeleteFlag(0);
		if(sysFile.getSort()==null)
			sysFile.setSort(1000);
		if (bannerService.save(sysFile) > 0) {
			return R.ok();
		}
		return R.error();
	}

	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping(value="/updateEnable")
	public R updateEnable(Long id,Integer enable) {
		BannerDO sysFile = bannerService.get(id);
		sysFile.setIsEnable(enable);
		bannerService.update(sysFile);
		return R.ok();
	}
	/**
	 * 修改
	 */
	@ResponseBody
	@RequestMapping("/update")
	//@RequiresPermissions("carousel:update")
	public R update( BannerDO sysFile) {
		System.out.println("================");
		if(sysFile.getImgFile() != null && sysFile.getImgFile().getSize() > 0){
			String fileName = sysFile.getImgFile().getOriginalFilename();
			fileName = FileUtil.renameToUUID(fileName);
			try {
				FileUtil.uploadFile(sysFile.getImgFile().getBytes(), bootdoConfig.getUploadPath(), fileName);
				sysFile.setUrl("/files/" + fileName);
			} catch (Exception e) {
				return R.error();
			}
			
		}
		sysFile.setUserId(this.getUserId());
		sysFile.setUpdateTime(new Date());
		bannerService.update(sysFile);
		
		return R.ok();
	}

	/**
	 * 删除
	 */
	@PostMapping("/remove")
	@ResponseBody
	// @RequiresPermissions("carousel:remove")
	public R remove(Long id, HttpServletRequest request) {
		BannerDO bannerDO = new BannerDO();
		bannerDO.setDeleteFlag(1);
		bannerDO.setId(id);
		if(bannerService.update(bannerDO)>0)
			return R.ok();
		return R.error();
	}

	/**
	 * 删除
	 */
	@PostMapping("/batchRemove")
	@ResponseBody
	@RequiresPermissions("carousel:remove")
	public R remove(@RequestParam("ids[]") Long[] ids) {
		if ("test".equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		bannerService.batchRemove(ids);
		return R.ok();
	}

	@ResponseBody
	@PostMapping("/upload")
	R upload(@RequestParam("file") MultipartFile file,BannerDO sysFile, HttpServletRequest request) {
		if ("test".equals(getUsername())) {
			return R.error(1, "演示系统不允许修改,完整体验请部署程序");
		}
		String fileName = file.getOriginalFilename();
		fileName = FileUtil.renameToUUID(fileName);
		//BannerDO sysFile = new BannerDO(FileType.fileType(fileName), "/files/" + fileName, new Date());
		//BannerDO sysFile = new BannerDO(String name,int place,int type,Date startTime,Date endTime,int isEnable,String url,Long userId);
		try {
			FileUtil.uploadFile(file.getBytes(), bootdoConfig.getUploadPath(), fileName);
		} catch (Exception e) {
			return R.error();
		}

		if (bannerService.save(sysFile) > 0) {
			return R.ok().put("fileName",sysFile.getUrl());
		}
		return R.error();
	}


}
