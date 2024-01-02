package com.spring.mvc.member.controller;

import com.spring.mvc.member.dto.response.BoardResponseDTO;
import com.spring.mvc.member.dto.response.MainBoardResponseDTO;
import com.spring.mvc.member.dto.response.MypageBoardResponseDTO;
import com.spring.mvc.member.entity.MainBoard;
import com.spring.mvc.member.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/main")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/main-page")
    public String mainPage(HttpSession session, Model model) {
        List<MainBoardResponseDTO> list = boardService.getList();
        System.out.println("list = " + list);
        List<MainBoard> boards = list.stream()
                .map(this::convertToBoard)
                .collect(Collectors.toList());
        log.debug("boards: {}", boards);
        model.addAttribute("bList", boards);
        return "/mainpage";
    }

    private MainBoard convertToBoard(MainBoardResponseDTO mainBoard) {
        return MainBoard.builder()
                .mainBoardId(mainBoard.getBoardId())
                .personId(mainBoard.getPersonId())
                .mainBoardTitle(mainBoard.getBoardTitle())
                .mainBoardContent(mainBoard.getBoardContent())
                .roomId(mainBoard.getRoomId())
                .viewCount(mainBoard.getViewCount())
                .currUser(mainBoard.getCurrUser())
                .maxUser(mainBoard.getMaxUser())
                .build();
    }

}
