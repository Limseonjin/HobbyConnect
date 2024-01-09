package com.spring.mvc.member.dto.response;

import com.spring.mvc.member.entity.Board;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@RequiredArgsConstructor
public class BoardDetailResponseDTO {
    private Long boardId;
    private String personId;
    private String boardTitle;
    private String boardContent;
    private Long roomId;
    private Long viewCount;
    private LocalDateTime regDate;

    public BoardDetailResponseDTO(Board board) {
        this.boardId = board.getBoardId();
        this.personId = board.getPersonId();
        this.boardTitle = board.getBoardTitle();
        this.boardContent = board.getBoardContent();
        this.roomId = board.getRoomId();
        this.viewCount = board.getViewCount();

    }
}
