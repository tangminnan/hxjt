package com.hexinjituan.information.controller;

import com.hexinjituan.common.utils.R;
import com.hexinjituan.information.domain.LeaveMsgDO;
import com.hexinjituan.information.service.LeaveMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class lianxiController {

    @Autowired
    private LeaveMsgService leaveMsgService;

    @GetMapping("/lianxi")
    String lianxi(@RequestParam(value = "ad",required = false) String ad,Model model){
        model.addAttribute("ad",ad==null?"":ad);
        return "information/pc_page/lianxi";
    }

    @PostMapping("/save/leaveMsg")
    @ResponseBody
    R leaveMsg(LeaveMsgDO leaveMsgDO){
        leaveMsgDO.setDeleted(0);
        leaveMsgDO.setCreateTime(new Date());
        int save = leaveMsgService.save(leaveMsgDO);
        if (save>0){
            return R.ok();
        }
        return R.error();
    }
}
