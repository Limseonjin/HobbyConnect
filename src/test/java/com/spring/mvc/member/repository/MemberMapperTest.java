package com.spring.mvc.member.repository;

import com.spring.mvc.member.entity.Member;
import com.spring.mvc.member.entity.location;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberMapperTest {


    @Autowired
    MemberMapper memberMapper;

    @Autowired
    PasswordEncoder encoder;

    @Test
    @DisplayName("회원가입에 성공을 해야 한다.")
    void saveTest(){
        //given
      Member member = Member.builder()
                .personId("TaeYong")
                .password(encoder.encode("hello123"))
              .nickname("태용이다")
                .email("Taeyong@naver.com")
                .location("충남")
                .introduction("여여 난 태용이다")
                .build();
        //when
        boolean flag = memberMapper.save(member);

        //then
        assertTrue(flag);
    }

    @Test
    @DisplayName("hhhhgong3 계정을 조회 하면 그 회원의 닉네임이 태드레곤 이어야 한다.")
    void findMemberTest(){
        //given
        String acc = "Taeyong";
        //when
        Member foundMember = memberMapper.findMember(acc);
        //then
        System.out.println("foundMember = " + foundMember);
        assertEquals("태용이다",foundMember.getNickname());
    }

    @Test
    @DisplayName("계정이 seonjin 일 경우 중복 검사 시 결과값은 false 이어야 한다.")
    void duplicationTest(){
        //given
        String acc = "seonjin";
        //when
       boolean flag =  memberMapper.isDuplicate("personId",acc);
       //then
        assertFalse(flag);
    }

    @Test
    @DisplayName("이메일 hhhhgong2@naver.com 일 경우 중복 검사 시 결과값은 false 이어야 한다.")
    void EmailduplicationTest(){
        //given
        String email = "hhhhgong2@naver.com";
        //when
        boolean flag =  memberMapper.isDuplicate("personId",email);
        //then
        assertFalse(flag);
    }

    @Test
    @DisplayName("닉네임이 선드래곤 일 경우 중복 검사 시 결과값은 false 이어야 한다.")
    void nickNameduplicationTest(){
        //given
        String nickName = "선드래곤";
        //when
        boolean flag =  memberMapper.isDuplicate("personId",nickName);
        //then
        assertFalse(flag);
    }

    @Test
    @DisplayName("비밀번호가 암호화가 되어야 한다.")
    void encodingTest(){
        //인코딩 전 패스워드
        String rawPassword = "zxc123!@#";

        //인코딩 후 패스워드
        String encode = encoder.encode(rawPassword);

        System.out.println("rawPassword = " + rawPassword);
        System.out.println("encode = " + encode);
    }



}