package com.spring.mvc.member.repository;

import com.spring.mvc.member.entity.Reply;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReplyMapperTest {

    @Autowired
    ReplyMapper mapper;

    @Test
    @DisplayName("댓글이 입력 된다")
    void replyInsertTest() {
        //given
        Reply build = Reply.builder()
                .replyId(1)
                .personId("swq3064")
                .boardId(1)
                .content("test")
                .build();

        //when
        boolean save = mapper.save(build);
        //then
        assertTrue(save);
    }

    @Test
    @DisplayName("댓글이 삭제 된다")
    void replyDeleteTest() {
        //given
        int id = 2;
        //when
        boolean delete = mapper.delete(2);
        //then
        assertTrue(delete);
    }
}