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
        <div class="card" style="width: 18rem;">
            <div class="card-body">
                <h2 class="card-title">어서오세요 ${nickName}님!</h2>
                <a href="/mypage/board" class="card-link">My Page</a>
                <a href="/login/sign-out" class="card-link">Logout</a>
            </div>
        </div>
        <div class="card" style="width: 18rem;">
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
                <%--                <c:forEach var="b" items="${bList}">  ${b.boardId} --%>
                <div class="card room-post" data-bno="2">
                    <div class="card-header">
                        <h2> ${b.boardTitle}Title</h2>
                        <div class="icon">
                            <button class="modify btn" data-bs-toggle="modal"  data-bs-target="#update-modal">
                                <svg xmlns="http://www.w3.org/2000/svg"  fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                                    <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                                    <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5z"/>
                                </svg>
                            </button>
                            <button class="trash btn" data-bs-toggle="modal"  data-bs-target="#delete-modal">
                                <svg xmlns="http://www.w3.org/2000/svg"  fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                    <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z"/>
                                    <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z"/>
                                </svg>
                            </button>
                        </div>
                    </div>
                    <div class="card-body">
                        <p class="contents">content:${b.boardContent}</p>
                        <div class="jcend">
                            <p class="card-text">작성자:${nickname}</p>
                        </div>

                        <button class="btn btn-primary" type="submit">참여하기</button>
                    </div>
                </div>
                <%--                </c:forEach>--%>
            </div>
        </div>
    </div>
</div>

<%@include file="../common/footer.jsp"%>
</body>
</html>