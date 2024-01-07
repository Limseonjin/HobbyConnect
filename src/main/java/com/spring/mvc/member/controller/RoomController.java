package com.spring.mvc.member.controller;


import com.spring.mvc.member.entity.Room;
import com.spring.mvc.member.service.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/room")
public class RoomController {

    private final RoomService roomService;

    // 방 만들기 화면 요청
    @GetMapping("/room")
    public String Room(){
        return "board/writepost";
    }
    //방 만들기 등록 요청
    @PostMapping("/room")
    public String Room(Room room,
                       HttpSession session){

        roomService.makeRoom(room, session);
        return "redirect:/main/main-page";
    }

}
