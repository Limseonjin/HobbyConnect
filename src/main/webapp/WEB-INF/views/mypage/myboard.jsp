<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>마이페이지</title>

    <%@ include file="../common/static-head.jsp"%>
    <link rel="stylesheet" href="/assets/css/mypage/mainpage.css">
    <script src="/assets/js/main/myactive.js" defer></script>
</head>
<body>
    <%@include file="../common/head.jsp"%>
    <div class="page-wrapper">
        <%@include file="./side-menu.jsp"%>

        <div class="activities">
            <ul class="nav nav-tabs">
                <li class="nav-item">
                    <a class="nav-link"  href="/mypage/room">참여중인 방</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="/mypage/board">내가 쓴 글</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/mypage/reply">내가 쓴 댓글</a>
                </li>
            </ul>
            <div class="active-list-wrapper">
                <div class="card border-secondary mb-3">
                    <div class="card-body">
                        <c:forEach var="b" items="${bList}">
                            <div class="mypage-board card border-secondary mb-3" >
                                <div class="card-body board-wrapper">
                                    <div class="title">
                                        <p>${b.boardTitle}</p>
                                    </div>
                                    <div class="other">
                                        <p>작성자 : ${p.nickname}</p>
                                        <p>조회수 : ${b.viewCount}</p>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <%@include file="../common/footer.jsp"%>
</body>
</html>