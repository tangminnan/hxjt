package com.hexinjituan.information.controller;

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
public class rongyuController {
    @Autowired
    private StudentsElegantService studentsElegantService;

    @GetMapping("/rongyu")
    String rongyu(Model model){
        Map<String,Object> map1 = new HashMap<String, Object>();
        map1.put("typeName","RONGYU");
        List<StudentsElegantDO> xueyuan = studentsElegantService.list(map1);
        Map<String,Object> map2 = new HashMap<String, Object>();
        map2.put("typeName","RONGYU");
        List<StudentsElegantDO> guzhu = studentsElegantService.list(map2);
        Map<String,Object> map3 = new HashMap<String, Object>();
        map3.put("typeName","RONGYU");
        List<StudentsElegantDO> qiye = studentsElegantService.list(map3);
        model.addAttribute("xueyuan",xueyuan);
        model.addAttribute("guzhu",guzhu);
        model.addAttribute("qiye",qiye);
        return "information/phone_page/qiyerongyu";
    }
}
