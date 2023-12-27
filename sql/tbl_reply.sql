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