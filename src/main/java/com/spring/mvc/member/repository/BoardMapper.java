package com.spring.mvc.member.repository;

import com.spring.mvc.member.common.Search;
import com.spring.mvc.member.entity.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    // 1. 조회
    List<Board> findAll();
    // 2. 추가
    boolean save(Board board);
    // 3. 수정(title, content)
    boolean modify(Board board);
    // 4. 삭제
    boolean delete(int boardId);

}
