package com.spring.mvc.member.dto.request;

import com.spring.mvc.member.entity.RoomMember;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomMemberRequestDTO {

    private Integer roomMembers;
    private Long roomId;
    private String personId;
    private String authority;
    private LocalDateTime reg_date;

    public RoomMember toEntity(){
        return RoomMember.builder()
                .roomMembers(roomMembers)
                .roomId(roomId)
                .personId(personId)
                .authority(authority)
                .reg_date(reg_date)
                .build();
    }
}
