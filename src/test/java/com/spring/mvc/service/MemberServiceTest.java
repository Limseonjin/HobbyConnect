package com.spring.mvc.service;

import com.spring.mvc.member.dto.LoginRequestDTO;
import com.spring.mvc.member.dto.SignUpRequestDTO;
import com.spring.mvc.member.entity.LoginResult;
import com.spring.mvc.member.entity.location;
import com.spring.mvc.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static com.spring.mvc.member.entity.LoginResult.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberService memberService;


    @Test
    @DisplayName("회원정보를 전달하면 비밀번호가 암호화 되어 디비에 저장된다.")
    void joinTest() {
        //given
        SignUpRequestDTO dto = SignUpRequestDTO.builder()
                .personId("kitty")
                .password("kitty1234")
                .nickname("태용키티")
                .email("hhhhasdf@naver.com")
                .locationEnum(location.Busan)
                .build();
        //when
        boolean flag = memberService.join(dto);
        //then
        assertTrue(flag);
    }

    @Test
    @DisplayName("계정명이 kitty인 회원의 로그인시도 결과 로그인이 성공 해야 한다. .")
    void loginTest() {
        //given
        LoginRequestDTO dto = LoginRequestDTO.builder()
                .personId("kitty")
                .password("kitty1234")
                .build();
        //when
        LoginResult result = memberService.authenticate(dto, null,null);
        //then

        assertEquals(SUCCESS, result);
    }

    @Test
    @DisplayName("계정명이 kitty인 회원의 로그인시도 아이디가 틀려야 한다.")
    void IncorrectAccount () {
        //given
        LoginRequestDTO dto = LoginRequestDTO.builder()
                .personId("kitty2")
                .password("kitty1234")
                .build();
        //when
        LoginResult result = memberService.authenticate(dto,null,null);
        //then

        assertEquals(NO_ACC, result);
    }

    @Test
    @DisplayName("계정명이 kitty인 회원의 로그인시도 패스워드가 틀려야 한다.")
    void IncorrectPassword () {
        //given
        LoginRequestDTO dto = LoginRequestDTO.builder()
                .personId("kitty")
                .password("kitty12345")
                .build();
        //when
        LoginResult result = memberService.authenticate(dto,null,null);
        //then

        assertEquals(NO_PW, result);
    }





}
