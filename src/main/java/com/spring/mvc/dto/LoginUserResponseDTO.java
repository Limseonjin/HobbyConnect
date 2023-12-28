package com.spring.mvc.dto;

import lombok.*;

import javax.validation.constraints.Email;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@ToString

public class LoginUserResponseDTO {

    private String persinId;
    private String nickname;
    private String email;
    private String location;
    private String introduction;

}
