package com.spring.mvc.member.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter @ToString

public enum Auth {
    COMMON("방장",1),
    ADMIN("일반인",2);

    private String descrpiton; //권한 설명
    private int authNumber; //권한 번호
}

