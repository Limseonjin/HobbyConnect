package com.spring.mvc.member.repository;

import com.spring.mvc.member.entity.RoomMember;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest

class RoomMemberMapperTest {

    @Autowired
    RoomMemberMapper roomMemberMapper;

    @Test
    @DisplayName("방에 회원이 접속 해야 한다.")
    void saveTest(){
        //given
        RoomMember build = RoomMember.builder()
                .roomId(1L)
                .personId("hhhhgong4")
//                .authority("ADMIN")
                .build();
        //when
//        boolean save = roomMemberMapper.save(build, session);

//        //then
//        assertTrue(save);
    }
    
    @Test
    @DisplayName("방에 있는 회원을 전부 조회 해야 한다.")
    void findAllTest(){
        
        //given
        List<RoomMember> all = roomMemberMapper.findAll();
        
        //when
        assertEquals(4,all.size());

        }


    @Test
    @DisplayName("ADMIN이 COMMON 1명을 삭제 해야 한다.")
    void deleteTest(){
        //given
        String hhhhgong2 = "hhhhgong2";
        //when
        RoomMember roomMember = new RoomMember();
        roomMember.setPersonId(hhhhgong2);
        roomMemberMapper.delete(roomMember.getPersonId());
    }
}