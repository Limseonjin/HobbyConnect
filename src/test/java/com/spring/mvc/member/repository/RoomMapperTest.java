package com.spring.mvc.member.repository;

import com.spring.mvc.member.entity.Room;
import com.spring.mvc.member.repository.RoomMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoomMapperTest {

    @Autowired
    RoomMapper roomMapper;

    @Test
    @DisplayName("방 만들기에 성공해야 한다!")
    void makeRoomTest() {
        // given
        Room room = Room.builder()
                .personId("seonjin")
                .roomName("배그 스쿼드 구함")
                .roomPw("")
                .maxUser(4)
                .currUser(1)
                .build();

        // when
        boolean flag = roomMapper.save(room);

        // then
        assertTrue(flag);
    }
    @Test
    @DisplayName("kitty가 만든 방을 조회 했을 때, 방 정보가 나와야 한다.")
    void findPersonIdTest() {
        //given
        String personId = "kitty";
        //when
        List<Room> person = roomMapper.findByPersonId(personId);
        System.out.println("person = " + person);
        //then
    }
    @Test
    @DisplayName("room의 Id로 검색 했을 때, 그것과 관련한 방 정보가 나와야 한다.")
    void findRoomIdTest() {
        //given
        int roomId= 4;
        //when
        List<Room> one = roomMapper.findOne((long) roomId);
        System.out.println("one = " + one);
        //then

    }
    
    @Test
    @DisplayName("4번방을 단일 조회 하면 제목에 '모두' 라는 말이 있어야 한다,")
    void findOneTest () {
        //given
        int roomid= 4;
        //when
        List<Room> findRoom = roomMapper.findOne((long) roomid);
        //then
        Room room = findRoom.get(0);
        assertTrue(room.getRoomName().contains("모두"));
    }


    @Test
    @Transactional
    @Rollback
    @DisplayName("roomId가 4번인 방이 삭제 되어야 한다.")
    void deleteTest() {
        //given
        int roomId = 4;

        //when
        Room room = new Room();
        room.setRoomId((long) roomId);
        roomMapper.deleteRoom(room.getRoomId());

        //then
        // 방이 삭제되었으므로, 해당 roomId로 방을 조회해보고 방이 존재하지 않아야 합니다.
        List<Room> findRoom = roomMapper.findOne(room.getRoomId());
        assertTrue(findRoom.isEmpty(), "방이 삭제되지 않았습니다.");
    }
}

    
    

