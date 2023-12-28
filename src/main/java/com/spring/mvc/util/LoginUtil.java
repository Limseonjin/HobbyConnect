package com.spring.mvc.util;

import javax.servlet.http.HttpSession;

public class LoginUtil {

    //로그인 세션 키
    public static final String LOGIN_KEY = "login";

    //로그인 여부 확인
    public static boolean isLogin(HttpSession session){
        return session.getAttribute(LOGIN_KEY) != null;
    }
}
