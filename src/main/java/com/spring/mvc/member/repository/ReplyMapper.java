package com.spring.mvc.member.repository;

import com.spring.mvc.member.common.Page;
import com.spring.mvc.member.entity.Reply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReplyMapper {

    // 댓글 등록
    boolean save(Reply reply);

    // 댓글 수정
    boolean modify(Reply reply);

    // 댓글 삭제
    boolean delete(long replyId);

    // 댓글 개별 조회
    Reply findOne(long replyId);

    // 댓글 전체 목록 조회
    List<Reply> findAll(@Param("bi") long boardId, @Param("p") Page page);

    // 댓글 총 개수 조회
    int count(long boardNo);

}
