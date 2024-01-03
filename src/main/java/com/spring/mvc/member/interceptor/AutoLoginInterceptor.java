package com.spring.mvc.member.interceptor;

import com.spring.mvc.member.entity.Member;
import com.spring.mvc.member.repository.MemberMapper;
import com.spring.mvc.member.service.MemberService;
import com.spring.mvc.util.LoginUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@Configuration
@RequiredArgsConstructor
public class AutoLoginInterceptor implements HandlerInterceptor {
    private final MemberMapper memberMapper;
    private final MemberService memberService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1 . 사이트에 들어오면 자동로그인 쿠키를 가진 클라이언트 인지 체크
        Cookie autoLoginCookie = WebUtils.getCookie(request, LoginUtil.AUTO_LOGIN_COOKIE);

        //2. 자동 로그인 쿠키가 있다면 로그인 처리를 수행
        if(autoLoginCookie != null){

            //3. 지금 읽은 쿠키에 들어있는 session_id 를 확인
            String sessionId = autoLoginCookie.getValue();

            //4. DB에서 쿠키에 들어있는 세션아이디를 가진 회원을 조회
            Member member = memberMapper.findMemberByCookie(sessionId);

            //5. 회원이 정상 조회 되고 자동로그인 만료시간 이전이면 로그인을 수행 해준다.
            if(member != null && LocalDateTime.now().isBefore(member.getLimitTime())){
                memberService.maintainLoginState(request.getSession(), member.getPersonId());

            }

        }
        return true;
    }
}
