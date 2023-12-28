<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>회원가입 페이지</title>
    <%@include file="../common/static-head.jsp"%>

    <link rel="stylesheet" href="/assets/css/login/sign-up.css">
    <script src="/assets/js/login/sign-up.js" defer></script>
</head>
<body>
    <%@include file="../common/head.jsp"%>

    <div id="form-wrapper">
        <h2> 회원가입 폼 </h2>
        <form action="sign-up" name="signup" id="signUpForm" class="sign-up-form" method="post">

            <div class="mb-3">
                <label for="user_id" class="form-label">아이디*</label>
                <input type="text" class="form-control" id="user_id" name="personId">
                <div id="idHelp" class="form-text"></div>
            </div>
            <div class="mb-3">
                <label for="sign_pw" class="form-label">비밀번호*</label>
                <input type="password" class="form-control" id="sign_pw" name="password">
                <div id="pwHelp" class="form-text"></div>
            </div>
            <div class="mb-3">
                <label for="sign_pw2" class="form-label">비밀번호 재입력*</label>
                <input type="password" class="form-control" id="sign_pw2">
                <div id="pw2Help" class="form-text"></div>
            </div>
            <div class="mb-3">
                <label for="sign_nickname" class="form-label">닉네임*</label>
                <input type="text" class="form-control" id="sign_nickname" name="nickname">
                <div id="nickHelp" class="form-text"></div>
            </div>
            <div class="mb-3">
                <label for="sign_email" class="form-label">이메일</label>
                <input type="email" class="form-control" id="sign_email" name="email">
                <div id="emailHelp" class="form-text"></div>
            </div>
            <div class="mb-3">
                <label for="sign_local" class="form-label">지역</label>
                <input type="text" class="form-control" id="sign_local" name="location" >
            </div>
            <div class="mb-3">
                <label for="sign_intro" class="form-label">한 줄 소개</label>
                <input type="text" class="form-control" id="sign_intro" name="introduction">
            </div>
           <div class="container">
               <div> *은 필수 입력값 입니다.</div>

               <br>
               <button id="sign_ok" type="button" class="btn btn-primary">가입하기</button>
           </div>
        </form>
    </div>

    <%@include file="../common/footer.jsp"%>

</body>
</html>