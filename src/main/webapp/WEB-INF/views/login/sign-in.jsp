<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>로그인 페이지</title>

    <%@include file="../common/static-head.jsp" %>
    <link rel="stylesheet" href="/assets/css/login/sign-in.css">
    <script src="/assets/js/login/sign-in.js" defer></script>
</head>
<body>
<%@include file="../common/head.jsp" %>

<div class="container wrap">
    <div class="row">
        <div class="offset-md-2 col-md-4">
            <div class="card" style="width:200%;">
                <div class="logo">
                    <img src="/assets/img/0.png">
                </div>
                <div class="card-body">

                    <form action="/login/sign-in" method="post" id="signInForm">

                        <table id="signInTable">
                            <tr>
                                <td><input type="text" name="personId" id="signInId"
                                           class="form-control tooltipstered" maxlength="10"
                                           required="required" aria-required="true"
                                           placeholder="아이디"></td>
                            </tr>

                            <tr>
                                <td><input type="password" size="17" maxlength="20" id="signInPw"
                                           name="password" class="form-control tooltipstered"
                                           maxlength="20" required="required" aria-required="true"
                                           placeholder="비밀번호"></td>
                            </tr>
                            <tr>
                                <td style="width: 100%; text-align: center; colspan: 2;"><Button type="submit" class="btn form-control tooltipstered" id="signIn-btn">
                                    로그인
                                </Button></td>
                            </tr>
                            <tr>
                                <td id="autoLoginBox">
                                    자동로그인 <input type="checkbox" id="autoLogin">
                                </td>
                            </tr>
                            <tr>
                                <td id="signUpBox">
                                    <div>계정이 없으신가요?<a href="/login/sign-up">가입하기</a></div>
                                </td>
                            </tr>
                            <tr>
                                <td id="iconBox">
                                    <a class="custom-login-btn" href="#">
                                        <img src="/assets/img/kakaoTalkIcon.png"/>
                                    </a>
                                    <a class="custom-login-btn" href="#">
                                        <img src="/assets/img/NaverIcon.png"/>
                                    </a>
                                    <a class="custom-login-btn" href="#">
                                        <img src="/assets/img/googleIcon.png"/>
                                    </a>
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="../common/footer.jsp"%>
</body>
</html>