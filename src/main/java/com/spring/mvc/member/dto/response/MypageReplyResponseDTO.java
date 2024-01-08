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
    private String boardTitle;
    private String content;
    private String nickname;
}
