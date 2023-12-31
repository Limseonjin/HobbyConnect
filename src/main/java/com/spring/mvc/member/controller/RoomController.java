package com.spring.mvc.member.controller;


import com.spring.mvc.member.common.Page;
import com.spring.mvc.member.dto.response.BoardListPageResponseDTO;
import com.spring.mvc.member.dto.response.RoomBoardResponseDTO;
import com.spring.mvc.member.dto.response.RoomListPageResponseDTO;
import com.spring.mvc.member.dto.response.RoomMemberListResponseDTO;
import com.spring.mvc.member.entity.Board;
import com.spring.mvc.member.entity.Room;
import com.spring.mvc.member.service.BoardService;
import com.spring.mvc.member.service.RoomMemberService;
import com.spring.mvc.member.service.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/room")
public class RoomController {

    private final RoomService roomService;
    private final RoomMemberService roomMemberService;
    private final BoardService boardService;

    // 방 암호 검중 처리
    @GetMapping("/check/{roomId}")
    public ResponseEntity<?> mainPage(@PathVariable int roomId, int roomPw) {
        boolean flag = roomService.passwordCheck(roomId, roomPw);
        return ResponseEntity.ok().body(flag);
    }

    // 방 참여하기 처리
    @GetMapping("/main")
    public String intoTheRoom(Long roomId, Model model, HttpSession session) {
        boolean in = roomMemberService.isIn(roomId, session);
        if (!in) {
            roomMemberService.newMember(roomId, session);
            roomService.currUserPlus(roomId,true);
        }
        Room roomByRoomId = roomService.getRoomByRoomId(roomId);
        List<RoomMemberListResponseDTO> byRoomId = roomMemberService.findByRoomId(roomId);
        log.debug("roomMember : {} ",byRoomId);
        model.addAttribute("r", roomByRoomId);
        model.addAttribute("rmList", byRoomId);
        return "room/mainroom";
    }

    @PostMapping("/main")
    public String handlePostRequest(long roomId, Board board, HttpSession session) {
        log.debug("main POST board : {}", board);
        boardService.makeBoard(roomId, board, session);
        return "redirect:/room/main?roomId=" + roomId; // 게시글을 등록한 후 메인 페이지로 리디렉션
    }


    // 게시글 조회 비동기 처리
    @GetMapping("/{roomId}/{pageNo}")
    public ResponseEntity<?> findMainBoardsByPersonId(@PathVariable int roomId,
                                                      @PathVariable int pageNo) {
        Page page = new Page();
        page.setPageNo(pageNo);
        page.setAmount(4);

        BoardListPageResponseDTO boards = roomService.getBoards(roomId, page);
        return ResponseEntity.ok().body(boards);
    }

    // 방 만들기 화면 요청
    @GetMapping("/room")
    public String Room() {
        return "board/writepost";
    }

    //방 만들기 등록 요청
    @PostMapping("/room")
    public String Room(Room room,
                       HttpSession session) {

        roomService.makeRoom(room, session);
        return "redirect:/main/main-page";
    }


    @ResponseBody
    @DeleteMapping("/{personId}/{roomId}")
    public ResponseEntity<?> ExitMember(@PathVariable String personId,@PathVariable Long roomId) {
        roomMemberService.deleteMyRoom(personId, roomId);
        List<RoomMemberListResponseDTO> delete = roomMemberService.delete(personId, roomId);
        roomService.currUserPlus(roomId,false);
        return ResponseEntity.ok().body(delete);
    }
}
