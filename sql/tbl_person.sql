CREATE TABLE tbl_person
(
    person_id VARCHAR(16),
    email   VARCHAR(255) UNIQUE ,
    password VARCHAR(20) UNIQUE ,
    nickname VARCHAR(10) UNIQUE ,
    location VARCHAR(255),
    introduction VARCHAR(40),
    reg_date TIME,
    CONSTRAINT pk_person PRIMARY KEY (person_id)
);