
Create Database hobby;

use hobby;

CREATE TABLE tbl_person
(
    person_id VARCHAR(50),
    email   VARCHAR(255) NOT NULL ,
    password VARCHAR(255) NOT NULL ,
    nickname VARCHAR(50) NOT NULL ,
    introduction VARCHAR(255),
    reg_date TIME DEFAULT current_timestamp,
    session_id VARCHAR(255),
    limit_time DATETIME DEFAULT current_timestamp,
    CONSTRAINT pk_person PRIMARY KEY (person_id)
);

CREATE TABLE tbl_room
(
    room_id INTEGER AUTO_INCREMENT,
    person_id VARCHAR(50),
    main_board_title VARCHAR(100) NOT NULL,
    main_board_content VARCHAR(255),
    room_name VARCHAR(100) NOT NULL,
    room_pw VARCHAR(100),
    max_user INTEGER(255),
    curr_user INTEGER(255) DEFAULT 1,
    reg_date DATETIME DEFAULT current_timestamp,
    CONSTRAINT pk_room PRIMARY KEY (room_id),
    CONSTRAINT fk_room_person
        FOREIGN KEY (person_id)
            REFERENCES tbl_person (person_id) ON DELETE CASCADE
);

CREATE TABLE tbl_board
(
    board_id INTEGER AUTO_INCREMENT,
    person_id     VARCHAR(50),
    board_title   VARCHAR(255) NOT NULL,
    board_content VARCHAR(800),
    room_id       INTEGER,
    view_count INTEGER DEFAULT 1,
    reg_date DATETIME DEFAULT current_timestamp,
    CONSTRAINT pk_board PRIMARY KEY (board_id),
    CONSTRAINT fk_board_person
        FOREIGN KEY (person_id)
            REFERENCES tbl_person (person_id) ON DELETE CASCADE,
    CONSTRAINT fk_board_room
        FOREIGN KEY (room_id)
            REFERENCES tbl_room (room_id) ON DELETE CASCADE

);

CREATE TABLE tbl_reply
(
    reply_id  INTEGER AUTO_INCREMENT,
    person_id VARCHAR(50) NOT NULL,
    board_id   INTEGER NOT NULL,
    content   VARCHAR(255),
    reg_date  DATETIME DEFAULT current_timestamp,
    CONSTRAINT pk_reply PRIMARY KEY (reply_id),
    CONSTRAINT fk_reply_person
        FOREIGN KEY (person_id)
            REFERENCES tbl_person (person_id) ON DELETE CASCADE,
    CONSTRAINT fk_reply_board
        FOREIGN KEY (board_id)
            REFERENCES tbl_board (board_id) ON DELETE CASCADE
);

CREATE TABLE tbl_roomMember
(
    room_members INTEGER AUTO_INCREMENT,
    room_id INTEGER,
    person_id VARCHAR(50),
    auth VARCHAR(100) DEFAULT 'COMMON',
    reg_date  DATETIME DEFAULT current_timestamp,
    CONSTRAINT pk_roomMember PRIMARY KEY (room_members),
    CONSTRAINT fk_roomMember_person
        FOREIGN KEY (person_id)
            REFERENCES tbl_person (person_id) ON DELETE CASCADE ,
    CONSTRAINT fk_roomMember_room
        FOREIGN KEY (room_id)
            REFERENCES tbl_room (room_id) ON DELETE CASCADE
);
