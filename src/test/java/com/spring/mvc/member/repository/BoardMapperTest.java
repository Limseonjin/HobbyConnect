package com.spring.mvc.member.repository;

import com.spring.mvc.member.entity.Board;
import com.spring.mvc.member.entity.RoomMember;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.beans.Transient;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardMapperTest {

    @Autowired
    BoardMapper boardMapper;
    @Test
    @DisplayName("방 안에 게시글을 만들기에 성공 해야 한다.")
    void save() {
        //given
        Board board = Board.builder()
                .personId("hhhhgong3")
                .boardTitle("내 게시글 보면 저주 걸림 ㅅㄱ")
                .boardContent("이 글을 본 순간 당신은 저주에 걸렸습니다.")
                .roomId(1L)
                .build();
        //when
        boolean flag = boardMapper.save(board);
        //then
        assertTrue(flag);
    }

    @Test
    @DisplayName("방안 게시물 안에 있는 회원이 전부 조회 되어야 한다. ")
    void findAll() {
        //given
        List<Board> all = boardMapper.findAll();

        //when
        assertEquals(1,all.size());

    }
    @Test
    @DisplayName("방안 게시물(1번게시물) 안에 있는 게시글들을 수정 할 수 있어야 한다.")
    void modify() {
        //given

        String boardTitle= "저주에 풀렸습니다~~~ 수고";
        String boardContent = "저주를 풀었다!";
        //when
        Board modify = Board.builder()
                .boardId(1L)
                .boardTitle(boardTitle)
                .boardContent(boardContent)
                .build();
        boolean flag = boardMapper.modify(modify);

        //then
        assertTrue(flag);

    }

    @Test
    @Rollback
    @Transactional
    @DisplayName("방안에 게시물 1번을 삭제 해야한다.")
    void delete() {
        //given
        Long delete1 = 1L;
        //when
        boolean delete = boardMapper.delete(delete1);
        //then
        assertTrue(delete);


    }
}


