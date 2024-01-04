package com.spring.mvc.member.service;

import com.spring.mvc.member.dto.request.MainBoardRequestDTO;
import com.spring.mvc.member.dto.request.RoomMemberRequestDTO;
import com.spring.mvc.member.entity.RoomMember;
import com.spring.mvc.member.repository.MemberMapper;
import com.spring.mvc.member.repository.RoomMapper;
import com.spring.mvc.member.repository.RoomMemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoomMemberService {

    private final RoomMemberMapper roomMemberMapper;

//    public void save(MainBoardRequestDTO dto, HttpSession session){
//        roomMemberMapper.save(dto.toEntityByRoomMember(session));
//    }

    public void findAll(){
        roomMemberMapper.findAll();
    }

    public void delete(String personId){
        roomMemberMapper.delete(personId);
    }


}
