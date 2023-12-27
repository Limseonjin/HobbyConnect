<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>

    <link rel="stylesheet" href="/static/assets/css/head.css">
    <%@ include file="static-head.jsp"%>

</head>
<body>
    <header>
        <div class="logo-wrapper">
            <a href="#"></a>
        </div>
        <div class="btn btn-wrap">
            <button>로그인</button>
            <button>로그아웃</button>
        </div>
    </header>
    <button type="button" class="btn btn-primary">Primary</button>
    <button type="button" class="btn btn-secondary">Secondary</button>
    <button type="button" class="btn btn-success">Success</button>
    <button type="button" class="btn btn-danger">Danger</button>
    <button type="button" class="btn btn-warning">Warning</button>
    <button type="button" class="btn btn-info">Info</button>
    <button type="button" class="btn btn-light">Light</button>
    <button type="button" class="btn btn-dark">Dark</button>

    <button type="button" class="btn btn-link">Link</button>
</body>
</html>