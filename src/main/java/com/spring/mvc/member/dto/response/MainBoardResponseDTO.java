package com.spring.mvc.member.dto.response;

import com.spring.mvc.member.entity.Board;
import com.spring.mvc.member.entity.MainBoard;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class MainBoardResponseDTO {
    private int boardId;
    private String personId;
    private String boardTitle;
    private String boardContent;
    private int roomId;
    private int viewCount;
    private String regDate;
    private int maxUser;
    private int currUser;

    public MainBoardResponseDTO(MainBoard board) {
        this.boardId = board.getMainBoardId();
        this.personId = board.getPersonId();
        this.boardTitle = board.getMainBoardTitle();
        this.boardContent= board.getMainBoardContent();
        this.roomId = board.getRoomId();
        this.viewCount = board.getViewCount();
        this.regDate = makePrettierDateString(board.getRegDate());
        this.maxUser = board.getMaxUser();
        this.currUser = board.getCurrUser();
    }

    static String makePrettierDateString(LocalDateTime regDateTime) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return pattern.format(regDateTime);
    }

}
