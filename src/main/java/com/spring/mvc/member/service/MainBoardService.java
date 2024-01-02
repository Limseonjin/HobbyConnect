package com.spring.mvc.member.service;

import com.spring.mvc.member.dto.request.MainBoardRequestDTO;
import com.spring.mvc.member.repository.MainBoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class MainBoardService {

    private final MainBoardMapper mainBoardMapper;

    //게시글 만들기 서비스
    public boolean save(MainBoardRequestDTO dto){

        return mainBoardMapper.save(dto.mainBoard());

    }
//    //personId로 회원이 만든 게시글 조회
//    public List<MainBoard> findRoomByPersonId(String personId){
//
//        return mainBoardMapper.findPersonId(personId);
//    }
//    //mainBoardId로 게시글 하나를 조회
//    public MainBoard findRoomByBoardId(Long BoardId){
//        return mainBoardMapper.findMainBoardId(BoardId);
//    }
//
//    //keyword로 내가 찾고 싶은 게시글 조회
//    public List<MainBoard> findRoomByTitle(String keyword){
//        return mainBoardMapper.findTitle(keyword);
//    }
}
