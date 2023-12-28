package com.spring.mvc.member.service;

import com.spring.mvc.member.dto.request.MypageMemberModifyLocationRequestDTO;
import com.spring.mvc.member.dto.request.MypageMemberModifyNickNameRequestDTO;
import com.spring.mvc.member.dto.response.MemberResponseDTO;
import com.spring.mvc.member.dto.response.MypageBoardResponseDTO;
import com.spring.mvc.member.dto.response.MypageIntroductionResponseDTO;
import com.spring.mvc.member.dto.response.MypageReplyResponseDTO;
import com.spring.mvc.member.entity.Board;
import com.spring.mvc.member.entity.Member;
import com.spring.mvc.member.entity.Reply;
import com.spring.mvc.member.repository.MypageMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class MypageService {
    private final MypageMapper mypageMapper;

    // 회원 목록 전체 조회
    public MemberResponseDTO getMember(String personId) {
        Member member = mypageMapper.findMember(personId);
        return MemberResponseDTO.builder()
                .personId(member.getPersonId())
                .email(member.getEmail())
                .password(member.getPassword())
                .nickname(member.getNickname())
                .location(member.getLocation())
                .introduction(member.getIntroduction())
                .build();
    }


    // 1. 내가 쓴 글 조회
    public List<MypageBoardResponseDTO> getBoardList(String personId) {
        return mypageMapper.findAllMyBoard(personId)
                .stream()
                .map(MypageBoardResponseDTO::new)
                .collect(Collectors.toList())
                ;
    }

    // 2. 내가 쓴 댓글 조회
    public List<MypageReplyResponseDTO> getReplyList(String personId) {
        return mypageMapper.findAllMyReply(personId)
                .stream()
                .map(MypageReplyResponseDTO::new)
                .collect(Collectors.toList())
                ;
    }

    // 3. 프로필사진(추후 제작 예정)

    // 4. 한줄 소개 조회
    public MypageIntroductionResponseDTO getMyIntroduction(String personId) {
        Member introduction = mypageMapper.findIntroduction(personId);

        return new MypageIntroductionResponseDTO(introduction);
    }

    // 5. 닉네임 수정
    @Transactional
    public MemberResponseDTO modifyNickName(MypageMemberModifyNickNameRequestDTO dto) {
        mypageMapper.modifyNickName(dto.toEntitiy());
        return getMember(dto.getPersonId());
    }

    // 6. 지역 수정
    @Transactional
    public MemberResponseDTO modifyLocation(MypageMemberModifyLocationRequestDTO dto) {
        mypageMapper.modifyLocation(dto.toEntitiy());
        return getMember(dto.getPersonId());
    }

}
