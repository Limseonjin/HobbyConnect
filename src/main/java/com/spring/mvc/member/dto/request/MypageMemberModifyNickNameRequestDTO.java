package com.spring.mvc.member.dto.request;

import com.spring.mvc.member.entity.Member;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class MypageMemberModifyNickNameRequestDTO {
    @NotBlank
    private String personId; // 수정할 member id

    @NotBlank
    private String nickname; // 수정할 nickName

    public Member toEntitiy() {
        return Member.builder()
                .personId(personId)
                .nickname(nickname)
                .build();
    }

}
