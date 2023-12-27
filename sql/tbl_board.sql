CREATE TABLE tbl_board
(
    board_id      INTEGER AUTO_INCREMENT,
    person_id     VARCHAR(16),
    board_title   VARCHAR(20),
    board_content VARCHAR(400),
    room_id       INTEGER,
    view_count INTEGER,
    reg_date TIME,
    CONSTRAINT pk_board PRIMARY KEY (board_id),
    CONSTRAINT fk_board_person
        FOREIGN KEY (person_id)
            REFERENCES tbl_person (person_id),
    CONSTRAINT fk_board_room
        FOREIGN KEY (room_id)
            REFERENCES tbl_room (room_id)
);