package com.spring.mvc.member.dto.request;

import com.spring.mvc.member.entity.Board;
import lombok.*;

@Setter
@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class BoardWriteRequestDTO {
    private String personId;
    private String boardTitle;
    private String boardContent;

}
