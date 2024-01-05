package com.spring.mvc.member.dto.response;

import com.spring.mvc.member.common.PageMaker;
import com.spring.mvc.member.entity.Room;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Setter
@Getter
@Builder
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class RoomListPageResponseDTO {
    private PageMaker pageInfo; // 페이지 정보
    private List<RoomResponseDTO> mainBoards; // 띄워질 보드 리스트

}
