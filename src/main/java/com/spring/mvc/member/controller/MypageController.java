package com.spring.mvc.member.controller;

import com.spring.mvc.member.dto.response.MypageBoardResponseDTO;
import com.spring.mvc.member.service.MypageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MypageController {
    private final MypageService mypageService;

    // 1. 내가 쓴 게시글 전체 조회 요청
    @GetMapping("/board")
    public String list(HttpSession session, Model model) {
        List<MypageBoardResponseDTO> boardList = mypageService.getBoardList(session);
        model.addAttribute("bList", boardList);
        log.debug("bList:{}",boardList);
        return "/myPage/myboard";
    }
}
