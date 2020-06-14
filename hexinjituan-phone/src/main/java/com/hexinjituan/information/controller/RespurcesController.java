package com.hexinjituan.information.controller;

import com.hexinjituan.information.domain.RespurcesDO;
import com.hexinjituan.information.service.RespurcesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


/**
 * 人力资源表
 * 
 * @author wjl
 * @email bushuo@163.com
 * @date 2020-06-11 17:30:27
 */
 
@Controller
public class RespurcesController {
	@Autowired
	private RespurcesService respurcesService;

	@GetMapping("/renli")
	public String renli(Model model ){
		RespurcesDO respurcesDO = new RespurcesDO();
		List<RespurcesDO> list = respurcesService.list(new HashMap<String,Object>());
		if(list.size()>0)
			respurcesDO=list.get(0);
		model.addAttribute("data",respurcesDO);
		return "information/phone_page/renliziyuan";
	}


}
