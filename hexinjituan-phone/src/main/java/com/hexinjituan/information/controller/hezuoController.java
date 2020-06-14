package com.hexinjituan.information.controller;

import com.hexinjituan.information.domain.*;
import com.hexinjituan.information.service.HezuosheService;
import com.hexinjituan.information.service.LaowuAnliService;
import com.hexinjituan.information.service.StudentsElegantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class hezuoController {

    @Autowired
    private HezuosheService hezuosheServiceImpl;
    @Autowired
    private StudentsElegantService studentsElegantService;
    @Autowired
    private LaowuAnliService laowuAnliService;
    public static final String[] ARRAY={"帮社员讨薪","为社员协商工伤问题","技能提升", "就业安置","农民积极入社"};

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
        return "information/phone_page/W-hezuoshe";
    }

    @GetMapping("/hezuo/anli/{title}")
    public String  hezuosheAnLi(@PathVariable("title") String title, Model model){
        model.addAttribute("title",title);
        List<LaowuAnliCateDO> data  = new ArrayList<LaowuAnliCateDO>();
        for(int i=0;i<ARRAY.length;i++){
            List<LaowuAnliCateDO> laowuAnliCateDOS = hezuosheServiceImpl.listLaowuAll(ARRAY[i]);
            data.addAll(laowuAnliCateDOS);
        }
        model.addAttribute("data",data);
        return "information/phone_page/W-hezuosheanli";
    }

    /**
     * 合作社案例详情
     */
    @GetMapping("/hezuo/anli/detail/{id}")
    public String hezuoAnliDetail(@PathVariable("id") Integer id,Model model){
        LaowuAnliDO laowuAnliDO = laowuAnliService.get(id);
        model.addAttribute("laowuAnliDO",laowuAnliDO);
        laowuAnliDO.setStr(new SimpleDateFormat("yyyy.MM.dd").format(laowuAnliDO.getCreateTime()));
        return "information/phone_page/anlidetail";
    }
}
