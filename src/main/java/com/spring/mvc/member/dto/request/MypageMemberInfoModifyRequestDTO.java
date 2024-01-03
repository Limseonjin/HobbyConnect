package com.spring.mvc.member.dto.request;

import com.spring.mvc.member.entity.Member;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class MypageMemberInfoModifyRequestDTO {
    @NotBlank
    private String personId; // 수정할 member id

    @NotBlank
    private String nickname; // 수정할 nickName
    @NotBlank
    private String email; // 수정할 email
    @NotBlank
    private String introduction; // 수정할 introduction

//    public Member toEntitiy() {
//        return Member.builder()
//                .personId(personId)
//                .nickname(nickname)
//                .email(email)
//                .introduction(introduction)
//                .build();
//    }
    public Member toEntitiy(String person) {
        System.out.println("person = " + person);
        return Member.builder()
                .personId(person)
                .nickname(nickname)
                .email(email)
                .introduction(introduction)
                .build();
    }

}
