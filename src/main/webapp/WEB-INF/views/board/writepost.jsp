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
    <div id="post-wrapper-back">
        <div id="post-wrapper">
            <h2>홍보 게시물 및 방 만들기</h2>
            <form action="/board/room" method="post" id="create-room-form" >
                <p class="sub-title">홍보 게시물 작성</p>
                <div id="title" class="create-content">
                    <div class="input-group flex-nowrap">
                        <span class="input-group-text" id="ro=me">제목</span>
                        <input type="text" class="form-control" name="mainBoardTitle" placeholder="Username" aria-describedby="addon-wrapping">
                        <div class="valid-feedback">
                            Looks good!
                        </div>
                    </div>
                </div>
                <div id="content" class="create-content">
                    <div class="input-group flex-nowrap">
                        <span class="input-group-text" id="re">간단 소개</span>
                        <input type="text" class="form-control" name="mainBoardContent" placeholder="Content" aria-label="Username" aria-describedby="addon-wrapping">
                    </div>
                </div>
                <div id="create-room" >
                    <p class="sub-title">방 만들기</p>
                    <div class="input-group flex-nowrap create-content" >
                        <span class="input-group-text" id="room-name">방이름</span>
                        <input type="text" class="form-control" name="roomName" placeholder="Room_Name" aria-label="Username" aria-describedby="addon-wrapping">
                        <div class="valid-feedback">
                            Looks good!
                        </div>
                    </div>
                    <div class="input-group flex-nowrap create-content">
                    <span class="input-group-text" id="roomdfe">
                        <div class="form-check">
                          <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
                          <label class="form-check-label" for="flexCheckDefault">
                            방암호
                          </label>
                        </div>
                        </span>
                        <input id="inputPw" type="text" class="form-control" name="roomPw" placeholder="Room_Password" aria-label="Username" aria-describedby="addon-wrapping" disabled>
                    </div>
                    <div class="input-group flex-nowrap create-content">
                        <span class="input-group-text" id="room-me">최대인원수</span>
                        <input type="text" class="form-control" name="maxUser" placeholder="Max_User" aria-label="Username" aria-describedby="addon-wrapping">
                    </div>
                </div>
                <button id="createok" type="submit" class="btn btn-success">만들기</button>
                <a href="/main/main-page" class="btn btn-success">취소</a>
            </form>
        </div>
    </div>
</div>

<%@include file="../common/footer.jsp"%>
</body>
</html>