<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>My-Page DELETE</title>
    <%@include file="../common/static-head.jsp"%>
    <link rel="stylesheet" href="/assets/css/myPage/mainpage.css">
    <script src="/assets/js/main/myactive.js" defer></script>
    <%--    <style>--%>
    <%--        #d{--%>
    <%--            text-align: center;--%>
    <%--        }--%>
    <%--        #di {--%>
    <%--            text-align: center;--%>
    <%--            margin-top: 20px;--%>

    <%--        }--%>
    <%--        table {--%>
    <%--            border-collapse: collapse;--%>
    <%--            width: 400px;--%>
    <%--            margin: auto;--%>
    <%--        }--%>
    <%--        td {--%>
    <%--            padding: 10px;--%>

    <%--        }--%>
    <%--        input[type="submit"],--%>
    <%--        input[type="reset"] {--%>
    <%--            padding: 8px 12px;--%>
    <%--            font-size: 14px;--%>
    <%--            cursor: pointer;--%>
    <%--            margin-right: 10px;--%>
    <%--        }--%>
    <%--    </style>--%>
    <script src="/assets/js/personDelete.js" defer ></script>
</head>
<body>
<%@include file="../common/head.jsp"%>
<div id="myinfo-wapper">
    <%@include file="side-menu.jsp"%>
    <div id="form-wrapper" style="height: 1500px">
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
            <%--            <div class="mb-3">--%>
            <%--                <label for="sign_pw" class="form-label">비밀번호*</label>--%>
            <%--                <input type="password" class="form-control" id="sign_pw" name="password">--%>
            <%--                <div id="pwHelp" class="form-text"></div>--%>
            <%--            </div>--%>
            <%--            <div class="mb-3">--%>
            <%--                <label for="sign_pw2" class="form-label">비밀번호 재입력*</label>--%>
            <%--                <input type="password" class="form-control" id="sign_pw2">--%>
            <%--                <div id="pw2Help" class="form-text"></div>--%>
            <%--            </div>--%>
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
<div id="d">
    <h3>회원정보를 삭제 하시겠습니까?</h3>
</div>

<div id="di">
    <table>
        <tr>
            <td>
                <input type="submit" value="회원탈퇴" onclick="withdrawalFunction()"/>
                <input type="reset" value="취소" onclick="cancelFunction()"/>
            </td>
        </tr>
    </table>
</div>
<%@include file="../common/footer.jsp"%>
</body>
</html>