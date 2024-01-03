<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>마이페이지</title>
    <link rel="stylesheet" type="text/css" href="/assets/css/mypage/mainpage.css">
<%--    <script src="/assets/js/mypage/updateinfo.js" defer></script>--%>
    <%@include file="../common/static-head.jsp"%>
    <%-- 필요한 css나 js 선언   --%>
</head>
<body>
<%@include file="../common/head.jsp"%>
<%-- 여기서 부터 코드 입력 --%>
<div class="page-wrapper">
    <%@include file="side-menu.jsp"%>
    <div id="form-wrapper">
        <h2> 회원수정 </h2>
        <form action="/mypage/info" name="info" id="signUpForm" class="info-form" method="post">
            <div class="mb-3">
                <label for="user_id" class="form-label">아이디</label>
                <input type="text" class="form-control" id="user_id" name="personId" value="${personId}" readonly>
                <div id="idHelp" class="form-text"></div>
            </div>
            <div class="mb-3">
                <label for="sign_nickname" class="form-label">닉네임</label>
                <input type="text" class="form-control" id="sign_nickname" name="nickname" value="${nickname}">
                <div id="nickHelp" class="form-text"></div>
            </div>
            <div class="mb-3">
                <label for="sign_email" class="form-label">이메일</label>
                <input type="email" class="form-control" id="sign_email" name="email" value="${nickname}" >
                <div id="emailHelp" class="form-text"></div>
            </div>
            <div class="mb-3">
                <label for="sign_intro" class="form-label">한 줄 소개</label>
                <input type="text" class="form-control" id="sign_intro" name="introduction" value="${introduction}">
            </div>
            <div class="container">
                <button id="sign_ok" type="submit" class="btn btn-primary">수정하기</button>
            </div>
        </form>
        <form action="/mypage/infopw" class="info-form" method="post">
            <div class="mb-3">
                <label for="sign_pw" class="form-label">비밀번호</label>
                <input type="password" class="form-control" id="sign_pw" name="password">
                <div id="pwHelp" class="form-text"></div>
            </div>
            <div class="mb-3">
                <label for="sign_pw2" class="form-label">비밀번호 재입력</label>
                <input type="password" class="form-control" id="sign_pw2">
                <div id="pw2Help" class="form-text"></div>
            </div>
            <button id="pwok" type="submit" class="btn btn-primary">비밀번호 수정하기</button>
        </form>

    </div>

</div>
<%@include file="../common/footer.jsp"%>
</body>
</html>