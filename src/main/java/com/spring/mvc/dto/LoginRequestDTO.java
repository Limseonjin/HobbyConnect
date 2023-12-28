package com.spring.mvc.dto;


import lombok.*;

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
