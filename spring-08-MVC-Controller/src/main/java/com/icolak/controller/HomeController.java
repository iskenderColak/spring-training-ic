package com.icolak.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String getHomePage() {
        return "home.html";
    }

    @RequestMapping("/ozzy")
    public String getHomePage2() {
        return "home-ozzy.html";
    }

    @RequestMapping
    public String getHomePage3() {
        return "home-nothing.html";
    }

    @RequestMapping({"/apple", "/orange"})
    public String getHomePage4() {
        return "home-apple-orange.html";
    }

}
