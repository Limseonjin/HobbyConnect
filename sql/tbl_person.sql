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