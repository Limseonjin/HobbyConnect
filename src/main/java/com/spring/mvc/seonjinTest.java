package com.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class seonjinTest {
    @RequestMapping("/board")
    public String Test() {
        return "board/writepost";
    }

    @RequestMapping("/oneroom")
    public String tsTest() {
        return "room/mainroom";
    }
}
