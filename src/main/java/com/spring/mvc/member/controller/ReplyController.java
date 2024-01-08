package com.spring.mvc.member.controller;

import com.spring.mvc.member.common.Page;
import com.spring.mvc.member.dto.request.ReplyModifyRequestDTO;
import com.spring.mvc.member.dto.request.ReplyPostRequestDTO;
import com.spring.mvc.member.dto.response.ReplyListResponseDTO;
import com.spring.mvc.member.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/room/board/detail")
public class ReplyController {

    public final ReplyService replyService;

    //댓글 작성
    @PostMapping("/insert")
    public ResponseEntity<?> writeReply(
            @RequestBody ReplyPostRequestDTO dto, HttpSession session){
        ReplyListResponseDTO register = replyService.register(dto, session);
        return ResponseEntity.ok().body(register);
    }
    //댓글 전체 조회
    @GetMapping("/{boardId}")
    public ResponseEntity<?> getReplyList(
            @PathVariable long boardId,
            @RequestParam(name ="pageNo", defaultValue = "1") int pageNo)
    {
        Page page = new Page();
        page.setPageNo(pageNo);
        ReplyListResponseDTO list = replyService.getList(boardId, page);
        return ResponseEntity.ok().body(list);
    }

    //댓글 수정
    @PutMapping("/{boardId}/update")
    public ResponseEntity<?> modifyByReply(
            @PathVariable long boardId,
            @RequestBody ReplyModifyRequestDTO dto){
        ReplyListResponseDTO modify = replyService.modify(dto);
        return ResponseEntity.ok().body(modify);
    }

    //댓글 삭제
    @DeleteMapping("/{replyNo}/delete")
    public ResponseEntity<?> deleteByReply(
            @PathVariable long replyNo
    ){
        ReplyListResponseDTO delete = replyService.delete(replyNo);
        return ResponseEntity.ok().body(delete);
    }
}
