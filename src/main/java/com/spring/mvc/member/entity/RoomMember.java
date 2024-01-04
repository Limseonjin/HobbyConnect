package com.spring.mvc.member.entity;
/*
CREATE TABLE tbl_roomMember
        (
                room_members INTEGER AUTO_INCREMENT,
                room_id INTEGER,
                person_id VARCHAR(20),
authority VARCHAR(10) DEFAULT 'COMMON',
reg_date  DATETIME DEFAULT current_timestamp,
CONSTRAINT pk_roomMember PRIMARY KEY (room_members),
CONSTRAINT fk_roomMember_person
FOREIGN KEY (person_id)
REFERENCES tbl_person (person_id) ON DELETE CASCADE ,
CONSTRAINT fk_roomMember_room
FOREIGN KEY (room_id)
REFERENCES tbl_room (room_id) ON DELETE CASCADE
);
*/


import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoomMember {
    Integer roomMembers;
    Long roomId;
    String personId;
    String authority;
    LocalDateTime reg_date;
}
