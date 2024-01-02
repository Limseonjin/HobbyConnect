package com.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexTest {

    @RequestMapping("/mp")
    public String Test() {
        return "myPage/myboard";
    }

    @RequestMapping("/mr")
    public String mTest() {
        return "myPage/myreply";
    }
    @RequestMapping("/info")
    public String myInfoTest() {
        return "myPage/myinfo";
    }
//    @RequestMapping("/main")
//    public String moTest() {
//        return "/mainpage";
//    }

}
