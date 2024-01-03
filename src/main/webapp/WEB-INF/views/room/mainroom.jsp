<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>회원가입 페이지</title>

    <%@include file="../common/static-head.jsp"%>
    <link rel="stylesheet" href="/assets/css/board/boardList.css">
    <link rel="stylesheet" href="/assets/css/room/main.css">
    <%-- 필요한 css나 js 선언   --%>
</head>
<body>
<%@include file="../common/del-modal.jsp"%>
<%@include file="room-head.jsp"%>
<%-- 여기서 부터 코드 입력 --%>
<div id="room-main-wrapper">
    <div id="members">
        <div class="card">
            <div class="card-body">
                <h2 class="card-title">어서오세요 ${nickName}님!</h2>
                <a href="/mypage/board" class="card-link">My Page</a>
                <a href="/login/sign-out" class="card-link">Logout</a>
            </div>
        </div>
        <div class="card">
            <div class="card-body">
                <ul>멤버 목록
                    <li>하이1</li>
                    <li>하이2</li>
                    <li>하이3</li>
                </ul>
            </div>
        </div>
    </div>
    <div id="main-body">
        <button id="create-room" type="button" class="btn btn-warning">글 쓰기</button>
        <div id="post-list" class="card">
            <div id="post-list-body" class="card-body">
                <div class="card room-post" data-bno="2">
                    <div class="card-header">
                        <h2>Title</h2>
                        <p class="card-text">작성자:${nickname}</p>
                    </div>
                    <div class="card-body">
                        <p class="contents">content:${b.boardContent}</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="../common/footer.jsp"%>
</body>
</html>