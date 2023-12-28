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

}
