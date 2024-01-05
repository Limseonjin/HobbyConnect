package com.spring.mvc.member.dto.response;

import com.spring.mvc.member.entity.Room;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class RoomResponseDTO {
    private Long roomId;
    private String personId;
    private String mainBoardTitle;
    private String mainBoardContent;

    private String roomName;
    private String roomPw;
    private String regDate;
    private int maxUser;
    private int currUser;

    public RoomResponseDTO(Room room) {
        this.personId = room.getPersonId();
        this.mainBoardTitle = room.getMainBoardTitle();
        this.mainBoardContent = room.getMainBoardContent();
        this.roomId = room.getRoomId();
        this.roomName = room.getRoomName();
        this.roomPw = room.getRoomPw();
        this.regDate = makePrettierDateString(room.getRegDate());
        this.maxUser = room.getMaxUser();
        this.currUser = room.getCurrUser();
    }
    static String makePrettierDateString(LocalDateTime regDateTime) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return pattern.format(regDateTime);
    }

}
