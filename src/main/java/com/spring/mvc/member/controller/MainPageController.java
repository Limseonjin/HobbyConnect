package com.spring.mvc.member.controller;

import com.spring.mvc.member.dto.response.MemberResponseDTO;
import com.spring.mvc.member.dto.response.MypageBoardResponseDTO;
import com.spring.mvc.member.entity.Board;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/main")
public class MainPageController {

    //메인 페이지 화면 요청
    @GetMapping("/main-page")
    public String list() {

        return "/mainpage";
    }
}
