package com.spring.mvc.member.dto.response;

import com.spring.mvc.member.entity.Board;
import com.spring.mvc.member.entity.MainBoard;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@RequiredArgsConstructor
public class MypageMainBoardResponseDTO {
    private Long mainBoardId;
    private String personId;
    private String mainBoardTitle;
    private String mainBoardContent;
    private Long roomId;
    private String regDate;
    private int maxUser;
    private int currUser;

    public MypageMainBoardResponseDTO(MainBoard board) {
        this.mainBoardId = board.getMainBoardId();
        this.personId = board.getPersonId();
        this.mainBoardTitle = board.getMainBoardTitle();
        this.mainBoardContent = board.getMainBoardContent();
        this.roomId = board.getRoomId();
        this.regDate = makePrettierDateString(board.getRegDate());
        this.maxUser = board.getMaxUser();
        this.currUser = board.getCurrUser();

    }

    static String makePrettierDateString(LocalDateTime regDateTime) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return pattern.format(regDateTime);
    }
}

