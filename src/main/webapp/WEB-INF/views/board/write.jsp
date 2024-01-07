<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>WEB STUDY</title>
    <%@include file="../common/static-head.jsp"%>
    <link rel="stylesheet" href="/assets/css/board/form.css">
</head>
<body>
<%@include file="../common/head.jsp"%>
<div class="overlay">
    <form action="#" method="post">
        <div class="con">
            <header class="head-form">
                <h2>POST</h2>
                <p>자유롭게 게시판을 적어주세요 !</p>
            </header>
        </div>
        <div class="">
            <input class="i1" type="text" name="boardTitle" placeholder="제목을 적어주세요" >
        </div>

        <div>
             <textarea rows="5" cols="13" name="boardContent" class="t1" title="남을 비방하거나 허위 정보를 전파하거나 타인을 모욕하는 말은 사용자 간에 신뢰를 떨어뜨릴 뿐만 아니라 관련 법률에 의해 처벌받을 수 있습니다"></textarea>
        </div>
        <button class="writeForm" type="submit">완료</button>
    </form>
</div>
<%@include file="../common/footer.jsp"%>
<script>
    function checkAndSubmit(event) {
        // 제목과 게시물 내용을 가져오기
        const title = document.querySelector('.i1').value;
        const content = document.querySelector('.t1').value;

        if (title.trim() !== '' && content.trim() !== '') {
            // 완료 메시지 띄우기
            alert('게시물이 성공적으로 등록되었습니다.');
        } else {
            alert('제목과 내용을 모두 입력해주세요.');

            event.preventDefault();
        }
    }
</script>
</body>
</html>