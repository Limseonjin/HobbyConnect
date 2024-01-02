package com.spring.mvc.member.dto.request;


import com.spring.mvc.member.entity.MainBoard;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;


//게시글 만들기 테이블
//        CREATE TABLE tbl_main_board
//        (
//        main_board_id      INTEGER AUTO_INCREMENT,
//        person_id     VARCHAR(16),
//        main_board_title   VARCHAR(20) NOT NULL,
//        main_board_content VARCHAR(400),
//        room_id       INTEGER,
//        view_count INTEGER,
//        reg_date TIME DEFAULT current_timestamp,
//        CONSTRAINT pk_main_board PRIMARY KEY (main_board_id),
//        CONSTRAINT fk_main_board_person
//        FOREIGN KEY (person_id)
//        REFERENCES tbl_person (person_id),
//        CONSTRAINT fk_main_board_room
//        FOREIGN KEY (room_id)
//        REFERENCES tbl_room (room_id)
//        );

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class MainBoardRequestDTO {

    @NotBlank
    private Long mainBoardId ;
    @NotBlank
    private String personId;
    @NotBlank
    @Size(min = 2, max = 20)
    private String mainBoardTitle;
    @NotBlank
    @Size(min = 1, max =400)
    private String mainBoardContent;
    @NotBlank
    private Long roomId;
    @NotBlank
    private Integer viewCount; //조회수 상승 처리 기능
    private LocalDateTime regDate;

   public MainBoard mainBoard(){
       return MainBoard.builder()
               .mainBoardId(mainBoardId)
               .personId(personId)
               .mainBoardTitle(mainBoardTitle)
               .mainBoardContent(mainBoardContent)
               .roomId(roomId)
               .viewCount(viewCount)
               .regDate(regDate)
               .build();
   }
}
