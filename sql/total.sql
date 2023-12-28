Create Database hobby;

use hobby;

CREATE TABLE tbl_board
(
    board_id      INTEGER AUTO_INCREMENT,
    person_id     VARCHAR(16),
    board_title   VARCHAR(20) NOT NULL,
    board_content VARCHAR(400),
    room_id       INTEGER,
    view_count INTEGER,
    reg_date TIME DEFAULT current_timestamp,
    CONSTRAINT pk_board PRIMARY KEY (board_id),
    CONSTRAINT fk_board_person
        FOREIGN KEY (person_id)
            REFERENCES tbl_person (person_id),
    CONSTRAINT fk_board_room
        FOREIGN KEY (room_id)
            REFERENCES tbl_room (room_id)
);

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

CREATE TABLE tbl_person
(
    person_id VARCHAR(16),
    email   VARCHAR(255) NOT NULL UNIQUE ,
    password VARCHAR(20) NOT NULL UNIQUE ,
    nickname VARCHAR(10) NOT NULL UNIQUE ,
    location VARCHAR(255),
    introduction VARCHAR(40),
    reg_date TIME DEFAULT current_timestamp,
    CONSTRAINT pk_person PRIMARY KEY (person_id)
);

CREATE TABLE tbl_reply
(
    reply_id  INTEGER AUTO_INCREMENT,
    person_id VARCHAR(255) NOT NULL,
    board_id   INTEGER NOT NULL,
    content   VARCHAR(200),
    reg_date  TIME DEFAULT current_timestamp,
    CONSTRAINT pk_reply PRIMARY KEY (reply_id),
    CONSTRAINT fk_reply_person
        FOREIGN KEY (person_id)
            REFERENCES tbl_person (person_id),
    CONSTRAINT fk_reply_board
        FOREIGN KEY (board_id)
            REFERENCES tbl_board (board_id)
);

CREATE TABLE tbl_roomMember
(
    room_members INTEGER AUTO_INCREMENT,
    room_id INTEGER,
    person_id VARCHAR(16),
    authority VARCHAR(10) DEFAULT 'COMMON',
    CONSTRAINT pk_roomMember PRIMARY KEY (room_members),
    CONSTRAINT fk_roomMember_person
        FOREIGN KEY (person_id)
            REFERENCES tbl_person (person_id),
    CONSTRAINT fk_roomMember_room
        FOREIGN KEY (room_id)
            REFERENCES tbl_room (room_id)
);