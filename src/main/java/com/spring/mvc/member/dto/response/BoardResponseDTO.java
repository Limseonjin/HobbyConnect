package com.spring.mvc.member.dto.response;

import com.spring.mvc.member.entity.Board;
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
public class BoardResponseDTO {

    private int boardId;
    private String personId;
    private String boardTitle;
    private String boardContent;
    private int roomId;
    private int viewCount;
    private String regDate;

    public BoardResponseDTO(Board board) {
        this.boardId = board.getBoardId();
        this.personId = board.getPersonId();
        this.boardTitle = board.getBoardTitle();
        this.boardContent= board.getBoardContent();
        this.roomId = board.getRoomId();
        this.viewCount = board.getViewCount();
        this.regDate = makePrettierDateString(board.getRegDate());
    }

    static String makePrettierDateString(LocalDateTime regDateTime) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return pattern.format(regDateTime);
    }

}