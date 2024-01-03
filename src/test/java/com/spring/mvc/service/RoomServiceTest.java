package com.spring.mvc.service;

import com.spring.mvc.member.dto.request.RoomPassWordRequestDTO;
import com.spring.mvc.member.dto.request.RoomRequestDTO;
import com.spring.mvc.member.dto.request.CurrUserAndMaxUserDTO;
import com.spring.mvc.member.entity.Room;
import com.spring.mvc.member.service.RoomService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoomServiceTest {

    @Autowired
    RoomService roomService;
    @Test
    @DisplayName("방 만들기에 성공 해야 한다.")
    void makeRoom() {
        //given
        RoomRequestDTO dto = RoomRequestDTO.builder()
                .personId("hhhhgong3")
                .roomName("발로 5인큐 구함")
                .roomPw("3333")
                .maxUser(8)
                .currUser(1)
                .build();
        //when
//        roomService.makeRoom(dto,null);
        //then
    }

    @Test
    @DisplayName("회원 정보를 이용해 그 회원이 만든 방을 찾아야 한다.")
    void getRoomByPersonId() {
        //given
        String personId ="hhhhgong3";
        //when
        List<Room> roomByPersonId = roomService.getRoomByPersonId(personId);
        System.out.println("roomByPersonId = " + roomByPersonId);

    }

    @Test
    @DisplayName("방의 아이디를 이용해 방 하나를 찾아야 한다.")
    void getRoomByRoomId() {
        //given
        Long roomId = 3L;
        //when
        Room roomByRoomId = roomService.getRoomByRoomId(roomId);
        System.out.println("roomByRoomId = " + roomByRoomId);
    }

    @Test
    @DisplayName("방의 제목 KeyWord를 이용해 그 방의 제목에 관련된 방들이 전부 나타나야 한다.")
    void getRoomNameByKeyWord() {
        //given
        String roomName = "구함";
        //when
        List<Room> roomNameByKeyWord = roomService.getRoomNameByKeyWord(roomName);
        System.out.println("roomNameByKeyWord = " + roomNameByKeyWord);
    }

    @Test
    @DisplayName("roomId로 방을 삭제 시켜야 한다.")
    void deleteRoom() {
        // given
        RoomRequestDTO requestDTO = new RoomRequestDTO();
        requestDTO.setRoomId(2L);  // 혹은 필요한 roomId 값으로 설정

        // when
        boolean result = roomService.deleteRoom(requestDTO);

        // then
        assertTrue(result);  // 또는 원하는 조건에 따라 테스트 코드 작성
    }

    @Test
    @DisplayName("내가 방든 방에 사람이 들어오면 currUser의 수가 1증가 하고, 방에서 나가면 currUser의 수가 1 차감 되어야 한다.")
    void currUser() {
        //given
        CurrUserAndMaxUserDTO currUserAndMaxUserDTO = CurrUserAndMaxUserDTO.builder()
                .currUser(5)
                .maxUser(4)
                .roomId(3L)
                .build();

        //when
        boolean s = roomService.currUser(currUserAndMaxUserDTO);
        //then
        assertFalse(s);

    }
    @Test
    @DisplayName("그 방의 비밀번호와 내가 입력한 비밀번호가 일치 할시 방에 입장 하여야 한다.")
    void PassWordJoinRoom() {
        //given
        String roomPw = "3333";
        Long roomId = 3L;
        //when
        boolean b = roomService.PassWordJoinRoom(RoomPassWordRequestDTO.builder().roomId(roomId).roomPw(roomPw).build());
        //then
        assertTrue(b);
    }
}