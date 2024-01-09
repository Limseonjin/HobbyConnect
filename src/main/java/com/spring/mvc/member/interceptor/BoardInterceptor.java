package com.spring.mvc.member.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Configuration
@Slf4j

/*
        인터셉터란 ? 컨트롤러에 요청이 들어가기 전과 후에
                    공통적으로 처리할 코드나 검사할 일들을 정의해 놓는 클래스
 */

public class BoardInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession();
        //로그인을 안했으면 글쓰기, 글 수정, 글 삭제 요청을 튕겨낼 것
        if(session.getAttribute("login") == null){
            log.info("this request ({}) is denied !! :",request.getRequestURI());
            response.sendRedirect("/login/sign-in");
            return false;
        }
        return true;
    }
}
