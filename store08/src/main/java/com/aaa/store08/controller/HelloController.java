package com.aaa.store08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello")
public class HelloController {
    @RequestMapping("hello")
    public String Hello(){
        return "page/index";
    }
}
