<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>마이페이지</title>
    <link rel="stylesheet" type="text/css" href="/assets/css/mypage/mainpage.css">

    <%@include file="../common/static-head.jsp"%>
    <%-- 필요한 css나 js 선언   --%>
</head>
<body>
<%@include file="../common/head.jsp"%>
<%-- 여기서 부터 코드 입력 --%>
<div class="page-wrapper">
    <%@include file="side-menu.jsp"%>
    <div id="form-wrapper">
        <h2> 회원 삭제 </h2>
        <p> 회원님의 모든 방과 게시물, 댓글이 삭제됩니다</p>
        <p> 정말 삭제하시겠습니까?</p>
        <div>
            <button id="person-del" type="button" class="btn btn-primary">삭제</button>
        </div>
    </div>
</div>
<%@include file="../common/footer.jsp"%>
<script>
    const $personDeleteBtn = document.getElementById('person-del')
    $personDeleteBtn.onclick = () =>{
        window.location.href = '/mypage/deleteCon'
    }
</script>
</body>
</html>