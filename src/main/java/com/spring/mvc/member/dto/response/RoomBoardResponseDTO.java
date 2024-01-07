package com.spring.mvc.member.dto.response;

import lombok.*;

@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class RoomBoardResponseDTO {
    private int boardId;
    private int viewCount;
    private String boardTitle;
    private String boardContent;
    private String nickName;
    private int replyCount;
}
