package com.spring.mvc.member.service;

import com.spring.mvc.member.common.Search;
import com.spring.mvc.member.dto.request.BoardModifyRequestDTO;
import com.spring.mvc.member.dto.request.BoardWriteRequestDTO;
import com.spring.mvc.member.dto.response.BoardResponseDTO;
import com.spring.mvc.member.dto.response.MypageBoardResponseDTO;
import com.spring.mvc.member.entity.Board;
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

    public List<BoardResponseDTO> getList() {
        return boardMapper.findAll()
                .stream()
                .map(BoardResponseDTO::new)
                .collect(Collectors.toList());
    }

    public void register(BoardWriteRequestDTO dto) {
        // dto 를 엔터티로 변환
        Board board = new Board(dto);
        boardMapper.save(board);
    }

    public void modify(BoardModifyRequestDTO dto) {
        boardMapper.modify(dto.toEntity());
    }

    public void delete(int boardId) {
        boardMapper.delete(boardId);
    }

}
