package com.spring.mvc.member.repository;

import com.spring.mvc.member.entity.MainBoard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MainBoardMapper {

    // 게시글 추가
    boolean save(MainBoard mainBoard);

    // 게시글 조회
    List<MainBoard> findAll();

    // 특정 사용자가 만든 게시글 조회
    List<MainBoard> findPersonId (String personId);

    //사용자가 만든 게시글 아이디로 조회
    MainBoard findMainBoardId (Long mainBoardId);


    //내가 찾고 싶은 방 제목으로 조회
    List<MainBoard> findTitle (String keyword);

    // 게시글 제목 수정
    boolean modify(MainBoard mainBoard);

    //게시글 내용 수정
    boolean modifyContent(MainBoard mainBoard);

    //게시글 삭제
    boolean delete(Long mainBoard);

    // 룸 아이디 업뎃
    boolean roomSave(MainBoard mainBoard);

}
