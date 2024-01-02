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
<%@include file="common/head.jsp"%>
<%-- 여기서 부터 코드 입력 --%>
<div id="main-wrapper">
    <%--       서치와 간단 프로필 --%>
    <div id="main-head">
        <div id="serch" class="input-group mb-3">
            <input type="text" class="form-control" placeholder="Recipient's username" aria-label="Recipient's username"
                   aria-describedby="button-addon2">
            <button class="btn btn-outline-secondary" type="button" id="button-addon2">검색</button>
        </div>
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
        <button id="create-room" type="button" class="btn btn-warning">방 만들기</button>
        <div id="post-list" class="card">
            <div id="post-list-body" class="card-body">

            </div>
        </div>
        <%--    페이지 번호 --%>
        <nav id="page-num" aria-label="Page navigation example">
            <ul class="pagination">
                <li class="page-item">
                    <a class="page-link" href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item"><a class="page-link" href="#">4</a></li>
                <li class="page-item"><a class="page-link" href="#">5</a></li>
                <li class="page-item">
                    <a class="page-link" href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</div>
<%@include file="common/footer.jsp" %>

</body>
</html>