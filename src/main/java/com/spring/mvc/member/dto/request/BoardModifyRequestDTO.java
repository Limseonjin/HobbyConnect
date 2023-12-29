package com.spring.mvc.member.dto.request;

import com.spring.mvc.member.entity.Board;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Builder
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class BoardModifyRequestDTO {

    @NotNull
    private int boardId;
    private String boardTitle;
    private String boardContent;

    public Board toEntity() {
        return Board.builder()
                .boardId(boardId)
                .boardTitle(boardTitle)
                .boardContent(boardContent)
                .build();
    }
}
