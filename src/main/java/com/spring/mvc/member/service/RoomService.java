package com.spring.mvc.member.service;

import com.spring.mvc.member.repository.RoomMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoomService {

    private final RoomMapper roomMapper;

    //내가 만든 방에 사람이 접속 하면 DB에 curr_user 가 증가 해야 됨

    //비밀 방에 들어 가면 방장이 설정한 패스 워드와 내가 작성한 패스 워드가 일치 한지 확인을 해야 함
    //일치 한다면 방에 접속이 가능하고,
    //일치 하지 않는 다면 방에 접속이 불가능함


}
