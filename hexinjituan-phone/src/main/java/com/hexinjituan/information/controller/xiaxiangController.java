package com.hexinjituan.information.controller;

import com.hexinjituan.information.domain.SkillTrainingDO;
import com.hexinjituan.information.service.SkillTrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class xiaxiangController {

    @Autowired
    private SkillTrainingService skillTrainingService;

    @GetMapping("/xiaxiang")
    String xiaxiang(Model model){
        Map<String , Object> map = new HashMap<>();
        map.put("trainingClass","JISHU_XIAXIANG");
        SkillTrainingDO skillTraining = skillTrainingService.list(map).get(0);
        model.addAttribute("skillTraining",skillTraining);
        return "information/phone_page/xiaxiang";
    }

    @GetMapping("/xiaxiangList")
    String xiaxiangList(Model model){
        Map<String , Object> map = new HashMap<>();
        map.put("trainingClass","JINGDIAN_ANLI");
        List<SkillTrainingDO> list = skillTrainingService.list(map);
        model.addAttribute("list",list);
        return "information/phone_page/xiaxianganli";
    }

    @GetMapping("/getxiaxianganli")
    @ResponseBody
    List<SkillTrainingDO> getxiaxianganli(){
        Map<String , Object> map = new HashMap<>();
        map.put("trainingClass","JINGDIAN_ANLI");
        List<SkillTrainingDO> list = skillTrainingService.list(map);
        return list;
    }

    @GetMapping("/xiaanliXiangqing/{id}")
    String xiaanliXiangqing(Model model, @PathVariable("id") Integer id){
        SkillTrainingDO skillTrainingDO = skillTrainingService.get(id);
        model.addAttribute("skillTraining",skillTrainingDO);
        return "information/phone_page/xiaxianganlidetail";
    }

    @GetMapping("/peixun")
    String peixun(Model model){
        Map<String , Object> map = new HashMap<>();
        map.put("trainingClass","PEIXUN_XIANGMU");
        List<SkillTrainingDO> list = skillTrainingService.list(map);
        model.addAttribute("list",list);
        return "information/phone_page/peixun";
    }

    @GetMapping("/peixunxiangqing")
    String peixunxiangqing(Model model,String name){
        System.out.println(name);
        Map<String , Object> map = new HashMap<>();
        map.put("trainingName",name);
        List<SkillTrainingDO> list = skillTrainingService.list(map);
        if(list.size()>0){
            model.addAttribute("list",list.get(0));
        }
        return "information/phone_page/W-xiaxiang-yuyingyuan";
    }
}
