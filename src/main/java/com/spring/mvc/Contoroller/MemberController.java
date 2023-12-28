package com.spring.mvc.Contoroller;

import com.spring.mvc.dto.LoginRequestDTO;
import com.spring.mvc.dto.SignUpRequestDTO;
import com.spring.mvc.member.entity.LoginResult;
import com.spring.mvc.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/login")
public class MemberController {



    private final MemberService memberService;

    // 회원가입 요청 ->
    @GetMapping("/sign-up")
    public String signUp(){
        log.info("/login/sign-up GET : forwarding to sign-up.jsp");
    return"login/sign-up";
    }
    @GetMapping("/sign-in")
    public String signIn(){
        log.info("/login/sign-up GET : forwarding to sign-up.jsp");
    return"login/sign-in";
    }

    //아이디, 이메일 중복체크 비동기 요청 처리
    @GetMapping("/check")
    @ResponseBody
    public ResponseEntity<?> check(String type, String keyword){
        log.info("/login/check?type={}&keyword={} ASYNC GET",type, keyword);
        boolean flag = memberService.checkDuplicateValue(type, keyword);
        log.debug("중복체크 결과 : {}",flag);
        return ResponseEntity.ok().body(flag);
    }

    //회원가입 처리
    @PostMapping("/sign-up")
    public String signUp(SignUpRequestDTO dto){
        log.info("/login/sign-up POST ~");
        log.debug("parameter : {}", dto);
        boolean flag = memberService.join(dto);
        return flag ? "redirect:/hoddy/list/ " : "redirect:/login/sign-up";
    }

    //로그인 양식 요청
    @GetMapping("/sign-in")
    public String SignIn() {
        log.info("/login/sign-in GET - forwarding to sign-in.jspr");
        return "login/sign-in";
    }

    //로그인 검증 요청
    @PostMapping("/sign-in")
    // Model에 담긴 데이터는 리다이렉트시 jsp로 가지 않음
    // 왜냐하면 리다이렉트는 요청이 2번 들어가서 첫번째 요청시 보관한 데이터가 손실 됨.
    public String signIn(LoginRequestDTO dto, RedirectAttributes ra, HttpServletResponse response, HttpSession session){
        log.info("/login/sign-in POST !!!");
        log.debug("parameter : {}", dto);

        LoginResult result = memberService.authenticate(dto,session,response);
        log.debug("login result :{}",result);

        ra.addFlashAttribute("msg",result);

        if (result == LoginResult.SUCCESS){ //로그인 성공 시

            //세션으로 로그인을 유지한다.
            memberService.maintainLoginState(session,dto.getPersonId());
            return"redirect:/hobby";
        }
        return "redirect:/login/sign-in"; //로그인 실패 시
    }

    //로그아웃 처리
    @GetMapping("/sign-out")
    public String signOut(HttpServletResponse response,
                          HttpServletRequest request,
                          Authentication authentication){
        if(authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/hobby";
    }
}



