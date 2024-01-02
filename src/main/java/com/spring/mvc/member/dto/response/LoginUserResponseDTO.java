package com.spring.mvc.member.dto.response;

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

    private String personId;
    private String nickname;
    private String email;
    private String location;
    private String introduction;

}
