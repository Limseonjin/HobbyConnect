package com.spring.mvc.member.controller;

import com.spring.mvc.member.dto.request.BoardRequestDTO;
import com.spring.mvc.member.entity.Board;
import com.spring.mvc.member.repository.BoardMapper;
import com.spring.mvc.member.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/room/board")
public class BoardController {

    public final BoardService boardService;

    //방안에 게시글 만들기 화면요청
    @GetMapping("/write")
    public String makeBoard(@RequestParam long roomId, Model model){
        log.info("bord/write GET roomId : {}",roomId);
        model.addAttribute("roomId",roomId);
        return "board/write";
    }

    //방 만들기 화면 등록 요청
//    @PostMapping("/write")
//    public String makeRoom(Board board ,HttpSession session){
//        boardService.makeBoard(board, session);
//        return "redirect:/room/main";
//    }

    // 클릭한 게시물 상세보기
    @GetMapping("/detail")
    public String oneBoard(
            @RequestParam long boardId,
            Model model)
    {
        log.info("detail id={} : GET!",boardId);
        Board board = boardService.findOneByBoard(boardId);
        log.debug("board : {}",board);
        model.addAttribute("boardId",board.getBoardId());
        model.addAttribute("personId",board.getPersonId());
        model.addAttribute("boardTitle",board.getBoardTitle());
        model.addAttribute("boardContent",board.getBoardContent());
        model.addAttribute("roomId",board.getRoomId());
        model.addAttribute("viewCount",board.getViewCount());
        model.addAttribute("regDate",board.getRegDate());
        return "board/detail";
    }

    @DeleteMapping("/write")
    public String deleteBoard(Long board){
        boardService.delete(board);
        return "board/write";
    }

}
