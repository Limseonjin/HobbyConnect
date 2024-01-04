package com.spring.mvc.member.controller;


import com.spring.mvc.member.common.Page;
import com.spring.mvc.member.dto.response.MainBoardResponseDTO;
import com.spring.mvc.member.entity.MainBoard;
import com.spring.mvc.member.service.MainBoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/mainboard")
public class SearchController {

    @Autowired
    private MainBoardService mainBoardService;

    // personId로 회원이 만든 게시글 조회 요청 처리
    @GetMapping("/findByPersonId/{personId}/page/{pageNo}")
    public ResponseEntity<?> findMainBoardsByPersonId(
            @PathVariable String personId,
            @PathVariable int pageNo
    ) {
        Page page = new Page();
        page.setPageNo(pageNo);
        List<MainBoardResponseDTO> boards = mainBoardService.findRoomByPersonId(personId,page);

        return ResponseEntity.ok().body(boards);
    }

    // keyword로 게시글 제목으로 조회 요청 처리
    @GetMapping("/findByTitle/{keyword}/page/{pageNo}")
    public ResponseEntity<?> findMainBoardsByTitle(
            @PathVariable String keyword,
            @PathVariable int pageNo
    ) {
        Page page = new Page();
        page.setPageNo(pageNo);
        List<MainBoardResponseDTO> boards = mainBoardService.findRoomByTitle(keyword, page);
        return ResponseEntity.ok().body(boards);
    }
}

