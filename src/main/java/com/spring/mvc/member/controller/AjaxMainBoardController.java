package com.spring.mvc.member.controller;

import com.spring.mvc.member.common.Page;
import com.spring.mvc.member.dto.request.MainBoardModifyRequestDTO;
import com.spring.mvc.member.dto.response.MainBoardResponseDTO;
import com.spring.mvc.member.entity.MainBoard;
import com.spring.mvc.member.service.MainBoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1/mainBoards")
public class AjaxMainBoardController {
    private final MainBoardService mainBoardService;

    // main-board 목록 조회
    // /page/페이지 번호
    @GetMapping("/main/page/{pageNo}")
    public ResponseEntity<?> mainPage(
            @PathVariable int pageNo
    ) {
        Page page = new Page();
        page.setPageNo(pageNo);
        List<MainBoardResponseDTO> list = mainBoardService.pagefindAll(page);
        return ResponseEntity.ok().body(list);
    }
    
    // main-board 수정 요청 처리
    @PutMapping("/{bno}")
    public ResponseEntity<?> update(@RequestBody MainBoardModifyRequestDTO dto, BindingResult result, @PathVariable String bno) {
        if (result.hasErrors()) {
            return ResponseEntity
                    .badRequest()
                    .body(result.toString());
        }
        log.info("/api/v1/mainBoards PUT/PATCH");
        log.debug("Parameter: {}", dto);

        try {
            List<MainBoardResponseDTO> modify = mainBoardService.modify(dto);
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
            List<MainBoardResponseDTO> boardList = mainBoardService.delete(bno);
            return ResponseEntity
                    .ok()
                    .body(boardList);
        } catch (Exception e) {
            return ResponseEntity
                    .internalServerError()
                    .body(e.getMessage());
        }
    }

    private MainBoard convertToBoard(MainBoardResponseDTO mainBoard) {
        return MainBoard.builder()
                .mainBoardId(mainBoard.getMainBoardId())
                .personId(mainBoard.getPersonId())
                .mainBoardTitle(mainBoard.getMainBoardTitle())
                .mainBoardContent(mainBoard.getMainBoardContent())
                .roomId(mainBoard.getRoomId())
                .currUser(mainBoard.getCurrUser())
                .maxUser(mainBoard.getMaxUser())
                .build();
    }

}
