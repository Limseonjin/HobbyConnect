package com.spring.mvc.member.controller;

import com.spring.mvc.member.service.MypageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
@Slf4j
@RequiredArgsConstructor
public class MypageController {
    private final MypageService mypageService;

    // 1. 내가 쓴 글 조회

    // 2. 내가 쓴 댓글 조회

    // 3. 프사 (추후 제작)

    // 4. 한줄 소개 조회

    // 5. 닉네임 수정

    // 6. 지역 수정
}
