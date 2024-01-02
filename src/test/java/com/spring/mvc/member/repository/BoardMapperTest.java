package com.spring.mvc.member.repository;

import com.spring.mvc.member.common.Search;
import com.spring.mvc.member.entity.Board;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardMapperTest {

    @Autowired
    BoardMapper mapper;

    @Test
    @DisplayName("게시물 전체 조회를 하면 room_id가 null인 개시글 전부가 조회된다.")
    void findAllTest() {
        //given

        //when
//        List<Board> boardList = mapper.findAll();
        //then
//        System.out.println("boardList = " + boardList);
    }

    @Test
    @DisplayName("roomid가 null인 게시물이 저장된다.")
    void saveTest() {
        //given
        Board build = Board.builder()
                .personId("swq3064")
                .boardTitle("testMainBoardTitle3")
                .boardContent("testMainBoardContent3")
                .build();
//        mapper.save(build);
        //when

        //then
    }

    @Test
    @DisplayName("boardId가 6인 게시물의 title과 cotent가 수정된다.")
    void modifyTest() {
        //given
        int boardId = 6;
        String boardTitle = "modified testTitle";
        String boardContent = "modified testContent";
        Board build = Board.builder().boardId(boardId).boardTitle(boardTitle).boardContent(boardContent).build();

        //when
//        boolean modify = mapper.modify(build);
        //then
//        assertTrue(modify);
    }

    @Test
    @DisplayName("board_id가 5인 게시물을 삭제하면 삭제된다.")
    void deletTest() {
        //given
        int boardId = 5;
        //when
        boolean delete = mapper.delete(5);
        //then
        assertTrue(delete);
    }

}