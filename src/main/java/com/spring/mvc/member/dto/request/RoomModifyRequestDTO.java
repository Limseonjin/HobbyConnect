package com.spring.mvc.member.dto.request;

import com.spring.mvc.member.entity.Room;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class RoomModifyRequestDTO {
    @NotNull
    private Long roomId;
    private String mainBoardTitle;
    private String mainBoardContent;

    public Room toEntity() {
        return Room.builder()
                .roomId(roomId)
                .mainBoardTitle(mainBoardTitle)
                .mainBoardContent(mainBoardContent)
                .build();
    }
}
