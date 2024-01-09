package com.spring.mvc.member.service;

import com.spring.mvc.member.dto.request.MypageMemberInfoModifyRequestDTO;
import com.spring.mvc.member.dto.request.MypageMemberPasswordModifyRequestDTO;
import com.spring.mvc.member.dto.response.*;
import com.spring.mvc.member.entity.Member;
import com.spring.mvc.member.entity.Room;
import com.spring.mvc.member.repository.MypageMapper;
import com.spring.mvc.util.LoginUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

import static com.spring.mvc.util.LoginUtil.LOGIN_KEY;

@Slf4j
@Service
@RequiredArgsConstructor
public class MypageService {
    private final MypageMapper mypageMapper;
    private final PasswordEncoder encoder;

    // 회원 목록 전체 조회
    public MemberResponseDTO getMemberBySession(HttpSession session) {
        Member member = mypageMapper.findMember(LoginUtil.getCurrentLoginMemberAccount(session));
        return MemberResponseDTO.builder()
                .personId(member.getPersonId())
                .email(member.getEmail())
                .password(member.getPassword())
                .nickname(member.getNickname())
                .introduction(member.getIntroduction())
                .build();
    }

    public MemberResponseDTO getMember(String personId) {
        Member member = mypageMapper.findMember(personId);
        return MemberResponseDTO.builder()
                .personId(member.getPersonId())
                .email(member.getEmail())
                .password(member.getPassword())
                .nickname(member.getNickname())
                .introduction(member.getIntroduction())
                .build();
    }

    public List<Room> getMainBoardList(HttpSession session) {
        return mypageMapper.findAllMyRoom(LoginUtil.getCurrentLoginMemberAccount(session));


    }


    // 1. 내가 쓴 글 조회
    public List<MypageBoardResponseDTO> getBoardList(HttpSession session) {
        List<MypageBoardResponseDTO> collect = mypageMapper.findAllMyBoard(LoginUtil.getCurrentLoginMemberAccount(session))
                .stream()
                .map(MypageBoardResponseDTO::new)
                .collect(Collectors.toList());
        return collect;
    }

    // 2. 내가 쓴 댓글 조회
    public List<MypageReplyResponseDTO> getReplyList(HttpSession session) {
        return mypageMapper.findAllMyReply(LoginUtil.getCurrentLoginMemberAccount(session));
    }

    // 3. 프로필사진(추후 제작 예정)

    // 4. 한줄 소개 조회
    public MypageIntroductionResponseDTO getMyIntroduction(String personId) {
        Member introduction = mypageMapper.findIntroduction(personId);

        return new MypageIntroductionResponseDTO(introduction);
    }

    // 5. 수정
    @Transactional
    public void modifyInfo(HttpSession session, MypageMemberInfoModifyRequestDTO dto) {
        Member entity = dto.toEntitiy(LoginUtil.getCurrentLoginMemberAccount(session));
        mypageMapper.modifyInfo(entity);
    }

    @Transactional
    public void modifyPassword(HttpSession session, MypageMemberPasswordModifyRequestDTO dto) {
        Member entity = dto.toEntitiy(LoginUtil.getCurrentLoginMemberAccount(session), encoder);
        mypageMapper.modifyPassword(entity);
    }

    // 6. 삭제
    @Transactional
    public void delete(HttpSession session) {
        mypageMapper.delMember(LoginUtil.getCurrentLoginMemberAccount(session));
        System.out.println("session = " + session);
        // 세션에서 로그인 정보 기록 삭제
        session.removeAttribute(LOGIN_KEY);
        // 세션 초기화
        session.invalidate();
        System.out.println("session = " + session);
    }

}
