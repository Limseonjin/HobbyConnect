package com.spring.mvc.member.controller;

import com.spring.mvc.member.dto.response.MypageBoardResponseDTO;
import com.spring.mvc.member.entity.Board;
import com.spring.mvc.member.service.MypageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MypageController {
    private final MypageService mypageService;

    // 1. 내가 쓴 게시글 전체 조회 요청
    @GetMapping("/board")
    public String list(HttpSession session, Model model) {
        List<MypageBoardResponseDTO> boardList = mypageService.getBoardList(session);
        List<Board> boards = boardList.stream()
                        .map(this::convertToBoard)
                        .collect(Collectors.toList());
        System.out.println("boards = " + boards);
        model.addAttribute("bList", boards);
        log.debug("bList:{}",boardList);
        return "/myPage/myboard";
    }
    private Board convertToBoard(MypageBoardResponseDTO mypageBoard) {
        return Board.builder()
                .boardId(mypageBoard.getBoardId())
                .personId(mypageBoard.getPersonId())
                .boardTitle(mypageBoard.getBoardTitle())
                .boardContent(mypageBoard.getBoardContent())
                .roomId(mypageBoard.getRoomId())
                .viewCount(mypageBoard.getViewCount())
                .build();
    }
}
