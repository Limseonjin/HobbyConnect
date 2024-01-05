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
public class ReplyListResponseDTO {
    private int count; // 총 댓글의 수
    private PageMaker pageInfo; // 페이지 정보
    private List<ReplyDetailResponseDTO> replies; // 실제 댓글 리스트
}
