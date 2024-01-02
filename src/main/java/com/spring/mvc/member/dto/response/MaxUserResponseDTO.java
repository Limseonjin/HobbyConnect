package com.spring.mvc.member.dto.response;

import com.spring.mvc.member.entity.MainBoard;
import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@RequiredArgsConstructor
public class MaxUserResponseDTO {

    private Integer maxUser;
    private Integer currUser;
    private String mainBoardTitle;
    private String mainBoardContent;
    private String personId;


    public MaxUserResponseDTO(MainBoard mainBoard) {
        this.maxUser = mainBoard.getMaxUser();
        this.currUser = mainBoard.getCurrUser();
        this.mainBoardTitle = mainBoard.getMainBoardTitle();
        this.mainBoardContent = mainBoard.getMainBoardContent();
        this.personId = mainBoard.getPersonId();
    }
}
