package com.spring.mvc.member.dto.response;


import com.spring.mvc.member.entity.MainBoard;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@ToString
public class MainBoardResponseDTO {

    private Long mainBoardId ;
    private String personId;
    private String mainBoardTitle;
    private String mainBoardContent;
    private Long roomId;
    private Integer viewCount; //조회수 상승 처리 기능
    private LocalDateTime regDate;

    public MainBoardResponseDTO(MainBoard mainBoard){
        this.mainBoardId = mainBoard.getMainBoardId();
        this.personId = mainBoard.getPersonId();
        this.mainBoardTitle = mainBoard.getMainBoardTitle();
        this.mainBoardContent = mainBoard.getMainBoardContent();
        this.roomId = mainBoard.getRoomId();
        this.viewCount = mainBoard.getViewCount();
        this.regDate = mainBoard.getRegDate();
    }
}

