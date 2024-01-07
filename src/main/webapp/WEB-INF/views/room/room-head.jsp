<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header id="head">
    <div class="logo-wrapper">
        <div class="logo">
            <h1 id="room-title" data-room="${roomId}">Board Title ${roomName}</h1>
        </div>
        <div id="head-btn" class="btn btn-wrap">
            <c:if test="${not empty login}">
                <button id="home" type="button" class="btn btn-light"><a href="/main/main-page">HOME</a></button>
                <button id="mypage" type="button" class="btn btn-light"><a href="/mypage/board">MY PAGE</a></button>
                <button id="logout" type="button" class="btn btn-light"><a href="/login/sign-out">LOGOUT</a></button>

            </c:if>
            <c:if test="${empty login}">
                <button id="loginp" type="button" class="btn btn-light"><a href="/login/sign-in">LOGIN</a></button>
            </c:if>
        </div>
    </div>
</header>
