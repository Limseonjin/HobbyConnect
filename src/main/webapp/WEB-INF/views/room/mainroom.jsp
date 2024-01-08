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
    <script src="/assets/js/board/room-board.js" defer></script>
</head>
<body>
<%@include file="exit-modal.jsp"%>
<%@include file="../common/del-modal.jsp"%>
<%@include file="room-head.jsp"%>
<%-- 여기서 부터 코드 입력 --%>
<div id="room-main-wrapper">
    <div id="members">
        <div class="card">
            <div class="card-body">
                <h2 id="myuser" class="card-title" data-id=${login.personId}>어서오세요 ${login.nickname}님!</h2>
                <a href="/mypage/board" class="card-link">My Page</a>
                <a href="/login/sign-out" class="card-link">Logout</a>
            </div>
        </div>
        <div class="card member-list">
            <div class="card-body">
                <nav class="nav nav-pills flex-column">
                    <h2> 멤버목록 </h2>
                    <div class="nav-pills flex-column">
                        <c:forEach var="rm" items="${rmList}">
                            <div class="user-wrap">
                                <p class="nav-link ms-3 my-1" data-id="${rm.personId}">${rm.nickname}</p>
                                <span class="del-mem lnr lnr-cross"></span>
                            </div>
                        </c:forEach>
                    </div>
                </nav>
            </div>
        </div>
        <div class="exit-room">
            <button id="exitRoom" class="btn btn-dark nagagi" data-bs-toggle="modal" data-bs-target="#leaveRoomModal">
                방 나가기</button>
        </div>
    </div>
    <div id="main-body">
        <div id="room-post-list" class="card">
            <div id="post-list-body" class="card-body">
                <button id="create-board" type="button" class="btn btn-dark">글 쓰기</button>
                <div id="board-list">
                    <%-- 게시글 조회 비동기 --%>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="../common/footer.jsp"%>
</body>
</html>