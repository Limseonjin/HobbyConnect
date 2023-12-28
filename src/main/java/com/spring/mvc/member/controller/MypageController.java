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

    // 1. 마이페이지 조회 요청

    // 2. 프사 (추후 제작)


    // 3. 닉네임 수정 요청

    // 4. 지역 수정 요청
}
