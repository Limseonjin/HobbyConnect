package com.spring.mvc.member.controller;

import com.spring.mvc.member.common.Page;
import com.spring.mvc.member.dto.request.RoomModifyRequestDTO;
import com.spring.mvc.member.dto.response.MemberResponseDTO;
import com.spring.mvc.member.dto.response.MypageBoardResponseDTO;
import com.spring.mvc.member.entity.Board;
import com.spring.mvc.member.entity.Room;
import com.spring.mvc.member.service.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/main")
public class MainPageController {

    private final RoomService roomService;


    //메인 페이지 화면 요청
    @GetMapping("/main-page")
    public String list(HttpSession session) {
        System.out.println("session = " + session);
        return "/mainpage";
    }
}
