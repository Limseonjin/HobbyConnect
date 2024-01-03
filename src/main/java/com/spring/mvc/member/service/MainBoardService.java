package com.spring.mvc.member.service;

import com.spring.mvc.member.dto.request.MainBoardRequestDTO;
import com.spring.mvc.member.dto.response.MainBoardResponseDTO;
import com.spring.mvc.member.entity.MainBoard;
import com.spring.mvc.member.entity.Room;
import com.spring.mvc.member.repository.MainBoardMapper;
import com.spring.mvc.member.repository.RoomMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class MainBoardService {

    private final MainBoardMapper mainBoardMapper;
    private final RoomMapper roomMapper;

    //게시글 만들기 서비스
    public boolean save(MainBoardRequestDTO dto, HttpSession session){
        List<Room> byPersonId = roomMapper.findByPersonId(dto.getPersonId());
        log.debug("main board save dto : {} ", dto);
        return mainBoardMapper.save(dto.mainBoard(session));

    }
    public void addRoomId(MainBoardRequestDTO dto, HttpSession session){
        mainBoardMapper.roomSave(dto.mainBoard(session));
    }
    public List<MainBoardResponseDTO> findAll(){
        List<MainBoard> maxUser = mainBoardMapper.findAll();
        return maxUser.stream()
                .map(MainBoardResponseDTO::new)
                .collect(Collectors.toList());
    }
    //personId로 회원이 만든 게시글 조회
    public List<MainBoard> findRoomByPersonId(String personId){

        return mainBoardMapper.findPersonId(personId);
    }
    //mainBoardId로 게시글 하나를 조회
    public MainBoard findRoomByBoardId(Long BoardId){
        return mainBoardMapper.findMainBoardId(BoardId);
    }

    //keyword로 내가 찾고 싶은 게시글 조회
    public List<MainBoard> findRoomByTitle(String keyword){
        return mainBoardMapper.findTitle(keyword);
    }



    public List<MainBoardResponseDTO> delete(Long bno) {
        mainBoardMapper.delete(bno);
        return mainBoardMapper.findAll().stream()
                .map(MainBoardResponseDTO::new)
                .collect(Collectors.toList());
    }
}
