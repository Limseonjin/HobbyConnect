package com.spring.mvc.member.repository;

import com.spring.mvc.member.entity.Room;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RoomMapper {
    // 방을 만들기
    boolean save(Room room);

    //방을 전체 조회
    boolean findAll(Room room);

    //내가 찾고 싶은 방 하나를 조회
    boolean findOne(String PersonId);

    //방을 삭제
    boolean deleteRoom(String roomId);
}
