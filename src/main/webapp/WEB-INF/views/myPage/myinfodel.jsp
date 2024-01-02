<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>마이페이지</title>
    <link rel="stylesheet" type="text/css" href="assets/css/myPage/myinfo.css">
    <script src="/assets/js/mypage/updateinfo.js" defer></script>
    <%@include file="../common/static-head.jsp"%>
    <%-- 필요한 css나 js 선언   --%>
</head>
<body>
<%@include file="../common/head.jsp"%>
<%-- 여기서 부터 코드 입력 --%>
<div id="myinfo-wapper">
    <%@include file="side-menu.jsp"%>
    <div id="form-wrapper">
        <h2> 회원수정 </h2>
        <div class="end"> *은 필수 입력값 입니다.</div>
        <form action="sign-up" name="signup" id="signUpForm" class="sign-up-form" method="post">
            <div class="mb-3">
                <label for="user_id" class="form-label">아이디</label>
                <input type="text" class="form-control" id="user_id" name="personId"  value="${p.personId}"  readonly>
                <div id="idHelp" class="form-text"></div>
            </div>
            <div class="mb-3">
                <button id="pw-update-btn" type="button" class="btn btn-primary">비밀번호 변경</button>
            </div>
            <div class="mb-3" id="pwform">

            </div>
            <div class="mb-3">
                <label for="sign_nickname" class="form-label">닉네임*</label>
                <input type="text" class="form-control" id="sign_nickname" name="nickname" value="${p.nickname}">
                <div id="nickHelp" class="form-text"></div>
            </div>
            <div class="mb-3">
                <label for="sign_email" class="form-label">이메일</label>
                <input type="email" class="form-control" id="sign_email" name="email" value="${p.nickname}" >
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
</div>

</div>
<%@include file="../common/footer.jsp"%>
</body>
</html>