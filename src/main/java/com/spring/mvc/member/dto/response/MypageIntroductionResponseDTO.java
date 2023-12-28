package com.spring.mvc.member.dto.response;

import com.spring.mvc.member.entity.Member;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class MypageIntroductionResponseDTO {

    private final String introduction;

    public MypageIntroductionResponseDTO(Member member) {
        this.introduction = member.getIntroduction();
    }
}
