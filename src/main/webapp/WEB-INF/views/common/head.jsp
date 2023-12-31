<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header id="head" data-id=${login.personId}>
    <div class="logo-wrapper">
        <div class="logo">
            <a href="/main/main-page"><img src="/assets/img/0.png" width="300" height="150"></a>
        </div>
        <div id="head-btn" class="btn-wrap">
            <c:if test="${not empty login}">
                <a href="/login/sign-out"> <button id="logout" type="button" class="btn btn-light">LOGOUT</button></a>
                <a href="/mypage/room"><button id="mypage" type="button" class="btn btn-light">MY PAGE</button></a>
            </c:if>
            <c:if test="${empty login}">
                <a href="/login/sign-in"><button id="loginp" type="button" class="btn btn-light">LOGIN</button></a>
            </c:if>
        </div>
    </div>
</header>
