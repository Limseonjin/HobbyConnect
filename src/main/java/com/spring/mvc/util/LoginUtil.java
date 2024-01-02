package com.spring.mvc.util;

import com.spring.mvc.member.dto.response.LoginUserResponseDTO;

import javax.servlet.http.HttpSession;

public class LoginUtil {

    //로그인 세션 키
    public static final String LOGIN_KEY = "login";

    //로그인 여부 확인
    public static boolean isLogin(HttpSession session){
        return session.getAttribute(LOGIN_KEY) != null;
    }

    // 로그인한 사람의 계정명을 반환하는 메서드
    public static String getCurrentLoginMemberAccount(HttpSession session) {
        LoginUserResponseDTO loginUserInfo
                = (LoginUserResponseDTO) session.getAttribute(LOGIN_KEY);
        return loginUserInfo.getPersonId();
    }

}
