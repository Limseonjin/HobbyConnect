package com.spring.mvc.member.dto.request;


import com.spring.mvc.member.entity.MainBoard;
import com.spring.mvc.member.entity.Room;
import com.spring.mvc.member.entity.RoomMember;
import com.spring.mvc.util.LoginUtil;
import lombok.*;

import javax.servlet.http.HttpSession;
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
    private String roomPw;
    @NotBlank
    @Size(min = 2, max = 20)
    private String mainBoardTitle;
    @NotBlank
    @Size(min = 1, max = 400)
    private String mainBoardContent;
    @NotBlank
    private Long roomId;
    private LocalDateTime regDate;
    private int maxUser;
    private String roomName;

   public MainBoard mainBoard(HttpSession session){
       return MainBoard.builder()
               .mainBoardId(mainBoardId)
               .personId(LoginUtil.getCurrentLoginMemberAccount(session))
               .mainBoardTitle(mainBoardTitle)
               .mainBoardContent(mainBoardContent)
               .roomId(roomId)
               .regDate(regDate)
               .build();
   }

   public Room toEntity(HttpSession session){
       return Room.builder()
               .roomId(roomId)
               .roomPw(roomPw)
               .personId(LoginUtil.getCurrentLoginMemberAccount(session))
               .maxUser(maxUser)
               .regDate(regDate)
               .roomName(roomName)
               .build();
   }

   public RoomMember toEntityByRoomMember(HttpSession session,Long mainBoardId){
       return RoomMember.builder()
               .personId(LoginUtil.getCurrentLoginMemberAccount(session))
               .roomId(mainBoardId)
               .authority("ADMIN")
               .build();
   }


}
