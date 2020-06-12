package com.hexinjituan.information.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class hezuoController {

    @GetMapping("/hezuo")
    String hezuo(){
        return "information/phone_page/hezuo";
    }
}
