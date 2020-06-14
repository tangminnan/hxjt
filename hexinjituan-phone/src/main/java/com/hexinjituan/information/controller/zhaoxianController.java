package com.hexinjituan.information.controller;

import com.hexinjituan.information.domain.ZhaoxianDO;
import com.hexinjituan.information.service.ZhaoxianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class zhaoxianController {

    @Autowired
    private ZhaoxianService zhaoxianService;

    @GetMapping("/zhaoxian")
    String zhaoxian(Model model){
        Map<String,Object> map = new HashMap<>();
        List<ZhaoxianDO> list = zhaoxianService.list(map);
        model.addAttribute("list",list);
        return "information/phone_page/zhaoxiannashi";
    }
}
