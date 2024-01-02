<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>글 작성 페이지</title>

    <%@include file="../common/static-head.jsp"%>
    <%-- 필요한 css나 js 선언   --%>
    <link rel="stylesheet" href="/assets/css/board/writepost.css">
    <script type="text/javascript" src="/assets/js/board/writeboard.js" defer></script>
</head>
<body>
<%@include file="../common/head.jsp"%>
<%-- 여기서 부터 코드 입력 --%>
<div id="write-post-wrapper">
    <div id="post-wrapper">
        <form action="/main/main-page" method="post" id="create-room-form" >
            <div id="title">
                <div class="input-group flex-nowrap">
                    <span class="input-group-text" id="ro=me">제목</span>
                    <input type="text" class="form-control" name="mainBoardTitle" placeholder="Username" aria-describedby="addon-wrapping">
                </div>
            </div>
            <div id="content">
                <div class="input-group flex-nowrap">
                    <span class="input-group-text" id="re">간단소개</span>
                    <input type="text" class="form-control" name="mainBoardContent" placeholder="Content" aria-label="Username" aria-describedby="addon-wrapping">
                </div>
            </div>
            <div id="create-room">
                <div class="input-group flex-nowrap">
                    <span class="input-group-text" id="room-name">방이름</span>
                    <input type="text" class="form-control" name="roomName" placeholder="Room_Name" aria-label="Username" aria-describedby="addon-wrapping">
                </div>
                <div class="input-group flex-nowrap">
                    <span class="input-group-text" id="roomdfe">방암호</span>
                    <input type="text" class="form-control" name="roomPw" placeholder="Room_Password" aria-label="Username" aria-describedby="addon-wrapping">
                </div>
                <div class="input-group flex-nowrap">
                    <span class="input-group-text" id="room-me">최대인원수</span>
                    <input type="text" class="form-control" name="maxUser" placeholder="Max_User" aria-label="Username" aria-describedby="addon-wrapping">
                </div>
            </div>
            <button id="createok" type="submit" class="btn btn-success">만들기</button>
            <a href="/main/main-page" class="btn btn-success">취소</a>
        </form>

    </div>
</div>

<%@include file="../common/footer.jsp"%>
</body>
</html>