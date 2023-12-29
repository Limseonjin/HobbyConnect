package com.spring.mvc.member.dto;


import lombok.*;
@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginRequestDTO {

    private String personId;
    private String password;
    private boolean autoLogion; //자동 로그인 체크 여부
}
