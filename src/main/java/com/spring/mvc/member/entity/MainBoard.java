package com.spring.mvc.member.entity;

import com.spring.mvc.member.dto.request.MainBoardWriteRequestDTO;
import lombok.*;

import java.time.LocalDateTime;

/*

CREATE TABLE tbl_main_board
(
    main_board_id      INTEGER AUTO_INCREMENT,
    person_id     VARCHAR(16),
    main_board_title   VARCHAR(20) NOT NULL,
    main_board_content VARCHAR(400),
    room_id       INTEGER,
    view_count INTEGER,
    reg_date TIME DEFAULT current_timestamp,
    CONSTRAINT pk_main_board PRIMARY KEY (main_board_id),
    CONSTRAINT fk_main_board_person
        FOREIGN KEY (person_id)
            REFERENCES tbl_person (person_id),
    CONSTRAINT fk_main_board_room
        FOREIGN KEY (room_id)
            REFERENCES tbl_room (room_id)
);


 */
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MainBoard {
    private Long mainBoardId;
    private String personId;
    private String mainBoardTitle;
    private String boardTitle;
    private String mainBoardContent;
    private String boardContent;
    private Long roomId;
    private LocalDateTime regDate;
    private int maxUser;
    private int currUser;

    public MainBoard(MainBoardWriteRequestDTO dto) {
        this.personId = dto.getPersonId();
        this.boardTitle = dto.getBoardTitle();
        this.boardContent = dto.getBoardContent();
    }
}
