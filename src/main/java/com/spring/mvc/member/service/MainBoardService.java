package com.spring.mvc.member.service;

import com.spring.mvc.member.common.Page;
import com.spring.mvc.member.dto.request.MainBoardModifyRequestDTO;
import com.spring.mvc.member.dto.request.MainBoardRequestDTO;
import com.spring.mvc.member.dto.response.MainBoardResponseDTO;
import com.spring.mvc.member.entity.MainBoard;
import com.spring.mvc.member.entity.Room;
import com.spring.mvc.member.repository.MainBoardMapper;
import com.spring.mvc.member.repository.MemberMapper;
import com.spring.mvc.member.repository.RoomMapper;
import com.spring.mvc.member.repository.RoomMemberMapper;
import com.spring.mvc.util.LoginUtil;
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
    private final RoomMemberMapper roomMemberMapper;


    //게시글 만들기 서비스
    public void save(MainBoardRequestDTO dto, HttpSession session){
        log.debug("main board save dto : {} ", dto);
        MainBoard mainBoard = dto.mainBoard(session);
        mainBoard.setPersonId(LoginUtil.getCurrentLoginMemberAccount(session));
        mainBoardMapper.save(mainBoard);
        Long mainBoardId = mainBoard.getMainBoardId();
        mainBoardMapper.roomSave(mainBoardId);
        roomMemberMapper.save(dto.toEntityByRoomMember(session,mainBoardId));



    }
    // 페이징 처리한 조회
    public List<MainBoardResponseDTO> pagefindAll(Page page){
        List<MainBoard> mainBoards = mainBoardMapper.pagefindAll(page);
        return mainBoards.stream()
                .map(MainBoardResponseDTO::new)
                .collect(Collectors.toList());
    }
    // 일반 조회
    public List<MainBoardResponseDTO> findAll(){
        List<MainBoard> maxUser = mainBoardMapper.findAll();
        return maxUser.stream()
                .map(MainBoardResponseDTO::new)
                .collect(Collectors.toList());
    }
    public List<MainBoardResponseDTO> modify(MainBoardModifyRequestDTO dto) {
        mainBoardMapper.modify(dto.toEntity());
        return findAll();
    }

    //personId로 회원이 만든 게시글 조회
    public List<MainBoardResponseDTO> findRoomByPersonId(String personId,Page page){

        List<MainBoard> mainboard = mainBoardMapper.findPersonId(personId, page);
        return mainboard.stream()
                .map(MainBoardResponseDTO::new)
                .collect(Collectors.toList());
    }
    //keyword로 내가 찾고 싶은 게시글 조회
    public List<MainBoardResponseDTO> findRoomByTitle(String keyword, Page page){

        List<MainBoard> mainBoards = mainBoardMapper.findTitle(keyword, page);
        return mainBoards.stream()
                .map(MainBoardResponseDTO::new)
                .collect(Collectors.toList());


    }
    public List<MainBoardResponseDTO> delete(Long bno) {
        mainBoardMapper.delete(bno);
        return mainBoardMapper.findAll().stream()
                .map(MainBoardResponseDTO::new)
                .collect(Collectors.toList());
    }

}
