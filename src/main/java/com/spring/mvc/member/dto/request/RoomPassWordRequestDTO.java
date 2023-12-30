package com.spring.mvc.member.dto.request;

import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomPassWordRequestDTO {
    private String roomPw;
    private Long roomId;


}
