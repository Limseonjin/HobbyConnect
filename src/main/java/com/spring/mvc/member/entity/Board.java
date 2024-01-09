package com.spring.mvc.member.entity;

import com.spring.mvc.util.LoginUtil;
import lombok.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

//CREATE TABLE tbl_board
//        (
//                board_id INTEGER AUTO_INCREMENT,
//                reply_id INTEGER,
//                person_id     VARCHAR(20),
//board_title   VARCHAR(20) NOT NULL,
//board_content VARCHAR(400),
//room_id       INTEGER,
//view_count INTEGER,
//reg_date DATETIME DEFAULT current_timestamp,
//CONSTRAINT pk_board PRIMARY KEY (board_id),
//CONSTRAINT fk_board_person
//FOREIGN KEY (person_id)
//REFERENCES tbl_person (person_id) ON DELETE CASCADE,
//CONSTRAINT fk_board_room
//FOREIGN KEY (room_id)
//REFERENCES tbl_room (room_id) ON DELETE CASCADE


@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {
    private Long boardId;
    private String personId;
    private String boardTitle;
    private String boardContent;
    private Long roomId;
    private Long viewCount;
    private LocalDateTime regDate;

    public void BoardPersonId(HttpSession session) {
        this.personId = LoginUtil.getCurrentLoginMemberAccount(session);
    }
}
