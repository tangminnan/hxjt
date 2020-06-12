package com.hexinjituan.information.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class jiamengController {

    @GetMapping("/jiameng")
    String jiameng(){
        return "information/phone_page/jiameng";
    }
}
