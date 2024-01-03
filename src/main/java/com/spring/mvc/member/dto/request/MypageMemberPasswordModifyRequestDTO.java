package com.spring.mvc.member.dto.request;

import com.spring.mvc.member.entity.Member;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class MypageMemberPasswordModifyRequestDTO {
    @NotBlank
    private String personId; // 수정할 member id

    @NotBlank
    private String password; // 수정할 passWord

    public Member toEntitiy(String person, PasswordEncoder encoder) {
        return Member.builder()
                .personId(person)
                .password(encoder.encode(password))
                .build();
    }

}
