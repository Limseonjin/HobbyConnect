package com.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexTest {

//    @RequestMapping("/mypage/del")
//    public String myInfTest() {
//        return "mypage/myinfodel";
//    }
    @RequestMapping("/board/detail")
    public String mdTest() {
        return "/board/detail";
    }
    @RequestMapping("/mypage/room")
    public String mprTest() {
        return "/mypage/myroom";
    }
}
