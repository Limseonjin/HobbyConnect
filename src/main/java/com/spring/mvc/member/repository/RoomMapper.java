package com.spring.mvc.member.repository;

import com.spring.mvc.member.entity.Room;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoomMapper {


    // 방을 만들기
    boolean save(Room room);

    //방을 전체 조회
    List<Room> findAll();

    //특정 사용자가 만든 방 하나 조회
    List<Room> findByPersonId(String personId);

    //내가 찾고 싶은 방 하나를 조회
    List<Room>findOne(Long roomId);

    //방을 삭제
    boolean deleteRoom(Long roomId);
}
