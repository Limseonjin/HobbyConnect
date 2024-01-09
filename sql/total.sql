-- 테이블 생성 후  person1, person2, person3를 사이트에서 회원가입을 먼저 하세요
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


INSERT INTO tbl_room (person_id, main_board_title, main_board_content, room_name, room_pw, max_user,curr_user)
VALUES ('person1', '코딩하실분??', '아무거나 환영', '코딩모임', null, 10,2);
INSERT INTO tbl_room (person_id, main_board_title, main_board_content, room_name, room_pw, max_user)
VALUES ('person2', '피아노치실분?', '양손잡이만. 비번 힌트: 음악의 아버지', '월광의 소나타', '바흐', 20);
INSERT INTO tbl_room (person_id, main_board_title, main_board_content, room_name, room_pw, max_user,curr_user)
VALUES ('person3', '등산 모임', '등산할 사람 구합니다. 30대 이상만.', '등오름', null, 30,2);

INSERT INTO tbl_roomMember (room_id, person_id, auth)
VALUES (1, 'person1', 'ADMIN');
INSERT INTO tbl_roomMember (room_id, person_id, auth)
VALUES (1, 'person2', 'COMMON');
INSERT INTO tbl_roomMember (room_id, person_id, auth)
VALUES (2, 'person2', 'ADMIN');
INSERT INTO tbl_roomMember (room_id, person_id, auth)
VALUES (3, 'person3', 'ADMIN');
INSERT INTO tbl_roomMember (room_id, person_id, auth)
VALUES (3, 'person1', 'COMMON');

INSERT INTO tbl_board (person_id, board_title, board_content, room_id)
VALUES ('person1', '저 이거 잘 안돼요,, 도와주세요 ', '.', 1);
INSERT INTO tbl_board (person_id, board_title, board_content, room_id)
VALUES ('person2', '님들은 밖에 잘 나가시나요? ', '저만 집에서 맨날 컴퓨터 하는거 아니죠??', 1);

INSERT INTO tbl_reply (person_id, board_id, content)
VALUES ('person2', 1, '아니 내용을 써야 도와주든 하지 ㅡㅡ');
INSERT INTO tbl_reply (person_id, board_id, content)
VALUES ('person1', 2, '전 나가서 산책하는거 좋아해요');

INSERT INTO tbl_board (person_id, board_title, board_content, room_id)
VALUES ('person2', '피아노 모임에 온 것을 환영합니다', '별명/거주지/나이 댓글에 써주세요', 2);