package com.spring.mvc.member.repository;

import com.spring.mvc.member.dto.AutoLoginDTO.AutoLoginDTO;
import com.spring.mvc.member.entity.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MemberMapper {

    //회원 가입
    boolean save(Member member);


    //회원 정보 단일 조회
    Member findMember(String personId);
    /**
     *  //중복 체크(personId, email) 기능
     * @param type - 중복을 검사할 내용 (PersonId, email)
     * @param keyword - 중복 검사 입력값(ex : abc@gmail.com...)
     * @return 중복이면 true, 중복이 아니면 false
     */
    boolean isDuplicate(@Param("type") String type, @Param("keyword") String keyword);

    //자동 로그인 세션키 , 만료시간 업데이트
    void saveAutoLogin(AutoLoginDTO dto);

    //쿠키값(세션 아이디)으로 회원 정보를 조회
    Member findMemberByCookie(String sessionId);
}
