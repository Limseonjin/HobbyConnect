package com.spring.mvc.member.dto.response;

import com.spring.mvc.member.common.PageMaker;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class MainBoardListResponseDTO {
    private PageMaker pageInfo; // 페이지 정보
    private List<MainBoardResponseDTO> mainBoards; // 띄워질 보드 리스트

}
