package com.spring.mvc.member.service;

import com.spring.mvc.member.dto.request.*;
import com.spring.mvc.member.dto.response.BoardResponseDTO;
import com.spring.mvc.member.dto.response.MainBoardResponseDTO;
import com.spring.mvc.member.dto.response.MypageBoardResponseDTO;
import com.spring.mvc.member.entity.Board;
import com.spring.mvc.member.entity.MainBoard;
import com.spring.mvc.member.repository.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

    public void register(MainBoardRequestDTO dto,HttpSession session) {
        // dto 를 엔터티로 변환
        boardMapper.save(dto.mainBoard(session));
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
