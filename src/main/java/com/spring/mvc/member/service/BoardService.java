package com.spring.mvc.member.service;

import com.spring.mvc.member.common.Search;
import com.spring.mvc.member.dto.request.BoardModifyRequestDTO;
import com.spring.mvc.member.dto.request.BoardWriteRequestDTO;
import com.spring.mvc.member.dto.request.MainBoardModifyRequestDTO;
import com.spring.mvc.member.dto.request.MainBoardWriteRequestDTO;
import com.spring.mvc.member.dto.response.BoardResponseDTO;
import com.spring.mvc.member.dto.response.MainBoardResponseDTO;
import com.spring.mvc.member.dto.response.MypageBoardResponseDTO;
import com.spring.mvc.member.entity.Board;
import com.spring.mvc.member.entity.MainBoard;
import com.spring.mvc.member.repository.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardMapper boardMapper;

    public List<MainBoardResponseDTO> getList() {
        return boardMapper.findAll()
                .stream()
                .map(MainBoardResponseDTO::new)
                .collect(Collectors.toList());
    }

    public void register(MainBoardWriteRequestDTO dto) {
        // dto 를 엔터티로 변환
        MainBoard board = new MainBoard(dto);
        boardMapper.save(board);
    }

    public List<MainBoardResponseDTO> modify(MainBoardModifyRequestDTO dto) {
        boardMapper.modify(dto.toEntity());
        return getList();
    }

    public List<MainBoardResponseDTO> delete(long boardId) {
        boardMapper.delete(boardId);
        return getList();
    }

}
