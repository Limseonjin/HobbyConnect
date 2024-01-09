package com.spring.mvc.member.dto.response;

import com.spring.mvc.member.entity.Member;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class MemberResponseDTO {
    private String personId;
    private String email;
    private String password;
    private String nickname;
    private String introduction;
    private LocalDateTime regDate;

//    public MemberResponseDTO(Member member) {
//        this.personId = member.getPersonId();
//        this.email = member.getEmail();
//        this.password = member.getPassword();
//        this.nickname = member.getNickname();
//        this.introduction = member.getIntroduction();
//        this.regDate = member.getRegDate();
//    }
}
