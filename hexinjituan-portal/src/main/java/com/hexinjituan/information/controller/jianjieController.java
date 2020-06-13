package com.hexinjituan.information.controller;

import com.hexinjituan.information.domain.CompanyGongchengDO;
import com.hexinjituan.information.domain.CompanyGongyiDO;
import com.hexinjituan.information.domain.CompanyInfoDO;
import com.hexinjituan.information.domain.StudentsElegantDO;
import com.hexinjituan.information.service.CompanyGongchengService;
import com.hexinjituan.information.service.CompanyGongyiService;
import com.hexinjituan.information.service.CompanyInfoService;
import com.hexinjituan.information.service.StudentsElegantService;
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
public class jianjieController {

    @Autowired
    private CompanyInfoService companyInfoService;
    @Autowired
    private StudentsElegantService studentsElegantService;
    @Autowired
    private CompanyGongyiService companyGongyiService;
    @Autowired
    private CompanyGongchengService companyGongchengService;

    @GetMapping("/jianjie")
    String jianjie(Model model){
        Map<String, Object> map = new HashMap<>();
        map.put("ifJianjie","COMPANY_JIANJIE");
        CompanyInfoDO info = new CompanyInfoDO();
        List<CompanyInfoDO> companyInfoDOList = companyInfoService.list(map);
        if(companyInfoDOList.size()>0)
            info= companyInfoDOList.get(0);
        model.addAttribute("jinjie",info);
        Map<String,Object> map1 = new HashMap<String, Object>();
        map1.put("typeName","SHENGHUO_ZHAO");
        List<StudentsElegantDO> shenghuo = studentsElegantService.list(map1);
        model.addAttribute("shenghuo",shenghuo);
        List<CompanyInfoDO> list = companyInfoService.list(new HashMap<>());
        model.addAttribute("list",list);
        return "information/pc_page/jianjie";
    }

    @GetMapping("/jianjie/xiangqing/{id}")
    String xiangqing(Model model, @PathVariable("id") Integer id){
        CompanyInfoDO companyInfoDO = companyInfoService.get(id);
        model.addAttribute("companyInfoDO",companyInfoDO);
        if(companyInfoDO.getCompanyName().contains("装饰")){//装饰公司单独处理
            Map<String,Object> map = new HashMap<String,Object>();
            map.put("companyId",id);
            List<CompanyGongchengDO> gongxheng = companyGongchengService.list(map);
            model.addAttribute("gongcheng",gongxheng);
            return "information/pc_page/zhuangshigongcheng";
        }else{

            return "information/pc_page/jiuye1";
        }
    }

    @GetMapping("/gongyi")
    String gongyi(Model model){
        CompanyGongyiDO newGongyi = companyGongyiService.getNewGongyi();
        model.addAttribute("newGongyi",newGongyi);
        return "information/pc_page/gongyi";
    }

    @GetMapping("/gongyiList")
    String gongyiList(){
        return "information/pc_page/gongyiList";
    }

    @GetMapping("/getjuankuananli")
    @ResponseBody
    List<CompanyGongyiDO> getjuankuananli(){
        Map<String, Object> map = new HashMap<>();
        map.put("gongyiClass","慈善捐款案例");
        List<CompanyGongyiDO> list = companyGongyiService.list(map);
        return list;
    }

    @GetMapping("/jukuanliXiangqing/{id}")
    String jukuanliXiangqing(Model model,@PathVariable("id") Integer id){
        CompanyGongyiDO gongyiDO = companyGongyiService.get(id);
        model.addAttribute("gongyiDO",gongyiDO);
        return "information/pc_page/gongyi-juankuananli";
    }

    @GetMapping("/jianjie/anlixiangqing/{id}")
    public String jianjieanlixiangqing(@PathVariable("id") Integer id,Model model){
        CompanyGongchengDO companyGongchengDO = companyGongchengService.get(id);
        model.addAttribute("companyGongchengDO",companyGongchengDO);
        return "information/pc_page/3Ddayin";
    }

}
