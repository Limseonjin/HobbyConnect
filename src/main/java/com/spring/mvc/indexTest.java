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
    @RequestMapping("/serch")
    public String mdTe() {
        return "/mainserch";

    }
}
