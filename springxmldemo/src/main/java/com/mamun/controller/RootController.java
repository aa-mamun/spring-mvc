package com.mamun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RootController {

    @RequestMapping(value = "/")
    String getIndexPage(){
        System.out.println("Root Page");
        return "index";
    }
}
