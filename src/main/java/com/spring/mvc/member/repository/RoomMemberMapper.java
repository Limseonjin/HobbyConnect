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

import com.spring.mvc.member.dto.response.RoomMemberListResponseDTO;
import com.spring.mvc.member.entity.RoomMember;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper

public interface RoomMemberMapper {

    int isIn(Long roomId, String personId);
    boolean joinCommonMember(Long roomId, String personId);

    //방에 사람이 들어오면 RoomMember 에 들어온 사람이 저장 되야함 .
    boolean save(RoomMember roomMember);

    //방 회원 전체 조회
    List<RoomMember> findAll();

    // 같은 방에 있는 회원 전체 조회
    List<RoomMemberListResponseDTO> findByRoomId(Long roomId);

    //회원 삭제
    boolean delete(@Param("personId")String personId, @Param("roomId")Long roomId);
}
