package com.spring.mvc.member.dto.response;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class RoomMemberListResponseDTO {
    private String personId;
    private String nickname;
}
