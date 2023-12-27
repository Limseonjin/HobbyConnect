CREATE TABLE tbl_roomMember
(
    room_members INTEGER AUTO_INCREMENT,
    room_id INTEGER,
    person_id VARCHAR(16),
    authority VARCHAR(10),
    CONSTRAINT pk_roomMember PRIMARY KEY (room_members),
    CONSTRAINT fk_roomMember_person
        FOREIGN KEY (person_id)
            REFERENCES tbl_person (person_id),
    CONSTRAINT fk_roomMember_room
        FOREIGN KEY (room_id)
            REFERENCES tbl_room (room_id)
);