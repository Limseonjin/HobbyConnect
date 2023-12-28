package com.spring.mvc.member.dto.response;

import com.spring.mvc.member.entity.Reply;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class MypageReplyResponseDTO {
    private int replyId;
    private String personId;
    private int boardId;
    private String content;
    private String date;

    public MypageReplyResponseDTO(Reply reply) {
        this.replyId = reply.getReplyId();
        this.personId = reply.getPersonId();
        this.boardId = reply.getBoardId();
        this.content = reply.getContent();
        this.date = makePrettierDateString(reply.getRegDate());
    }

    static String makePrettierDateString(LocalDateTime regDateTime) {
        DateTimeFormatter pattern = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return pattern.format(regDateTime);
    }
}
