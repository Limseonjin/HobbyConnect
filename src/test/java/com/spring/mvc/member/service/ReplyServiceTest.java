package com.spring.mvc.member.service;

import com.spring.mvc.member.common.Page;
import com.spring.mvc.member.dto.request.ReplyModifyRequestDTO;
import com.spring.mvc.member.dto.response.ReplyListResponseDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReplyServiceTest {

    @Autowired
    ReplyService service;

    @Test
    @DisplayName("보드 넘버로 조회")
    void findAllTest() {
        //given
        ReplyListResponseDTO list = service.getList(1, new Page(1, 5));
        System.out.println("list = " + list);
        //when

        //then
    }
    
    @Test
    @DisplayName("수정된다")
    void replyModifyTest() {
        //given
        ReplyModifyRequestDTO dto = ReplyModifyRequestDTO.builder()
                .rId(3)
                .content("수정된 내용")
                .bId(1)
                .build();
        //when
        ReplyListResponseDTO modify = service.modify(dto);

        //then
        System.out.println("modify = " + modify);
    }

}