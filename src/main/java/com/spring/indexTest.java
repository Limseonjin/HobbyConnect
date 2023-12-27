package com.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexTest {

    @RequestMapping("/index")
    public String Test() {
        return "index";
    }
    @RequestMapping("/head")
    public String headTest(){
        return "/common/head";
    }

}
