package com.spring.mvc.member.controller;

import com.spring.mvc.member.common.Page;
import com.spring.mvc.member.dto.request.RoomModifyRequestDTO;
import com.spring.mvc.member.dto.response.RoomListPageResponseDTO;
import com.spring.mvc.member.dto.response.RoomResponseDTO;
import com.spring.mvc.member.entity.Room;
import com.spring.mvc.member.service.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/mainBoards")
public class AjaxMainPageController {

    private final RoomService roomService;

    //페이징 으로 전체 조회
    @GetMapping("/main/page/{pageNo}")
    public ResponseEntity<?> mainPage(
            @PathVariable int pageNo
    ) {
        Page page = new Page();
        page.setPageNo(pageNo);
        page.setAmount(6);
        RoomListPageResponseDTO list = roomService.pagefindAll(page);
        return ResponseEntity.ok().body(list);
    }
    // personId로 회원이 만든 게시글 조회 요청 처리
    @GetMapping("/findByPersonId/{personId}/page/{pageNo}")
    public ResponseEntity<?> findMainBoardsByPersonId(
            @PathVariable String personId,
            @PathVariable int pageNo
    ) {
        Page page = new Page();
        page.setPageNo(pageNo);
        page.setAmount(6);
        RoomListPageResponseDTO roomByPersonId = roomService.findRoomByPersonId(personId, page);
        return ResponseEntity.ok().body(roomByPersonId);
    }

    // keyword로 게시글 제목으로 조회 요청 처리
    @GetMapping("/findByTitle/{keyword}/page/{pageNo}")
    public ResponseEntity<?> findRoomByTitle(
            @PathVariable String keyword,
            @PathVariable int pageNo
    ) {
        Page page = new Page();
        page.setPageNo(pageNo);
        page.setAmount(6);
        RoomListPageResponseDTO roomByTitle = roomService.findRoomByTitle(keyword, page);
        return ResponseEntity.ok().body(roomByTitle);
    }

    // keyword로 게시글 내용으로 조회 요청 처리
    @GetMapping("/content/{keyword}/page/{pageNo}")
    public ResponseEntity<?> findRoomByContent(
            @PathVariable String keyword,
            @PathVariable int pageNo
    ) {
        Page page = new Page();
        page.setPageNo(pageNo);
        page.setAmount(6);
        RoomListPageResponseDTO roomByContent = roomService.findRoomByContent(keyword, page);
        return ResponseEntity.ok().body(roomByContent);
    }

    // main-board 수정 요청 처리
    @PutMapping("/modfiy")
    public ResponseEntity<?> update(@RequestBody RoomModifyRequestDTO dto, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity
                    .badRequest()
                    .body(result.toString());
        }
        log.info("/api/v1/mainBoards PUT/PATCH");
        log.debug("Parameter: {}", dto);

        try {
            Page page = new Page();
            page.setPageNo(1);
            page.setAmount(6);
            RoomListPageResponseDTO modify = roomService.modify(dto, page);
            log.debug("dto: {}",dto);
            return ResponseEntity.ok().body(modify);

        } catch (Exception e) {
            log.warn("Internal Server Error. Caused by: {}", e.getMessage());
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    // main-board 삭제 요청
    @DeleteMapping("/{bno}")
    public ResponseEntity<?> remove(@PathVariable Long bno) {
        if (bno == null) {
            return ResponseEntity
                    .badRequest()
                    .body("게시글 번호를 보내주세요.");
        }
        log.info("/api/v1/mainBoards/{} : DELETE", bno);
        try {
            Page page = new Page();
            page.setPageNo(1);
            page.setAmount(6);
            RoomListPageResponseDTO roomListPageResponseDTO = roomService.deleteRoom(bno, page);
            return ResponseEntity
                    .ok()
                    .body(roomListPageResponseDTO);
        } catch (Exception e) {
            return ResponseEntity
                    .internalServerError()
                    .body(e.getMessage());
        }
    }

}
