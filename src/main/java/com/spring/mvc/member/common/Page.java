package com.spring.mvc.member.common;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Page {
    private int pageNo; // 클라이언트가 요청한 페이지 번호
    private int amount; // 클라이언트가 요청한 보여질 게시물 수

    public Page() {
        this.pageNo = 1;
        this.amount = 6;
    }
    public int getPageStart() {
        return (pageNo - 1) * amount;
    }
}
