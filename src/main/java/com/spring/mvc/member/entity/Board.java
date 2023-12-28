package com.spring.mvc.member.entity;

import lombok.*;
import org.apache.tomcat.jni.Local;

import java.time.LocalDateTime;

//CREATE TABLE tbl_board
//        (
//        board_id      INTEGER AUTO_INCREMENT,
//        person_id     VARCHAR(16),
//        board_title   VARCHAR(20) NOT NULL,
//        board_content VARCHAR(400),
//        room_id       INTEGER,
//        view_count INTEGER,
//        reg_date TIME DEFAULT current_timestamp,
//        CONSTRAINT pk_board PRIMARY KEY (board_id),
//        CONSTRAINT fk_board_person
//        FOREIGN KEY (person_id)
//        REFERENCES tbl_person (person_id),
//        CONSTRAINT fk_board_room
//        FOREIGN KEY (room_id)
//        REFERENCES tbl_room (room_id)
//        );

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {
    private int boardId;
    private String personId;
    private String boardTitle;
    private String boardContent;
    private int roomId;
    private int viewCount;
    private LocalDateTime regDate;

}
