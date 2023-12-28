package com.spring.mvc.member.repository;

import com.spring.mvc.member.entity.Board;
import com.spring.mvc.member.entity.Member;
import com.spring.mvc.member.entity.Reply;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MypageMapperTest {

    @Autowired
    MypageMapper mypageMapper;
    
    @Test
    @DisplayName("회원 아이디 testid1을 주면 그 사람의 게시글 2개를 가져와야 한다.")
    void getBoardListTest() {
        //given
        String personId = "testid1";
        //when
        List<Board> allMyBoard = mypageMapper.findAllMyBoard(personId);
        System.out.println("allMyBoard = " + allMyBoard);
        //then
        assertEquals(2, allMyBoard.size());
    }

    @Test
    @DisplayName("회원 아이디 testid1을 주면 그 사람의 댓글 2개를 가져와야 한다.")
    void getReplyListTest() {
        //given
        String personId = "testid1";
        //when
        List<Reply> allMyReply = mypageMapper.findAllMyReply(personId);
        System.out.println("allMyReply = " + allMyReply);
        //then
        assertEquals(2, allMyReply.size());
    }

    @Test
    @DisplayName("회원 아이디 testid1을 주면 그 사람의 한줄 소개를 조회 해와야한다.")
    void getIntroductionTest() {
        //given
        String personId = "testid1";
        //when
        Member introduction = mypageMapper.findIntroduction(personId);
        System.out.println("introduction = " + introduction);
        //then
    }
    
    @Test
    @DisplayName("아이디가 testid1인 회원의 닉네임을 수정하면 변경된 닉네임이 조회된다.")
    void modifyNickName() {
        //given
        String personId = "testid1";
        String newNickName = "수정된 한줄 소개";
        Member build = Member.builder()
                .nickname(newNickName)
                .personId(personId)
                .build();
        //when
        boolean b = mypageMapper.modifyNickName(build);
        //then
        assertTrue(b);
    }

    @Test
    @DisplayName("아이디가 testid1인 회원의 지역을 수정하면 변경된 지역이 조회된다.")
    void modifyLocation() {
        //given
        String personId = "testid1";
        String newLoc = "강원도";
        Member build = Member.builder()
                .location(newLoc)
                .personId(personId)
                .build();
        //when
        boolean b = mypageMapper.modifyLocation(build);
        //then
    }
}