package com.spring.mvc.member.dto.response;

import com.spring.mvc.member.entity.RoomMember;
import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomMemberResponseDTO {

    private Integer roomMembers;
    private String personId;
    private String auth;

    public RoomMemberResponseDTO(RoomMember roomMember){
        this.roomMembers = roomMember.getRoomMembers();
        this.personId = roomMember.getPersonId();
        this.auth = roomMember.getAuth();
    }
}
