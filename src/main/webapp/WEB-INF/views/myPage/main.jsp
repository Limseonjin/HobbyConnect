<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <%@ include file="../common/static-head.jsp"%>
    <link rel="stylesheet" href="/assets/css/common.css">
    <link rel="stylesheet" href="/assets/css/head.css">
    <link rel="stylesheet" href="/assets/css/footer.css">
    <link rel="stylesheet" href="/assets/css/myPage/mainpage.css">

</head>
<body>
    <%@include file="../common/head.jsp"%>
    <div class="page-wrapper">
        <div id="userInfo">
            <div class="card border-secondary mb-3" style="width: 18rem;">
                <div class="card-body">
                    <p class="card-text">닉네임 : <sapn>name</sapn></p>
                    <p class="card-text">${personId}</p>
                    <p class="card-text">한줄소개</p>
                </div>
            </div>

        </div>
        <div id="mypage-side-menu">
            <div class="card border-secondary mb-3" style="width: 18rem;">
                <div class="card-body">
                    <ul>나의 활동
                        <li>참여중인 방</li>
                        <li>내가 쓴 글</li>
                        <li>내가 쓴 댓글</li>
                    </ul>
                    <div class="line"></div>
                    <ul>회원정보
                        <li>회원정보 수정</li>
                        <li>회원정보 삭제</li>
                    </ul>
                </div>
            </div>
        </div>
        <div class="activies">
            <button id="room-list">참여중인 방</button>
            <button id="board-list">내가 쓴 글</button>
            <button id="reply-list">내가 쓴 댓글</button>
            <div class="active-list-wrapper">
                <div class="card border-secondary mb-3" style="width: 18rem;">
                    <div class="card-body">

                    </div>
                </div>
            </div>

        </div>
    </div>
    <%@include file="../common/footer.jsp"%>
</body>
</html>