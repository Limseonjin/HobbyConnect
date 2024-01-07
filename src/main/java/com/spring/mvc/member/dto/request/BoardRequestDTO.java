package com.spring.mvc.member.dto.request;//CONSTRAINT fk_board_person
//FOREIGN KEY (person_id)
//REFERENCES tbl_person (person_id) ON DELETE CASCADE,
//CONSTRAINT fk_board_room
//FOREIGN KEY (room_id)
//REFERENCES tbl_room (room_id) ON DELETE CASCADE

import com.spring.mvc.member.entity.Board;
import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardRequestDTO {

    Long boardId;
    Long replyId;
    String personId;
    String boardTitle;
    String boardContent;
    Long roomId;
    Long viewCount;

    public Board toEntity(){
        return Board.builder()
                .boardId(boardId)
                .replyId(replyId)
                .personId(personId)
                .boardTitle(boardTitle)
                .boardContent(boardContent)
                .roomId(roomId)
                .viewCount(viewCount)
                .build();
    }

}