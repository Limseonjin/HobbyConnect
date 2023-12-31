package com.spring.mvc.member.service;

import com.spring.mvc.member.common.Page;
import com.spring.mvc.member.common.PageMaker;
import com.spring.mvc.member.dto.request.*;
import com.spring.mvc.member.dto.response.BoardListPageResponseDTO;
import com.spring.mvc.member.dto.response.RoomBoardResponseDTO;
import com.spring.mvc.member.dto.response.RoomListPageResponseDTO;
import com.spring.mvc.member.dto.response.RoomResponseDTO;
import com.spring.mvc.member.entity.Auth;
import com.spring.mvc.member.entity.Room;
import com.spring.mvc.member.entity.RoomMember;
import com.spring.mvc.member.repository.BoardMapper;
import com.spring.mvc.member.repository.RoomMapper;
import com.spring.mvc.member.repository.RoomMemberMapper;
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
    private final RoomMemberMapper roomMemberMapper;
    private final BoardMapper boardMapper;

    //방 만들기 서비스
    public void makeRoom(Room room, HttpSession session) {
        room.RoomPersonId(session);

        log.debug("room : {}", room);
        boolean save = roomMapper.save(room);
        Long roomId = room.getRoomId();
        RoomMember build = RoomMember.builder()
                .roomId(roomId)
                .personId(room.getPersonId())
                .auth(Auth.ADMIN.name())
                .build();
        roomMemberMapper.save(build);
    }

    // 방 비밀번호 검증
    public boolean passwordCheck(int roomId, int roomPw) {
        int dbPassword = roomMapper.password(roomId);
        return roomPw == dbPassword;
    }

    // 방 전체 조회
    public List<Room> getRoomList() {
        return roomMapper.findAll();
    }

    //roomId로 찾고 싶은 방을 하나 조회
    public Room getRoomByRoomId(Long roomId) {

        return roomMapper.findOne(roomId);
    }

    public BoardListPageResponseDTO getBoards(int roomId,Page page) {
        List<RoomBoardResponseDTO> board = roomMapper.findBoard(roomId, page);
        int count = boardMapper.count((long) roomId);
        return BoardListPageResponseDTO.builder()
                .boards(board)
                .pageInfo(new PageMaker(page,count))
                .build();
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
    public RoomListPageResponseDTO deleteRoom(Long bno, Page page) {
        roomMapper.deleteRoom(bno);
        List<RoomResponseDTO> rooms = roomMapper.pageFindAll(page).stream()
                .map(RoomResponseDTO::new)
                .collect(Collectors.toList());
        int count1 = roomMapper.count();
        return RoomListPageResponseDTO.builder()
                .mainBoards(rooms)
                .pageInfo(new PageMaker(page, count1))
                .build();
    }

    public RoomListPageResponseDTO modify(RoomModifyRequestDTO dto, Page page) {
        roomMapper.modify(dto.toEntity());
        List<RoomResponseDTO> rooms = roomMapper.pageFindAll(page).stream()
                .map(RoomResponseDTO::new)
                .collect(Collectors.toList());
        int count1 = roomMapper.count();
        return RoomListPageResponseDTO.builder()
                .mainBoards(rooms)
                .pageInfo(new PageMaker(page, count1))
                .build();
    }

    //DB에 curr_user 가 증가 해야 됨
    public boolean currUserPlus(Long roomId, Boolean flag){
        Room room = roomMapper.findOne(roomId);
        Integer newCurrUser = room.UpdateCurrUser(flag);
        roomMapper.updateCurrUser(newCurrUser,roomId);
        return true;
    }

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
