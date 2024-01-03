<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>MAIN</title>

    <%@include file="common/static-head.jsp" %>
    <%-- 필요한 css나 js 선언   --%>
    <link rel="stylesheet" href="/assets/css/mainpage/main.css">
    <link rel="stylesheet" href="/assets/css/board/boardList.css">
    <script src="/assets/js/main/mainpage.js" defer></script>
</head>
<body>

<%@include file="common/del-modal.jsp"%>
<%@include file="common/mod-modal.jsp"%>
<%@include file="common/head.jsp"%>
<%-- 여기서 부터 코드 입력 --%>
<div id="main-wrapper">
    <%--       서치와 간단 프로필 --%>
    <div id="search-head">
        <nav id="search" class="navbar navbar-light bg-light">
            <div class="container-fluid">
                <form action="/serch" class="d-flex">
                    <select class="type-select form-select form-select-lg">
                        <option value="findByTitle" selected>제목</option>
                        <option value="content">내용</option>
                        <option value="findByPersonId">작성자</option>
                    </select>
                    <input id="search-content" class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                    <button id="search-btn" class="btn btn-outline-success" type="submit">Search</button>
                </form>
            </div>
        </nav>
    </div>
    <%--     게시글 목록들 --%>
    <div id="main-body">
        <div id="post-list" class="card">
            <div id="post-list-body" class="card-body">
<%--               js 비동기 처리 --%>
            </div>
        </div>
        <%--    페이지 번호 --%>
        <nav id="page-num" aria-label="Page navigation example">
            <ul class="pagination">
                <li class="page-item">
                    <a class="page-link" href="#" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item"><a class="page-link" href="#">4</a></li>
                <li class="page-item"><a class="page-link" href="#">5</a></li>
                <li class="page-item">
                    <a class="page-link" href="#" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>
</div>
<%@include file="common/footer.jsp" %>

</body>
</html>