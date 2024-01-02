package com.spring.mvc.member.repository;

import com.spring.mvc.member.common.Search;
import com.spring.mvc.member.entity.Board;
import com.spring.mvc.member.entity.MainBoard;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    // 1. 조회
    List<MainBoard> findAll();
    // 2. 추가
    boolean save(MainBoard MainBoard);
    // 3. 수정(title, content)
    boolean modify(MainBoard MainBoard);
    // 4. 삭제
    boolean delete(long boardId);

}
