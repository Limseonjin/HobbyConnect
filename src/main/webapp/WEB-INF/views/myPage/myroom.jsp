<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>마이페이지</title>

    <%@ include file="../common/static-head.jsp"%>
    <link rel="stylesheet" href="/assets/css/myPage/mainpage.css">
    <script src="/assets/js/main/myactive.js" defer></script>
</head>
<body>
    <%@include file="../common/head.jsp"%>
    <div class="page-wrapper">
        <%@include file="./side-menu.jsp"%>

        <div class="activities">
            <button id="room-list" type="button" class="btn btn-light">참여중인 방 </button>
            <button id="board-list" type="button" class="btn btn-light">내가 쓴 글</button>
            <button id="reply-list" type="button" class="btn btn-light">내가 쓴 댓글</button>
            <div class="active-list-wrapper">
                <div class="card border-secondary mb-3">
                    <div class="room-card card-body">
<%--                        <c:forEach var="r" items="${rList}">--%>
                            <div class="mypage-room card border-secondary mb-3" >
                                <div class="card-body room-wrapper">
                                    <img class="room-img">
                                    <div class="title">
                                        <p>방 이름${r.roomName}</p>
                                    </div>
                                    <div class="other">
                                        <p>방 인원(${currUser}/${maxUser})</p>
                                    </div>
                                </div>
                            </div>
<%--                        </c:forEach>--%>

                    </div>
                </div>
            </div>

        </div>
    </div>
    <%@include file="../common/footer.jsp"%>
</body>
</html>