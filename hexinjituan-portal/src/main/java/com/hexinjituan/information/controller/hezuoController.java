package com.hexinjituan.information.controller;

import com.hexinjituan.information.domain.HezuosheDO;
import com.hexinjituan.information.domain.HezuosheShouyeDO;
import com.hexinjituan.information.domain.StudentsElegantDO;
import com.hexinjituan.information.service.StudentsElegantService;
import com.hexinjituan.information.service.impl.HezuosheServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class hezuoController {

    @Autowired
    private HezuosheServiceImpl hezuosheServiceImpl;
    @Autowired
    private StudentsElegantService studentsElegantService;

    @GetMapping("/hezuo")
    String hezuo(Model model){
        Map<String,Object> map = new HashMap<>();
        map.put("type","HEZUOSHE_SHOUYE");
        HezuosheShouyeDO hezuosheShouyeDOS = hezuosheServiceImpl.listHezuosheShouyeDO(map).get(0);
        model.addAttribute("hezuosheShouye",hezuosheShouyeDOS);
        Map<String,Object> map1 = new HashMap<>();
        map1.put("typeName","HEZUOSHE");
        List<StudentsElegantDO> list = studentsElegantService.list(map1);
        model.addAttribute("hezuoshetu",list);
        List<HezuosheDO> list1 = hezuosheServiceImpl.list(new HashMap<>());
        model.addAttribute("hezuoshefenshe",list1);
        return "information/pc_page/hezuo";
    }

    @GetMapping("/pc/hzfen/{id}")
    String hzfen(Model model, @PathVariable("id") Integer id){
        HezuosheDO hezuosheDO = hezuosheServiceImpl.get(id);
        model.addAttribute("hezuosheDO",hezuosheDO);
        return "information/pc_page/hezuoanli2";
    }


}
