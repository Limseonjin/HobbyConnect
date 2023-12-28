<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header id="head">
    <div class="logo-wrapper">
        <div class="logo">
            <img src="/assets/img/0.png" width="300" height="150">
        </div>
        <div id="head-btn" class="btn btn-wrap">
            <c:if test="${not empty login}">
                <button type="button" class="btn btn-light">LOGOUT</button>
                <button type="button" class="btn btn-light">MY PAGE</button>
            </c:if>
            <c:if test="${empty login}">
                <button type="button" class="btn btn-light">LOGIN</button>
            </c:if>
        </div>
    </div>
</header>
