package com.spring.mvc.member.service;

import com.spring.mvc.member.dto.response.RoomMemberListResponseDTO;
import com.spring.mvc.member.repository.MemberMapper;
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

    //    public void save(MainBoardRequestDTO dto, HttpSession session){
//        roomMemberMapper.save(dto.toEntityByRoomMember(session));
//    }
    public boolean isIn(int roomId, HttpSession session) {
        int in = roomMemberMapper.isIn(roomId, LoginUtil.getCurrentLoginMemberAccount(session));
        return in != 0;
    }

    public void newMember(int roomId, HttpSession session) {
        roomMemberMapper.joinCommonMember(roomId, LoginUtil.getCurrentLoginMemberAccount(session));
    }

    public List<RoomMemberListResponseDTO> findByRoomId(int roomId) {
        return roomMemberMapper.findByRoomId(roomId);
    }

    public void findAll() {
        roomMemberMapper.findAll();
    }

    public void delete(String personId) {
        roomMemberMapper.delete(personId);
    }


}
