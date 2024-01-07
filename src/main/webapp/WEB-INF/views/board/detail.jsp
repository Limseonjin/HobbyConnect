<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Comment</title>
    <%@include file="../common/static-head.jsp"%>
    <link rel="stylesheet" href="/assets/css/board/board.css">
    <script type="text/javascript" src="/assets/js/board/board-detail.js" defer></script>
</head>
<body>
<%@include file="../common/del-modal.jsp"%>
<%@include file="../common/head.jsp"%>
<div id="bullentin-wrapper">
    <div class='form-0'>
            <div class='form-1'>
                <input id="board-modity" class='write-4' type="button" value="수정" >
                <input class='write-1' type="text" name="boardTitle" value="title 타이틀${boardTitle}" readonly>
                <input class='write-2' name="boardContent" value="content내영 ${boardContent}" readonly>
            </div>
    </div>
    <div class="line"></div>
    <div id="reply-wrapper" class="">
        <h2>댓글 작성</h2>
        <form class="reply-write" method="post" action="">
            <textarea id="comment-area" name="comment" rows="4" cols="50" placeholder="댓글을 작성하세요"></textarea>
            <button id="add-reply" type="submit" >댓글 등록</button>

        </form>
        <%--댓글 띄우는 코드--%>
        <ul class="comments">
<%--            댓글 비동기 --%>
            <li class="comment" data-rno="0">
                <div class="reply-wrap">
                    <div class="author">Susan Sanddollar</div>
                    <p class="reply-content">Lorem ipsum dolor sit amet</p>
                </div>
                <div class="reply-btn-wrap">
                    <button type="button" class="reply-modify btn-comment-up">수정</button>
                    <button type="button" class="reply-delete btn-comment-delete" data-bs-toggle="modal"  data-bs-target="#delete-modal">
                        삭제</button>
                </div>
            </li>
        </ul>
    </div>
</div>
<%@include file="../common/footer.jsp"%>
</body>
</html>