package com.spring.mvc.member.repository;

/*
public class RoomMember {
    Integer roomMembers;
    Long roomId;
    String personId;
    String authority;
    LocalDateTime reg_date;
}
 */

import com.spring.mvc.member.entity.MainBoard;
import com.spring.mvc.member.entity.RoomMember;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper

public interface RoomMemberMapper {

    //방에 사람이 들어오면 RoomMember 에 들어온 사람이 저장 되야함 .
    boolean save(RoomMember roomMember);

    //방 회원 전체 조회
    List<MainBoard> findAll();

    //회원 삭제
    boolean delete(String PersonId);
}
