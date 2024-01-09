package com.spring.mvc.member.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.spring.mvc.member.entity.Reply;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ReplyDetailResponseDTO {
    private long replyId;
    private String personId;
    private int boardId;
    private String content;

    @JsonFormat(pattern = "yyyy년 MM월 dd일 HH:mm")
    private LocalDateTime regDate;

    public ReplyDetailResponseDTO(Reply reply) {
        this.replyId = reply.getReplyId();
        this.personId = reply.getPersonId();
        this.boardId = reply.getBoardId();
        this.content = reply.getContent();
        this.regDate = reply.getRegDate();

    }
}
