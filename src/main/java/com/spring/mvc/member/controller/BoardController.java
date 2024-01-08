package com.spring.mvc.member.controller;

import com.spring.mvc.member.dto.request.BoardModifyRequestDTO;
import com.spring.mvc.member.dto.request.BoardRequestDTO;
import com.spring.mvc.member.dto.response.BoardDetailResponseDTO;
import com.spring.mvc.member.dto.response.RoomListPageResponseDTO;
import com.spring.mvc.member.entity.Board;
import com.spring.mvc.member.entity.Room;
import com.spring.mvc.member.repository.BoardMapper;
import com.spring.mvc.member.service.BoardService;
import com.spring.mvc.member.service.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/room/board")
public class BoardController {

    public final BoardService boardService;
    public final RoomService roomService;

    // 방안에 게시글 만들기 화면요청
    @GetMapping("/write")
    public String makeBoard(@RequestParam long roomId, Model model) {
        log.info("bord/write GET roomId : {}", roomId);
        Room room = roomService.getRoomByRoomId(roomId);
        model.addAttribute("roomName", room.getRoomName());
        model.addAttribute("roomId", roomId);

        return "board/write";
    }


    // 게시글 상세 조회 요청
    @GetMapping("/detail")
    public String boardDetail(Long roomId, int boardId, Model model) {
        BoardDetailResponseDTO detail = boardService.getDetail(boardId);
        Room room = roomService.getRoomByRoomId(roomId);
        model.addAttribute("r", room);
        model.addAttribute("b", detail);
        return "board/detail";
    }


    // 게시글 수정 요청
    @GetMapping("/modify")
    public String boardModify(@RequestParam long roomId, @RequestParam long boardId, Model model) {
        Board oneByBoard = boardService.findOneByBoard(boardId);
        model.addAttribute("b", oneByBoard);
        model.addAttribute("roomId", roomId);
        model.addAttribute("boardId", boardId);
        return "board/update";
    }

    @PostMapping("/modify")
    public String boardModify(@RequestParam int boardId,
                              @RequestParam String boardTitle,
                              @RequestParam String boardContent,
                              @RequestParam long roomId) {
        BoardModifyRequestDTO dto = BoardModifyRequestDTO.builder()
                .boardId(boardId)
                .boardTitle(boardTitle)
                .boardContent(boardContent)
                .build();
        boardService.modify(dto);
        return "redirect:/room/board/detail?roomId=" + roomId + "&boardId=" + boardId;
    }


    // 클릭한 게시물 상세보기
//     @GetMapping("/detail")
//     public String oneBoard(
//             @RequestParam long boardId,
//             Model model)
//     {
//         log.info("detail id={} : GET!",boardId);
//         Board board = boardService.findOneByBoard(boardId);

//         log.debug("board : {}",board);
//         model.addAttribute("boardId",board.getBoardId());
//         model.addAttribute("personId",board.getPersonId());
//         model.addAttribute("boardTitle",board.getBoardTitle());
//         model.addAttribute("boardContent",board.getBoardContent());
//         model.addAttribute("roomId",board.getRoomId());
//         model.addAttribute("viewCount",board.getViewCount());
//         model.addAttribute("regDate",board.getRegDate());

//         Room room = roomService.getRoomByRoomId(board.getRoomId());
//         model.addAttribute("roomName",room.getRoomName());
//         return "board/detail";
//     }

    @ResponseBody
    @DeleteMapping("/detail/{rno}/{bno}")
    public ResponseEntity<?> deleteBoard(@PathVariable Long rno, @PathVariable Long bno) {
        boardService.delete(bno);
        log.info("디테일 삭제 !! :{},{}", bno, rno);

        return ResponseEntity.ok().body(rno);
    }

}
