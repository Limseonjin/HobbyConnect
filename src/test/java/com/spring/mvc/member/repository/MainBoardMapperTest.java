package com.spring.mvc.member.repository;

import com.spring.mvc.member.entity.MainBoard;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class MainBoardMapperTest {

    @Autowired
    MainBoardMapper mainBoardMapper;

    //방만들기 매퍼 테스트
    @Test
    @DisplayName("게시글을 만들어야 한다.")
    void saveTest() {
        //given
        MainBoard mainBoard = MainBoard.builder()
                .personId("TaeYong")
                .mainBoardTitle("고민 상담 들어줄 사람 들어오셈 ")
                .mainBoardContent("집에 돈이 너무 많아서 고민임")
                .build();
        //when
        boolean flag = mainBoardMapper.save(mainBoard);
        //then
        assertTrue(flag);
    }

    //모든 게시글을 조회 테스트
    @Test
    @DisplayName("게시글을 전부 조회한다.")
    void findAllTest() {
        //given
        
        //when
        List<MainBoard> findAll =  mainBoardMapper.findAll();
        //then
        System.out.println("findAll = " + findAll);
    }
    
    //특정 사용자가 만든 게시글을 조회한다.
    @Test
    @DisplayName("특정 사용자가 만든 게시글을 조회 할 것이다.")
    void findPersonIdTest() {
        //given
        String personId = "seonjin";
        //when
        List<MainBoard> findPersonId = mainBoardMapper.findPersonId(personId,null);
        //then
        System.out.println("personId = " + findPersonId);
    }

    //seonjin이가 만든 방을 조회하면 제목에 '모두' 라는 말이 있어야 한다.
    @Test
    @DisplayName("seonjin이 만든 방을 조회하면 '모두'가 있어야 한다.")
    void findTitleIdTest () {
        //given
            String titleId = "모두";
        //when
        List<MainBoard> findRoom = mainBoardMapper.findTitle(titleId);
        //then
        assertEquals("모두 들어와~ 나랑 같이 게임 ㄱㄱ",findRoom.get(0).getMainBoardTitle());
    }
    
    //아이디가 TaeYong인 회원의 제목을 수정 하면 수정한 결과가 나와야 한다.
    @Test
    @DisplayName("TaeYong이 만든 방의 제목을 수정 하면 수정한 결과가 나와야 한다.")
    void modifyTitleTest() {
        //given
        String personId = "TaeYong";
        String newTitle = "고민상담 끝임 들어오지마!";
        //when
        MainBoard build = MainBoard.builder()
                .personId(personId)
                .mainBoardTitle(newTitle)
                .build();
        //then
        System.out.println("build = " + build);

        mainBoardMapper.modify(build);
    }

    //아이디가 TaeYong인 회원의 글내용을 수정하면 수정한 결과가 나와야 한다.
    @Test
    @DisplayName("TaeYong이 마든 게시글의 글 내용을 수정하면 수정한 결과가 나와야 한다.")
    void modifyContentTest() {
        //given
        String personId=  "TaeYong";
        String newContent = "이제 모두 나가~~";
        //when
        MainBoard build = MainBoard.builder()
                .personId(personId)
                .mainBoardContent(newContent)
                .build();
        //then
        System.out.println("build = " + build);

        mainBoardMapper.modifyContent(build);
    }

    //2번방을 삭제 시킨다
    @Test
    @Rollback
    @Transactional
    @DisplayName("2번 게시글을 삭제 시키기에 성공 해야 한다람쥐.")
    void deleteTest() {
        //given
        int mainBoardId =2;
        //when
        MainBoard mainBoard = new MainBoard();
        mainBoard.setMainBoardId((long) mainBoardId);
        mainBoardMapper.delete(mainBoard.getMainBoardId());
        //then
        mainBoardMapper.findMainBoardId(mainBoard.getRoomId());
    }


    

}