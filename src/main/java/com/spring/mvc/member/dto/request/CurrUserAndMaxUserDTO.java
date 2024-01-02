package com.spring.mvc.member.dto.request;

import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrUserAndMaxUserDTO {

    Integer currUser;
    Integer maxUser;
    Long roomId;

    public Integer UpdateCurrUser(boolean flag){
        //방에 사용자가 들어오거나 나가면 UpdateCurrUser 가 증가 하고 줄어 들어야 함
        if (flag) {
            this.currUser++;
        } else {
            this.currUser--;
        }
        return this.currUser;
    }

}
