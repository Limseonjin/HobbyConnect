package com.spring.mvc.member.dto.request;


import com.spring.mvc.member.entity.Room;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class RoomRequestDTO {

    @NotBlank
    private Long roomId;
    @NotBlank
    private String personId;
    @NotBlank
    @Size(min = 2, max = 20)
    private String roomName;
    @Size(min=1, max = 8)
    private String roomPw;
    @Size(min=1, max =255)
    private Integer maxUser;
    private Integer currUser;
    private LocalDateTime regDate;

    //엔터티로 변환 시킨다
    public Room room(){
        return Room.builder()
                .personId(personId)
                .roomName(roomName)
                .roomPw(roomPw)
                .maxUser(maxUser)
                .currUser(currUser)
                .regDate(regDate)
                .build();
    }

}
