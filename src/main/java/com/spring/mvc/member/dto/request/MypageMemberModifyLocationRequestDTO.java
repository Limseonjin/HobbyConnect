package com.spring.mvc.member.dto.request;

import com.spring.mvc.member.entity.Member;
import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Builder
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class MypageMemberModifyLocationRequestDTO {
    @NotBlank
    private String personId; // 수정할 member id

    @NotBlank
    private String location; // 수정할 nickName

    public Member toEntitiy() {
        return Member.builder()
                .personId(personId)
                .location(location)
                .build();
    }

}
