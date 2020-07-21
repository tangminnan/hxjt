package com.hexinjituan.information.controller;

import com.hexinjituan.information.domain.JiamengStoreDO;
import com.hexinjituan.information.service.JiamengStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class jiamengController {

    @Autowired
    private JiamengStoreService jiamengStoreService;

    @GetMapping("/jiameng")
    String jiameng(@RequestParam(value = "ad",required = false) String ad, Model model){
        Map<String,Object> map = new HashMap<>();
        map.put("jiamengType","ZHIYING_DIAN");
        List<JiamengStoreDO> list = jiamengStoreService.list(map);
        model.addAttribute("list",list);
        model.addAttribute("ad",ad==null?"":ad);
        return "information/pc_page/jiameng";
    }
}
