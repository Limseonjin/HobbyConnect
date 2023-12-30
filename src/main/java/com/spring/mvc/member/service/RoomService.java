package com.spring.mvc.member.service;

import com.spring.mvc.member.dto.request.RoomPassWordRequestDTO;
import com.spring.mvc.member.dto.request.RoomRequestDTO;
import com.spring.mvc.member.dto.request.CurrUserAndMaxUserDTO;
import com.spring.mvc.member.entity.Room;
import com.spring.mvc.member.repository.RoomMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class RoomService {

    private final RoomMapper roomMapper;

    //방 만들기 서비스
    public boolean makeRoom(RoomRequestDTO dto){

        return roomMapper.save(dto.room());
    }

    //PersonId로 회원이 만든 방들 조회
    public List<Room> getRoomByPersonId(String personId){

        return roomMapper.findByPersonId(personId);
    }

    //roomId로 찾고 싶은 방을 하나 조회
    public Room getRoomByRoomId(Long roomId){

        return roomMapper.findOne(roomId);
    }

    //keyword 로 내가 찾고 싶은 방들의 제목 조회
    public List<Room> getRoomNameByKeyWord(String keyword){
        return roomMapper.titleFindAll(keyword);
    }

    //roomId로 방을 삭제
    public boolean deleteRoom(RoomRequestDTO dto){

        return roomMapper.deleteRoom(dto.getRoomId());
    }

    //DB에 curr_user 가 증가 해야 됨
    public boolean currUser(CurrUserAndMaxUserDTO dto){
        Room room = roomMapper.findOne(dto.getRoomId());
        if(dto.getCurrUser() >= dto.getMaxUser()){
            return false;
        }
        Integer newCurrUser = dto.UpdateCurrUser(true);//Room 클래스의 UpdateCurrUser의 flag가 true면
        roomMapper.updateCurrUser(newCurrUser, dto.getRoomId()); //RoomMapper에 있는 updateCurrUser의 currUser를 증가시킨것을 저장한다.
        return true;
    }

    public boolean PassWordJoinRoom(RoomPassWordRequestDTO dto){

        //비밀 방에 들어 가면 방장이 설정한 패스 워드와 내가 작성한 패스 워드가 일치 한지 확인을 해야 함
        boolean findPassWord = dto.getRoomPw().equals(roomMapper.findOne(dto.getRoomId()).getRoomPw());
        if(findPassWord){//일치 한다면 방에 접속이 가능하고,
            return true;
        }else{//일치 하지 않는 다면 방에 접속이 불가능함
            return false;
        }
    }


}
