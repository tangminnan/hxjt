package com.hexinjituan.information.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class lianxiController {

    @GetMapping("/lianxi")
    String lianxi(){
        return "information/pc_page/lianxi";
    }
}
