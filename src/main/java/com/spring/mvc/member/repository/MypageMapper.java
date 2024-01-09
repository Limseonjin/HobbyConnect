package com.spring.mvc.member.repository;

import com.spring.mvc.member.dto.response.MypageReplyResponseDTO;
import com.spring.mvc.member.entity.Board;
import com.spring.mvc.member.entity.Member;
import com.spring.mvc.member.entity.Reply;
import com.spring.mvc.member.entity.Room;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface MypageMapper {

    //회원 조회
    Member findMember(String personId);

    // 메인보드 조회
    List<Room> findAllMyRoom(String personId);

    // 1. 내가 쓴 게시글 전체 조회
    List<Board> findAllMyBoard(String personId);

    // 2. 내가 쓴 댓글 전체 조회
    List<MypageReplyResponseDTO> findAllMyReply(String personId);

    // 3. 프사 (추후 제작)

    // 4. 한줄 소게 조회
    Member findIntroduction(String personId);

    // 5. 수정
    // -회원정보 수정
    boolean modifyInfo(Member member);
    // -회원 비밀번호 수정
    boolean modifyPassword(Member member);

    // 6. 회원 삭제
    boolean delMember(String personId);


}
