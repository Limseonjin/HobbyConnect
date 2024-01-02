package com.spring.mvc.member.entity;


import com.spring.mvc.member.dto.request.MainBoardWriteRequestDTO;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MainBoard {
    private int mainBoardId;
    private String personId;
    private String mainBoardTitle;
    private String mainBoardContent;
    private int roomId;
    private int viewCount;
    private LocalDateTime regDate;
    private int maxUser;
    private int currUser;

    public MainBoard(MainBoardWriteRequestDTO dto) {
        this.personId = dto.getPersonId();
        this.mainBoardTitle = dto.getBoardTitle();
        this.mainBoardContent = dto.getBoardContent();
    }
}
