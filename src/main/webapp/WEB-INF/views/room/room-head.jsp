<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header id="head">
    <div class="logo-wrapper">
        <div id="room-logo" class="logo">
            <h1 id="room-title" data-room="${r.roomId}">${r.roomName}</h1>
        </div>
        <div id="head-btn" class="btn-wrap">
            <c:if test="${not empty login}">
                <a href="/main/main-page"><button id="home" type="button" class="btn btn-light">HOME</button></a>
                <a href="/mypage/board"><button id="mypage" type="button" class="btn btn-light">MY PAGE</button></a>
                <a href="/login/sign-out"><button id="logout" type="button" class="btn btn-light">LOGOUT</button></a>
            </c:if>
            <c:if test="${empty login}">
            <a href="/login/sign-in"><button id="loginp" type="button" class="btn btn-light">LOGIN</button></a>
            </c:if>
        </div>
    </div>
</header>
