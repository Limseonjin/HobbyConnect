package com.spring.mvc.member.service;

import com.spring.mvc.member.dto.response.BoardDetailResponseDTO;
import com.spring.mvc.member.entity.Board;
import com.spring.mvc.member.repository.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardService {

    public final BoardMapper boardMapper;


    //방안에 게시글 만들기
    public void makeBoard(long roomId, Board board, HttpSession session) {
        board.BoardPersonId(session);
        board.setRoomId(roomId);
        boardMapper.save(board);
    }

    public BoardDetailResponseDTO getDetail(int boardId) {
        Board one = boardMapper.findOne(boardId);
        return new BoardDetailResponseDTO(one);
    }

    //방안에 게시글 전체 조회
    public List<Board> findAllByBoard() {
        return boardMapper.findAll();
    }

   //방안에 게시글 하나 조회
    public Board findOneByBoard(Long boardId) {
       return boardMapper.findOne(boardId);
    }

    //방안에 게시글 수정
    public void modify(Board boardId) {
        boardMapper.modify(boardId);
    }

    //방안에 게시글 삭제
    public void delete(Long boarId) {
        boardMapper.delete(boarId);
    }
}