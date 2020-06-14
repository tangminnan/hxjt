package com.hexinjituan.information.controller;

import com.hexinjituan.carousel.domain.BannerDO;
import com.hexinjituan.carousel.service.BannerService;
import com.hexinjituan.information.domain.StudentsElegantDO;
import com.hexinjituan.information.service.StudentsElegantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class indexController {

    @Autowired
    private BannerService bannerService;
    @Autowired
    private StudentsElegantService studentsElegantService;

    @GetMapping("")
    String shouye(Model model){
        List<BannerDO> banner = bannerService.list(new HashMap<String, Object>());
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("typeName","HEZUOSHE");
        List<StudentsElegantDO> hezuo = studentsElegantService.list(map);
        Map<String,Object> mapP = new HashMap<String, Object>();
        mapP.put("typeName","RONGYU");
        List<StudentsElegantDO> rongyu = studentsElegantService.list(mapP);
        model.addAttribute("banner",banner);
        model.addAttribute("hezuo",hezuo);
        model.addAttribute("rongyu",rongyu);
        return "information/phone_page/index";
    }

    @GetMapping("/index")
    String index(Model model){
        List<BannerDO> banner = bannerService.list(new HashMap<String, Object>());
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("typeName","HEZUOSHE");
        List<StudentsElegantDO> hezuo = studentsElegantService.list(map);
        Map<String,Object> mapP = new HashMap<String, Object>();
        mapP.put("typeName","RONGYU");
        List<StudentsElegantDO> rongyu = studentsElegantService.list(mapP);
        model.addAttribute("banner",banner);
        model.addAttribute("hezuo",hezuo);
        model.addAttribute("rongyu",rongyu);
        return "information/phone_page/index";
    }


}
