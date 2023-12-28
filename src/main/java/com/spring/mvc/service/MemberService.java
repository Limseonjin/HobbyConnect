package com.spring.mvc.service;

import com.spring.mvc.dto.LoginRequestDTO;
import com.spring.mvc.dto.SignUpRequestDTO;
import com.spring.mvc.member.entity.Member;
import com.spring.mvc.member.repository.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

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
    public LoginResult authenticate(LoginRequestDTO dto){

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

        log.info("{}님 로그인 성공!",foundMember.getPersonId());
        return LoginResult.SUCCESS;
    }

    //아이디 이메일 중복검사 서비스
    public boolean checkDuplicateValue(String type, String keyword){
        return memberMapper.isDuplicate(type, keyword);
    }
}
