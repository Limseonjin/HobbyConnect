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
            <label>제목</label>
            <input>
        </div>
        <div class="form-check">
            <input class="form-check-input" type="checkbox" value="" id="roomCreateChecked" checked>
            <label class="form-check-label" for="roomCreateChecked">
                방 만들기 여부
            </label>
        </div>
        <form>
            <div class="input-group flex-nowrap">
                <span class="input-group-text" id="room-name">방이름</span>
                <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="addon-wrapping">
            </div>
            <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="roomRockChecked" checked>
                <div class="input-group flex-nowrap">
                    <span class="input-group-text" id="room-key">방 암호</span>
                    <input type="text" class="form-control" placeholder="Username" aria-label="Username" aria-describedby="addon-wrapping">
                </div>
            </div>

        </form>
        <div id="content">
        </div>
    </div>

</div>

<%@include file="../common/footer.jsp"%>
</body>
</html>