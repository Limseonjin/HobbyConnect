package com.spring.mvc.member.service;

import com.spring.mvc.member.dto.AutoLoginDTO.AutoLoginDTO;
import com.spring.mvc.member.dto.request.LoginRequestDTO;
import com.spring.mvc.member.dto.request.SignUpRequestDTO;
import com.spring.mvc.member.dto.response.LoginUserResponseDTO;
import com.spring.mvc.member.entity.LoginResult;
import com.spring.mvc.member.entity.Member;
import com.spring.mvc.member.repository.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.time.LocalDateTime;

import static com.spring.mvc.util.LoginUtil.*;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;
    private final PasswordEncoder encoder;

    //회원가입 처리 서비스
    public boolean join(SignUpRequestDTO dto){

        //클라이언트가 보낸 회원가입 데이터를
        //패스워드 인코딩하여 엔터티로 변환해서 전달
        return memberMapper.save(dto.toEntity(encoder));
    }

    //로그인 검증 처리
    public LoginResult authenticate(LoginRequestDTO dto,
                                    HttpSession session,
                                    HttpServletResponse response){

        Member foundMember = memberMapper.findMember(dto.getPersonId());

        if (foundMember == null){ //회원가입 안한 상태
            log.info("{} - 아이디 또는 비밀번호를 다시 확인 해주세요.",dto.getPersonId());
            return LoginResult.NO_ACC;
        }
        //비밀번호 일치 검사
        String inputPassword = dto.getPassword(); //사용자가 입력한 패스워드
        String realPassword = foundMember.getPassword(); // 실제 입력한 패스워드
        if(!encoder.matches(inputPassword, realPassword)){
            log.info("아이디 또는 비밀번호를 다시 확인 해주세요.");
            return LoginResult.NO_PW;
        }

        //로그인을 성공 하기 직전에 자동 로그인 처리
        if(dto.isAutoLogin()){
            //1. 자동 로그인 쿠키 생성 - 쿠키 안에 절대 중복되지 않는 값(브라우저의 세션 아이디)을 저장

            Cookie autoLoginCookie = new Cookie(AUTO_LOGIN_COOKIE, session.getId());

            //2쿠키 설정 - 사용경로, 수명
            int limitTime = 60 * 60 * 24 * 90 ;//자동 로그인 유지 시간
            autoLoginCookie.setPath("/");
            autoLoginCookie.setMaxAge(limitTime);

            //3 쿠키를 클라이언트에 전송
            response.addCookie(autoLoginCookie);

            //4. DB 에도 쿠키에 관련된 것들을(랜덤 세션키, 만료시간)저장
            memberMapper.saveAutoLogin(
                    AutoLoginDTO.builder()
                            .sessionId(session.getId())
                            .limitTime(LocalDateTime.now().plusDays(90))
                            .personId(dto.getPersonId())
                            .build()
            );

        }

        log.info("{}님 로그인 성공!",foundMember.getPersonId());

        return LoginResult.SUCCESS;
    }

    private Member getMember(String account) {
        return memberMapper.findMember(account);
    }

    //아이디 이메일 중복검사 서비스
    public boolean checkDuplicateValue(String type, String keyword){
        return memberMapper.isDuplicate(type, keyword);
    }

    // 세션을 사용해서 일반 로그인 유지하기
    public void maintainLoginState(HttpSession session, String account) {

        // 세션은 서버에서만 유일하게 보관되는 데이터로서
        // 로그인 유지 등 상태유지가 필요할 때 사용되는 개념입니다.
        // 세션은 쿠키와 달리 모든 데이터를 저장할 수 있습니다.
        // 세션의 수명은 설정한 수명시간에 영향을 받고 브라우저의 수명과 함께한다.

        // 현재 로그인한 사람의 모든 정보 조회
        Member member = getMember(account);

        //DB 데이터를 보여줄 것만 정제
        LoginUserResponseDTO dto = LoginUserResponseDTO.builder()
                .personId(member.getPersonId())
                .email(member.getEmail())
                .nickname(member.getNickname())
                .introduction(member.getIntroduction()).build();
//                .auth(member.getAuth().toString()).build();


        //세션에 로그인한 회원의 정보를 저장
        session.setAttribute(LOGIN_KEY,dto);

        //세션도 수명을 설정해야 함
        session.setMaxInactiveInterval(60 * 60); //1시간
    }

    //자동 로그인 상태에서 로그아웃을 하면 쿠키와 세션을 모두 삭제
    public void autoLoginClear(HttpServletRequest request, HttpServletResponse response) {

        // 1. 자동로그인 쿠키를 가져오기
        Cookie cookie = WebUtils.getCookie(request, AUTO_LOGIN_COOKIE);

        //2. 쿠키를 삭제한다
        // -> 쿠키의 수명을 0초로 설정하여 다시 클라이언트에 접속
        if (cookie != null){
            cookie.setMaxAge(0);
            cookie.setPath("/");
            response.addCookie(cookie);
            //3. 데이터 베이스도 session_id와 limit_time을 제거
            memberMapper.saveAutoLogin(
                    AutoLoginDTO.builder()
                            .sessionId("none")
                            .limitTime(LocalDateTime.now())
                            .personId(getCurrentLoginMemberAccount(request.getSession()))
                            .build()
            );
        }
    }
}
