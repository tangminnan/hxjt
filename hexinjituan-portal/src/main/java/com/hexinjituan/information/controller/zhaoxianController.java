package com.hexinjituan.information.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class zhaoxianController {

    @GetMapping("/zhaoxian")
    String zhaoxian(){
        return "information/pc_page/zhaoxian";
    }
}
