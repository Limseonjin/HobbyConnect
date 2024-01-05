package com.spring.mvc.member.dto.request;

import com.spring.mvc.member.entity.Reply;
import lombok.*;

@Getter
@Builder
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class ReplyModifyRequestDTO {

    // 수정할 댓글 번호
    private int rId;
    // 수정할 댓글 내용
    private String content;
    // 수정 이후 목록을 받기 위한 board_id
    private int bId;

    public Reply toEntity() {
        return Reply.builder()
                .replyId(rId)
                .content(content)
                .boardId(bId)
                .build();
    }
}
