package com.spring.mvc.member.controller;

import com.spring.mvc.member.dto.request.MainBoardRequestDTO;
import com.spring.mvc.member.dto.request.RoomRequestDTO;
import com.spring.mvc.member.dto.response.MainBoardResponseDTO;
import com.spring.mvc.member.service.MainBoardService;
import com.spring.mvc.member.service.RoomService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    private final MainBoardService mainBoardService;

    // 방 만들기 화면 요청
    @GetMapping("/room")
    public String Room(){
        return "board/writepost";
    }

    //방 만들기 등록 요청
    @PostMapping("/room")
    public String Room(MainBoardRequestDTO dto,
                       HttpSession session){
        roomService.makeRoom(dto, session);
        mainBoardService.save(dto, session);
        return "redirect:/main/main-page";
    }

}
