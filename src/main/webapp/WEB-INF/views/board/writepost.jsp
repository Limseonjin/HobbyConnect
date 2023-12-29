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
</head>
<body>
<%@include file="../common/head.jsp"%>
<%-- 여기서 부터 코드 입력 --%>
<div id="write-post-wrapper">
    <div id="post-wrapper">
        <div id="title">
            <div class="input-group flex-nowrap">
                <span class="input-group-text" id="ro=me">제목</span>
                <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="addon-wrapping">
            </div>
        </div>
        <div id="content">
            <div class="input-group flex-nowrap">
                <span class="input-group-text" id="re">간단소개</span>
                <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="addon-wrapping">
            </div>
        </div>
        <form action="#" method="post" id="create-room" >
            <div class="input-group flex-nowrap">
                <span class="input-group-text" id="room-name">방이름</span>
                <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="addon-wrapping">
            </div>
            <div class="input-group flex-nowrap">
                <span class="input-group-text" id="roomdfe">방암호</span>
                <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="addon-wrapping">
            </div>
            <div class="input-group flex-nowrap">
                <span class="input-group-text" id="room-me">최대인원수</span>
                <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="addon-wrapping">
            </div>
        </form>
        <button type="button" class="btn btn-success">만들기</button>
        <button type="button" class="btn btn-success">취소</button>
    </div>

</div>

<%@include file="../common/footer.jsp"%>
</body>
</html>