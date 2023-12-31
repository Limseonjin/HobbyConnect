package com.spring.mvc.member.service;

import com.spring.mvc.member.dto.response.RoomMemberListResponseDTO;
import com.spring.mvc.member.entity.Auth;
import com.spring.mvc.member.repository.RoomMapper;
import com.spring.mvc.member.repository.RoomMemberMapper;
import com.spring.mvc.util.LoginUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoomMemberService {

    private final RoomMemberMapper roomMemberMapper;
    private final RoomMapper roomMapper;

    //    public void save(MainBoardRequestDTO dto, HttpSession session){
//        roomMemberMapper.save(dto.toEntityByRoomMember(session));
//    }
    public boolean isIn(Long roomId, HttpSession session) {
        int in = roomMemberMapper.isIn(roomId, LoginUtil.getCurrentLoginMemberAccount(session));
        return in != 0;
    }

    public void newMember(Long roomId, HttpSession session) {
        roomMemberMapper.joinCommonMember(roomId, LoginUtil.getCurrentLoginMemberAccount(session));
    }

    public List<RoomMemberListResponseDTO> findByRoomId(Long roomId) {
        return roomMemberMapper.findByRoomId(roomId);
    }

    public void findAll() {
        roomMemberMapper.findAll();
    }


    //방장이 특정 회원을 방에서 추방 시키는 메서드
    public List<RoomMemberListResponseDTO> delete(String personId, Long roomId) {
        roomMemberMapper.delete(personId,roomId);
        return roomMemberMapper.findByRoomId(roomId);


    }
    //방장이 방을 나가면 방을 삭제 하는 메서드
    public void deleteMyRoom(String personId, Long roomId) {
        String auth = roomMemberMapper.findByPersonId(personId, roomId);
        if(auth.equals("ADMIN")){
            roomMapper.deleteRoom(roomId);
        }

    }
}
