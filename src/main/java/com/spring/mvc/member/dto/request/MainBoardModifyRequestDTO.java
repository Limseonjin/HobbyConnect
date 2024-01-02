package com.spring.mvc.member.dto.request;

import com.spring.mvc.member.entity.Board;
import com.spring.mvc.member.entity.MainBoard;
import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@ToString
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class MainBoardModifyRequestDTO {
    @NotNull
    private int boardId;
    private String boardTitle;
    private String boardContent;

    public MainBoard toEntity() {
        return MainBoard.builder()
                .mainBoardId(boardId)
                .mainBoardTitle(boardTitle)
                .mainBoardContent(boardContent)
                .build();
    }
}
