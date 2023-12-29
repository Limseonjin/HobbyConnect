package com.spring.mvc.member.dto.request;


import com.spring.mvc.member.entity.Member;
import com.spring.mvc.member.entity.location;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class SignUpRequestDTO {

    @NotBlank
    @Size(min=4, max=16)
    private String personId;
    @NotBlank
    private String password;
    @NotBlank
    @Size(min=2, max=8)
    private String nickname;
    @NotBlank
    @Email
    private String email;

    private String location;

    private String introduction;

    // 엔터티로 변환하는 유틸메서드
    public Member toEntity(PasswordEncoder encoder){
        return Member.builder()
                .personId(personId)
                .password(encoder.encode(password))
                .email(email)
                .nickname(nickname)
                .location(location)
                .introduction(introduction)
                .build();
    }


}
