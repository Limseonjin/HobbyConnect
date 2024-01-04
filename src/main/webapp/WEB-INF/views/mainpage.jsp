<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>MAIN</title>

    <%@include file="common/static-head.jsp" %>
    <%-- 필요한 css나 js 선언   --%>
    <link rel="stylesheet" href="/assets/css/mainpage/main.css">
    <link rel="stylesheet" href="/assets/css/board/boardList.css">

    <script src="/assets/js/main/mainpage.js" defer></script>

</head>
<body>

<%@include file="common/del-modal.jsp"%>
<%@include file="common/mod-modal.jsp"%>
<%@include file="common/room-pw-modal.jsp"%>
<%@include file="common/head.jsp"%>
<%-- 여기서 부터 코드 입력 --%>
<div id="main-wrapper">
    <%--       서치와 간단 프로필 --%>
    <div id="main-head">
        <nav id="search" class="navbar navbar-light bg-light">
            <div class="container-fluid">
                <div class="d-flex">
                    <select id="search-type" class="type-select form-select form-select-lg">
                        <option value="findByTitle" selected>제목</option>
                        <option value="content">내용</option>
                        <option value="findByPersonId">작성자</option>
                    </select>
                    <input id="search-content" class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button id="search-btn" class="btn btn-outline-success" type="button">Search</button>
                </div>
            </div>
        </nav>
        <div class="card" style="width: 18rem;">
            <div class="card-body">
                <h2 class="card-title">어서오세요 ${login.nickname}님!</h2>
                <a href="/mypage/board" class="card-link">My Page</a>
                <a href="/login/sign-out" class="card-link">Logout</a>
            </div>
        </div>
    </div>
    <%--     게시글 목록들 --%>
    <div id="main-body">
        <c:if test="${login != null}">
            <button id="create-room" type="button" class="btn btn-warning">방 만들기</button>
        </c:if>
        <div id="post-list" class="card">
            <div id="post-list-body" class="card-body">

            </div>
        </div>
        <%--    페이지 번호 --%>
        <nav id="page-num" aria-label="Page navigation example">
<%--            페이지 번호 비동기 처리 --%>
        </nav>
    </div>
</div>
<%@include file="common/footer.jsp" %>

</body>
</html>