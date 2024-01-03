package com.spring.mvc.member.controller;


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

    // 게시글 조회 요청 처리
    @GetMapping("/findAll")
    public ResponseEntity<?> findAllMainBoards() {
        List<MainBoardResponseDTO> boards = mainBoardService.findAll();
        System.out.println("boards = " + boards);
        log.debug("boards : {}", boards);
        return ResponseEntity.ok().body(boards);
    }

    // personId로 회원이 만든 게시글 조회 요청 처리
    @GetMapping("/findByPersonId/{personId}")
    public ResponseEntity<?> findMainBoardsByPersonId(@PathVariable String personId) {
        List<MainBoardResponseDTO> boards = mainBoardService.findRoomByPersonId(personId);
        return ResponseEntity.ok().body(boards);
    }

    // keyword로 게시글 조회 요청 처리
    @GetMapping("/findByTitle/{keyword}")
    public ResponseEntity<?> findMainBoardsByTitle(@PathVariable String keyword) {
        List<MainBoardResponseDTO> boards = mainBoardService.findRoomByTitle(keyword);
        return ResponseEntity.ok().body(boards);
    }
}

