package com.spring.mvc.member.service;

import com.spring.mvc.member.common.Page;
import com.spring.mvc.member.common.PageMaker;
import com.spring.mvc.member.dto.request.*;
import com.spring.mvc.member.dto.response.RoomListPageResponseDTO;
import com.spring.mvc.member.dto.response.RoomResponseDTO;
import com.spring.mvc.member.entity.Room;
import com.spring.mvc.member.repository.RoomMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoomService {

    private final RoomMapper roomMapper;

    //방 만들기 서비스
    public void makeRoom(Room room, HttpSession session) {
        room.RoomPersonId(session);
        log.debug("room : {}", room);
        roomMapper.save(room);
    }

    // 방 전체 조회
    public List<Room> getRoomList() {
        return roomMapper.findAll();
    }

    //roomId로 찾고 싶은 방을 하나 조회
    public Room getRoomByRoomId(Long roomId) {

        return roomMapper.findOne(roomId);
    }

    public RoomListPageResponseDTO pagefindAll(Page page) {
        List<RoomResponseDTO> rooms = roomMapper.pageFindAll(page).stream()
                .map(RoomResponseDTO::new)
                .collect(Collectors.toList());
        int count1 = roomMapper.count();
        return RoomListPageResponseDTO.builder()
                .mainBoards(rooms)
                .pageInfo(new PageMaker(page, count1))
                .build();
    }

    //PersonId로 회원이 만든 방들 조회
    public RoomListPageResponseDTO findRoomByPersonId(String personId, Page page) {
        List<RoomResponseDTO> collect = roomMapper.findByPersonId(personId, page).stream()
                .map(RoomResponseDTO::new)
                .collect(Collectors.toList());
        int i = roomMapper.searchCountPersonId(personId);
        return RoomListPageResponseDTO.builder()
                .mainBoards(collect)
                .pageInfo(new PageMaker(page, i))
                .build();
    }

    //keyword 로 내가 찾고 싶은 방들의 제목 조회
    public RoomListPageResponseDTO findRoomByTitle(String keyword, Page page) {
        List<RoomResponseDTO> collect = roomMapper.findRoomByTitle(keyword, page).stream()
                .map(RoomResponseDTO::new)
                .collect(Collectors.toList());
        int i = roomMapper.searchCountTitle(keyword);
        return RoomListPageResponseDTO.builder()
                .mainBoards(collect)
                .pageInfo(new PageMaker(page, i))
                .build();
    }

    public RoomListPageResponseDTO findRoomByContent(String keyword, Page page) {
        List<RoomResponseDTO> collect = roomMapper.findRoomByContent(keyword, page).stream()
                .map(RoomResponseDTO::new)
                .collect(Collectors.toList());
        int i = roomMapper.searchCountContent(keyword);
        return RoomListPageResponseDTO.builder()
                .mainBoards(collect)
                .pageInfo(new PageMaker(page, i))
                .build();
    }

    //roomId로 방을 삭제
    public List<Room> deleteRoom(Long bno) {
        roomMapper.deleteRoom(bno);
        return roomMapper.findAll();
    }

    public List<Room> modify(RoomModifyRequestDTO dto) {
        roomMapper.modify(dto.toEntity());
        return roomMapper.findAll();
    }

//    //DB에 curr_user 가 증가 해야 됨
//    public boolean currUser(CurrUserAndMaxUserDTO dto){
//        Room room = roomMapper.findOne(dto.getRoomId());
//        if(dto.getCurrUser() >= dto.getMaxUser()){
//            return false;
//        }
//        Integer newCurrUser = dto.UpdateCurrUser(true);//Room 클래스의 UpdateCurrUser의 flag가 true면
//        roomMapper.updateCurrUser(newCurrUser, dto.getRoomId()); //RoomMapper에 있는 updateCurrUser의 currUser를 증가시킨것을 저장한다.
//        return true;
//    }

    public boolean PassWordJoinRoom(Long roomId, String Pw) {
        Room rooom = roomMapper.findOne(roomId);
        //비밀 방에 들어 가면 방장이 설정한 패스 워드와 내가 작성한 패스 워드가 일치 한지 확인을 해야 함
        boolean findPassWord = rooom.getRoomPw().equals(Pw);
        if (findPassWord) {//일치 한다면 방에 접속이 가능하고,
            return true;
        } else {//일치 하지 않는 다면 방에 접속이 불가능함
            return false;
        }
    }


}
