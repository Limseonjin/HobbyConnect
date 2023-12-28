package com.spring.mvc.Contoroller;

import com.spring.mvc.dto.SignUpRequestDTO;
import com.spring.mvc.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


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
}
