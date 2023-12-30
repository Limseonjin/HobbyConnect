package com.spring.mvc.member.repository;

import com.spring.mvc.member.entity.Board;
import com.spring.mvc.member.entity.Member;
import com.spring.mvc.member.entity.Reply;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface MypageMapper {

    //회원 조회
    Member findMember(String personId);

    // 1. 내가 쓴 게시글 전체 조회
    List<Board> findAllMyBoard(String personId);

    // 2. 내가 쓴 댓글 전체 조회
    List<Reply> findAllMyReply(String personId);

    // 3. 프사 (추후 제작)

    // 4. 한줄 소게 조회
    Member findIntroduction(String personId);

    // 5. 닉네임 수정
    boolean modifyNickName(Member member);

    // 6. 지역 수정
    boolean modifyLocation(Member member);

}