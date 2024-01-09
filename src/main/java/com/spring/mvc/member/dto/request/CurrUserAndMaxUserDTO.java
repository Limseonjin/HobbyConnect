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



}
