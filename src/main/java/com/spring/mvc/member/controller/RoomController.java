package com.spring.mvc.member.controller;

import com.spring.mvc.member.dto.request.RoomRequestDTO;
import com.spring.mvc.member.service.BoardService;
import com.spring.mvc.member.service.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/board")
public class RoomController {

    private final RoomService roomService;
    private final BoardService boardService;

    // 방 만들기 화면 요청
    @GetMapping("/room")
    public String Room(){
        return "board/writepost";
    }

    //방 만들기 등록 요청
    @PostMapping("/room")
    public String Room(RoomRequestDTO dto, HttpSession session){
        roomService.makeRoom(dto, session);
        return "board/writepost";
    }
}
