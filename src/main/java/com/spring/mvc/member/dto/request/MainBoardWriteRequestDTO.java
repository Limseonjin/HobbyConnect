package com.spring.mvc.member.dto.request;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@NoArgsConstructor
public class MainBoardWriteRequestDTO {
    private String personId;
    private String boardTitle;
    private String boardContent;
    private String roomId;
}
