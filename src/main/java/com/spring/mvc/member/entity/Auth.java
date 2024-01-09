package com.spring.mvc.member.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter @ToString

public enum Auth {
    ADMIN("ADMIN",1),
    COMMON("COMMON",2);

    private String descrpiton; //권한 설명
    private int authNumber; //권한 번호
}

