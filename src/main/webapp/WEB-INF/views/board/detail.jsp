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
<header>
    <div class="hero">
        <h1>Bulletin Board</h1>
    </div>
    <p class="note">"It's HOBBY CONNECT with you.
        Feel free to share your opinions,ask questions</p>
</header>
<div id="bullentin-wrapper">
    <div class='form-0'>
            <form class='form-1' method="POST"  enctype="multipart/form-data">
                <input class='write-1' type="text" name="boardTitle" readonly>
                <input class='write-2' name="boardContent"  readonly>
                </input>
                <input class='write-4' type="submit" value="수정" >
            </form>
    </div>
    <div id="reply-wrapper">
        <h2>댓글 작성</h2>
        <form method="post" action="">
            <textarea name="comment" rows="4" cols="50" placeholder="댓글을 작성하세요"></textarea>
            <input type="submit" value="댓글 등록">
        </form>
        <%--댓글 띄우는 코드--%>
        <div>
            <ul class="comments">
                <li class="comment">
                    <div class="reply-wrap">
                        <div class="author">Susan Sanddollar</div>
                        <p class="reply-content">Lorem ipsum dolor sit amet</p>
                    </div>
                    <div class="reply-btn-wrap">
                        <button type="button" class="reply-modify btn-comment-up">수정</button>
                        <button type="button" class="reply-delete btn-comment-delete">삭제</button>
                    </div>
                </li>
            </ul>
        </div>
    </div>

</div>

<script>

</script>
</body>
</html>