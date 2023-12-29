package com.spring.mvc.member.dto.response;

import com.spring.mvc.member.entity.Room;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
public class RoomResponseDTO {

    private Long roomId;
    private String personId;
    private String roomName;
    private Integer maxUser;
    private Integer currUser;

    public RoomResponseDTO(Room room){
        this.roomId = room.getRoomId();
        this.personId = room.getPersonId();
        this.roomName = room.getRoomName();
        this.maxUser = room.getMaxUser();
        this.currUser = room.getCurrUser();
    }
}
