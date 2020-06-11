package com.hexinjituan.information.controller;

import com.hexinjituan.information.domain.JiezhengFuwuDO;
import com.hexinjituan.information.service.JiezhengFuwuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class fuwuController {

    @Autowired
    private JiezhengFuwuService jiezhengFuwuService;

    @GetMapping("/fuwu")
    String fuwu(Model model){
        Map<String,Object> map = new HashMap<>();
        map.put("leixing","SHOUYE");
        JiezhengFuwuDO Jiezheng = jiezhengFuwuService.list(map).get(0);
        model.addAttribute("Jiezheng",Jiezheng);
        List<JiezhengFuwuDO> Jiezhenglist = jiezhengFuwuService.fuwulist();
        model.addAttribute("Jiezhenglist",Jiezhenglist);
        return "information/pc_page/fuwu";
    }

    @GetMapping("/fwxiangmu/info/{id}")
    String fwxiangmu(Model model, @PathVariable("id") Integer id){
        JiezhengFuwuDO fuwuDO = jiezhengFuwuService.get(id);
        model.addAttribute("fuwuDO",fuwuDO);
        List<String> url = new ArrayList<>();
        String[] split = fuwuDO.getIurl().split("::");
        for(String string : split){
            System.out.println(string);
            url.add(string);
        }
        model.addAttribute("url",url);
        return "information/pc_page/fuwuZDG";
    }


}
