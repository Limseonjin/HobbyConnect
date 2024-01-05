package com.spring.mvc.member.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/board")
public class RoomController {

    // 방 만들기 화면 요청
    @GetMapping("/room")
    public String Room(){
        return "board/writepost";
    }


}
