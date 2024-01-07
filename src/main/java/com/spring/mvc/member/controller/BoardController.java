package com.spring.mvc.member.controller;

import com.spring.mvc.member.dto.request.BoardRequestDTO;
import com.spring.mvc.member.dto.response.BoardDetailResponseDTO;
import com.spring.mvc.member.entity.Board;
import com.spring.mvc.member.repository.BoardMapper;
import com.spring.mvc.member.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/room/board")
public class BoardController {

    public final BoardService boardService;

    // 방안에 게시글 만들기 화면요청
    @GetMapping("/write")
    public String makeRoom() {
        return "board/write";
    }

    // 방 만들기 화면 등록 요청
    @PostMapping("/write")
    public String makeRoom(long roomId, Board board, HttpSession session) {
        boardService.makeBoard(roomId, board, session);
        return "redirect:/room/main?roomId=" + roomId;
    }

    // 게시글 상세 조회 요청
    @GetMapping("/detail")
    public String boardDetail(int boardId, Model model) {
        BoardDetailResponseDTO detail = boardService.getDetail(boardId);
        model.addAttribute("b", detail);
        return "board/detail";
    }

    // 게시글 수정 요청
    @GetMapping("/modify")
    public String boardModify(int boardId, Model model) {
        
        return "board/update";
    }
}