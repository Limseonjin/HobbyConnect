package com.spring.mvc.member.controller;

import com.spring.mvc.member.dto.request.MypageMemberInfoModifyRequestDTO;
import com.spring.mvc.member.dto.request.MypageMemberPasswordModifyRequestDTO;
import com.spring.mvc.member.dto.response.MemberResponseDTO;
import com.spring.mvc.member.dto.response.MypageBoardResponseDTO;
import com.spring.mvc.member.dto.response.MypageReplyResponseDTO;
import com.spring.mvc.member.entity.Board;
import com.spring.mvc.member.entity.Reply;
import com.spring.mvc.member.entity.Room;
import com.spring.mvc.member.service.MypageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

import static com.spring.mvc.util.LoginUtil.LOGIN_KEY;

@Slf4j
@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MypageController {
    private final MypageService mypageService;

    @GetMapping("/room")
    public String roomList(HttpSession session, Model model) {
        List<Room> mainBoardList = mypageService.getMainBoardList(session);
        MemberResponseDTO member = mypageService.getMemberBySession(session);
        model.addAttribute("mbList", mainBoardList);
        model.addAttribute("p", member);
        return "/mypage/myroom";
    }
    // 1. 내가 쓴 게시글 전체 조회 요청
    @GetMapping("/board")
    public String boardList(HttpSession session, Model model) {
        List<MypageBoardResponseDTO> boardList = mypageService.getBoardList(session);
        List<Board> boards = boardList.stream()
                .map(this::convertToBoard)
                .collect(Collectors.toList());
        MemberResponseDTO member = mypageService.getMemberBySession(session);
        model.addAttribute("bList", boards);
        model.addAttribute("p", member);
        log.debug("bList:{}", boardList);
        return "/mypage/myboard";
    }

    // 2. 내가 쓴 댓글 전체 조회 요청
    @GetMapping("/reply")
    public String replyList(HttpSession session, Model model) {
        List<MypageReplyResponseDTO> replyList = mypageService.getReplyList(session);
        MemberResponseDTO member = mypageService.getMemberBySession(session);

        model.addAttribute("rList", replyList);
        model.addAttribute("p", member);
        return "/mypage/myreply";
    }

    // 3. 회원정보 수정 창 띄우기
    @GetMapping("/info")
    public String modifyInfo(HttpSession session, Model model) {
        MemberResponseDTO member = mypageService.getMemberBySession(session);
        model.addAttribute("p", member);
        return "/mypage/myinfo";
    }

    // 회원 정보 수정 요청 받기
    @PostMapping("/info")
    public String modifyInfo(HttpSession session, MypageMemberInfoModifyRequestDTO dto) {
        mypageService.modifyInfo(session, dto);
        return "redirect:/mypage/info";
    }

    // 비밀번호 수정 요청
    @PostMapping("/infopw")
    public String modifyPassWord(HttpSession session, MypageMemberPasswordModifyRequestDTO dto) {
        mypageService.modifyPassword(session, dto);
        return "redirect:/mypage/info";
    }

    //회원탈퇴 창 요청
    @GetMapping("/del")
    public String delMember() {
        return "/mypage/myinfodel";
    }

    @GetMapping("/deleteCon")
    public String delMember(HttpSession session) {
        mypageService.delete(session);
        return "redirect:/";
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
