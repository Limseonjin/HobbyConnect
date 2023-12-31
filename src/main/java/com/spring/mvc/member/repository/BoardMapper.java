package com.spring.mvc.member.repository;


import com.spring.mvc.member.dto.request.BoardModifyRequestDTO;
import com.spring.mvc.member.entity.Board;
import com.spring.mvc.member.entity.Room;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {

    //방 안에 게시글 을 만들것이다.
    boolean save(Board board);

    //방안에 게시글 전체 조회
    List<Board> findAll();


    //방 하나 조회
    Board findOne(Long boardId);

    //방안에 게시글을 수정 할 수 있다.
    boolean modify(BoardModifyRequestDTO dto);

    //방안에 게시글을 삭제 할 수 있다.
    boolean delete(Long boardId);

    void updateViewCount(Long boardId);

    int count(Long roomId);

}
