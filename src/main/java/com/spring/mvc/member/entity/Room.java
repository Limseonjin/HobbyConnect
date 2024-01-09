package com.spring.mvc.member.entity;

import com.spring.mvc.util.LoginUtil;
import lombok.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;

/*

-------------- 방 만들기 테이블 -----------------
CREATE TABLE tbl_room
(
    room_id INTEGER AUTO_INCREMENT,
    person_id VARCHAR(16),
    room_name VARCHAR(20) NOT NULL,
    room_pw VARCHAR(8),
    max_user INTEGER(255),
    curr_user INTEGER(255),
    reg_date TIME DEFAULT current_timestamp,
    CONSTRAINT pk_room PRIMARY KEY (room_id),
    CONSTRAINT fk_room_person
        FOREIGN KEY (person_id)
            REFERENCES tbl_person (person_id)
);
 */
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Room {

    private Long roomId;
    private String personId;
    private String mainBoardTitle;
    private String mainBoardContent;
    private String roomName;
    private String roomPw;
    private Integer maxUser;
    private Integer currUser;
    private LocalDateTime regDate;

    public void RoomPersonId(HttpSession session){
        this.personId = LoginUtil.getCurrentLoginMemberAccount(session);
    }
    public Integer UpdateCurrUser(boolean flag){
        //방에 사용자가 들어오거나 나가면 UpdateCurrUser 가 증가 하고 줄어 들어야 함
        if (flag) {
            this.currUser++;
        } else {
            this.currUser--;
        }
        return this.currUser;
    }


}


