package com.spring.mvc.member.dto.request;

import com.spring.mvc.member.entity.Reply;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ReplyPostRequestDTO {

    private int boardId;
    private String content;

    public Reply toEntity() {
        return Reply.builder()
                .boardId(this.boardId)
                .content(this.content)
                .build();
    }
}
