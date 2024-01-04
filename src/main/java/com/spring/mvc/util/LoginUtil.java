package com.spring.mvc.util;

import com.spring.mvc.member.dto.response.LoginUserResponseDTO;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


//회원 인증,인가 관련된 상수와 메서드를 가진 객체
public class LoginUtil {

    //로그인 세션 키
    public static final String LOGIN_KEY = "login";

    //자동 로그인 쿠키 이름
    public static final String AUTO_LOGIN_COOKIE = "auto";

    //로그인 여부 확인
    public static boolean isLogin(HttpSession session){
        return session.getAttribute(LOGIN_KEY) != null;
    }



    //자동 로그인 여부 확인
    public static boolean isAutoLogin(HttpServletRequest request){
        return WebUtils.getCookie(request, AUTO_LOGIN_COOKIE) != null;
    }

    // 로그인한 사람의 계정명을 반환하는 메서드
    public static String getCurrentLoginMemberAccount(HttpSession session) {
        LoginUserResponseDTO loginUserInfo
                = (LoginUserResponseDTO) session.getAttribute(LOGIN_KEY);
        return loginUserInfo.getPersonId();
    }

    //관리자 인지 확인해 주는 메서드
    public static boolean isAdmin(HttpSession session){
        LoginUserResponseDTO loginUser =
                (LoginUserResponseDTO) session.getAttribute(LOGIN_KEY);
        return loginUser.getAuth().equals("ADMIN");
    }

    //내가 쓴 게시물 인지 확인해주는 메서드
    public static boolean inMine(HttpSession session, String targetAccount){
        return targetAccount.equals(getCurrentLoginMemberAccount(session));
    }

}
