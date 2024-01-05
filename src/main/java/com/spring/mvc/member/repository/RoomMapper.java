package com.spring.mvc.member.repository;

import com.spring.mvc.member.common.Page;
import com.spring.mvc.member.entity.Room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoomMapper {


    // 방을 만들기
    boolean save(Room room);

    //방을 전체 조회
    List<Room> findAll();

    //내가 찾고 싶은 방 하나를 조회
    Room findOne(Long roomId);

    List<Room> pageFindAll(@Param("p") Page page);
    //특정 사용자가 만든 방 하나 조회
    List<Room> findByPersonId(@Param("personId") String personId,@Param("p") Page page);

    //내가 찾고 싶은 방을 제목으로 검색
    List<Room> findRoomByTitle(@Param("keyword") String keyword,@Param("p") Page page);

    //특정 회원이 내 방에 들어오면 currUser이 증가함
    boolean updateCurrUser (@Param("currUser") int currUser,@Param("roomId") Long roomId);

    //방을 삭제
    boolean deleteRoom(Long roomId);


    // 게시글 제목 수정
    boolean modify(Room mainBoard);

    //게시글 카운트
    int count();
}
