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
<%@include file="../room/room-head.jsp"%>
<div id="bullentin-wrapper">
    <div class='form-0'>
            <div class='form-1' data-bno="${b.boardId}">
                <div id="board-btn">
                    <input id="board-modity" class='write-4' type="button" value="수정">
                    <input id="board-delete" class='write-4' type="button" value="삭제"  data-bs-toggle="modal"  data-bs-target="#delete-modal">
                </div>
                <input class='write-1' type="text" name="boardTitle" value="${b.boardTitle}" readonly>
                <input class='write-2' name="boardContent" value="${b.boardContent}" readonly>
            </div>
    </div>
    <div class="line"></div>
    <div id="reply-wrapper" class="">
        <h2>댓글 작성</h2>
        <div class="reply-write">
            <textarea id="comment-area" name="comment" rows="4" cols="50" placeholder="댓글을 작성하세요"></textarea>
            <button id="add-reply">댓글 등록</button>
        </div>
        <%--댓글 띄우는 코드--%>
        <ul class="comments">
<%--            댓글 비동기 --%>

        </ul>
    </div>
</div>
<%@include file="../common/footer.jsp"%>
</body>
</html>