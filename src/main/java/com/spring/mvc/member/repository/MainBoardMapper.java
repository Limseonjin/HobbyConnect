package com.spring.mvc.member.repository;

import com.spring.mvc.member.common.Page;
import com.spring.mvc.member.entity.MainBoard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MainBoardMapper {

    // 게시글 추가
    boolean save(MainBoard mainBoard);

    // 게시글 조회
    List<MainBoard> findAll();

    //페이징 처리한 게시글 조회
    List<MainBoard> pagefindAll( @Param("p") Page page);

    // 특정 사용자가 만든 게시글 조회
    List<MainBoard> findPersonId (@Param("personId") String personId, @Param("p")Page page);

    //내가 찾고 싶은 방 제목으로 조회
    List<MainBoard> findTitle (@Param("keyword") String keyword,@Param("p") Page page);

    // 게시글 제목 수정
    boolean modify(MainBoard mainBoard);

    //게시글 내용 수정
    boolean modifyContent(MainBoard mainBoard);

    //게시글 삭제
    boolean delete(Long mainBoard);

    void roomSave(MainBoard mainBoard);


}
