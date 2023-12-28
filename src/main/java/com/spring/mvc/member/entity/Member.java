package com.spring.mvc.member.entity;

import lombok.*;

import java.time.LocalDateTime;


//CREATE TABLE tbl_person
//회원 테이블
//        (
//        person_id VARCHAR(16),
//        email   VARCHAR(255) NOT NULL UNIQUE ,
//        password VARCHAR(20) NOT NULL UNIQUE ,
//        nickname VARCHAR(10) NOT NULL UNIQUE ,
//        location VARCHAR(255),
//        introduction VARCHAR(40),
//        reg_date TIME DEFAULT current_timestamp,
//        CONSTRAINT pk_person PRIMARY KEY (person_id)
//        );
@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Member {

    private String personId;
    private String email;
    private String password;
    private String nickname;
    private String location;
    private String introduction;
    private LocalDateTime regDate;

    }

