package com.spring.mvc.member.service;

import com.spring.mvc.member.common.Page;
import com.spring.mvc.member.common.PageMaker;
import com.spring.mvc.member.dto.request.ReplyModifyRequestDTO;
import com.spring.mvc.member.dto.request.ReplyPostRequestDTO;
import com.spring.mvc.member.dto.response.ReplyDetailResponseDTO;
import com.spring.mvc.member.dto.response.ReplyListResponseDTO;
import com.spring.mvc.member.entity.Reply;
import com.spring.mvc.member.repository.ReplyMapper;
import com.spring.mvc.util.LoginUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReplyService {

    private final ReplyMapper replyMapper;

    // 댓글 목록 조회
    public ReplyListResponseDTO getList(long boardNo, Page page) {

        // DB에서 댓글 정보 조회
        List<ReplyDetailResponseDTO> replies = replyMapper.findAll(boardNo, page)
                .stream()
                .map(ReplyDetailResponseDTO::new)
                .collect(Collectors.toList());
        System.out.println("replies = " + replies);

        // DB에서 총 댓글 수 조회
        int count = replyMapper.count(boardNo);

        return ReplyListResponseDTO.builder()
                .replies(replies)
                .count(count)
                .pageInfo(new PageMaker(page, count))
                .build();
    }

    // 댓글 등록
    public ReplyListResponseDTO register(ReplyPostRequestDTO dto, HttpSession session) {
        Reply reply = dto.toEntity();
        reply.setPersonId(LoginUtil.getCurrentLoginMemberAccount(session));
        replyMapper.save(reply);

        return getList(dto.getBoardId(), new Page(1, 5));
    }
    // 댓글 수정
    public ReplyListResponseDTO modify(ReplyModifyRequestDTO dto) {
        replyMapper.modify(dto.toEntity());
        return getList(dto.getBId(), new Page(1, 5));
    }


    // 댓글 삭제
    public ReplyListResponseDTO delete(long replyNo) {
        Reply replyMapperOne = replyMapper.findOne(replyNo);
        long boardNo = replyMapperOne.getBoardId();
        replyMapper.delete(replyNo);

        return getList(boardNo, new Page(1, 5));
    }
}

