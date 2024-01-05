<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Comment</title>
    <link rel="stylesheet" href="/assets/css/board/board.css">
</head>
<body>
    <form> <input class='write-5' type="submit" value="BACK" onclick="confirmBack()">
    </form>
    <div class="hero">
        <h1>Bulletin Board</h1>
    </div>
    <p class="note">Note: Best view in Desktop</p>
<div class='form-0'>
    <div class="board-top">
        <form class='form-1' method="POST"  enctype="multipart/form-data">
            <input class='write-1' type="text" name="title" maxlegth="44"
                   placeholder="제목 입력, 최대 44자까지 가능합니다" required>
            <textarea class='write-2' name="detail" rows="20"
                      cols="20" maxlength="254" placeholder="내용 작성,최대 254자 가능합니다" required>
            </textarea>
            <input class='write-4' type="submit" value="UPLOAD" onclick="showUploadAlert()" >
        </form>

    </div>
</div>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<hr>
<%--<input type="submit" value="댓글 목록">--%>
<h2>댓글 작성</h2>
<form method="post" action="">
    <textarea name="comment" rows="4" cols="50" placeholder="댓글을 작성하세요">
    </textarea><br>
    <input type="submit" value="댓글 등록">
<%--    <input type="submit" value="댓글 삭제">--%>
</form>
<%--댓글 띄우는 코드--%>
<div>
    <h3>댓글</h3>
    <ul class="commentList">
        <!-- 댓글 목록이 표시되는 부분 -->
<%--<!--<c:forEach var="comment" items="${commentList}">-->--%>
        <li>
            <p><strong> 지나가던 행인 입니다. 맞팔 해염^^<!-- 여기에 댓글 작성자를 표시하는 코드를 넣으세요 --></strong>
                <!-- 여기에 댓글 내용을 표시하는 코드를 넣으세요 --></p>
            <button type="button" class="btn-comment-up">수정</button>
            <button type="button" class="btn-comment-delete">삭제</button>
            <div>
                <!--댓글 날짜 조회 ex : yyyy-mm-dd a hh:mm(2024-01-03 오후 01:55분)-->
                작성일자 : <>
            </div>
        </li>
        <!-- <%--</c:forEach>--%>-->
    </ul>
</div>
<div>
    <ul class="commentList">
        <!-- 댓글 목록이 표시되는 부분 -->
        <%--<!--<c:forEach var="comment" items="${commentList}">-->--%>
        <li>
            <p><strong>게시물 잘 보고 가염 8^^8 오늘 하루도 좋은 날이 되세염 ~!!<!-- 여기에 댓글 작성자를 표시하는 코드를 넣으세요 --></strong>
                <!-- 여기에 댓글 내용을 표시하는 코드를 넣으세요 --></p>
            <button type="button" class="btn-comment-up">수정</button>
            <button type="button" class="btn-comment-delete">삭제</button>
            <div>
                <!--댓글 날짜 조회 ex : yyyy-mm-dd a hh:mm(2024-01-03 오후 01:55분)-->
                작성일자 : <>
            </div>
        </li>
        <!-- <%--</c:forEach>--%>-->
    </ul>
</div>

<div>
    <ul class="commentList">
        <!-- 댓글 목록이 표시되는 부분 -->
        <%--<!--<c:forEach var="comment" items="${commentList}">-->--%>
        <li>
            <p><strong>새로운 마음 가짐으로 맨날 봐요 ㅎㅎㅎ 맞팔 하실래여 ^^~<!-- 여기에 댓글 작성자를 표시하는 코드를 넣으세요 --></strong>
                <!-- 여기에 댓글 내용을 표시하는 코드를 넣으세요 --></p>
            <button type="button" class="btn-comment-up">수정</button>
            <button type="button" class="btn-comment-delete">삭제</button>
            <div>
                <!--댓글 날짜 조회 ex : yyyy-mm-dd a hh:mm(2024-01-03 오후 01:55분)-->
                작성일자 : <>
            </div>
        </li>
        <!-- <%--</c:forEach>--%>-->
    </ul>
</div>

<div>
    <ul class="commentList">
        <!-- 댓글 목록이 표시되는 부분 -->
        <%--<!--<c:forEach var="comment" items="${commentList}">-->--%>
        <li>
            <p><strong><!-- 여기에 댓글 작성자를 표시하는 코드를 넣으세요 --></strong>
                <!-- 여기에 댓글 내용을 표시하는 코드를 넣으세요 --></p>
            <button type="button" class="btn-comment-up">수정</button>
            <button type="button" class="btn-comment-delete">삭제</button>
            <div>
                <!--댓글 날짜 조회 ex : yyyy-mm-dd a hh:mm(2024-01-03 오후 01:55분)-->
                작성일자 : <>
            </div>
        </li>
        <!-- <%--</c:forEach>--%>-->
    </ul>
</div>

<script>
    function confirmBack() {
        const isConfirmed = confirm('돌아가시겠습니까? 작성된 내용이 사라집니다.');
        if (isConfirmed) {
            // 사용자가 확인을 눌렀을 때의 처리 로직을 추가하세요.
            // 예를 들어, 페이지 이동 등을 수행할 수 있습니다.
            window.location.reload();
        }
        // 사용자가 취소를 눌렀을 때는 아무 처리도 하지 않습니다.
    }

    function showUploadAlert() {
        // 폼에서 제목과 내용을 가져옵니다.
       const title = document.getElementsByName('title')[0].value.trim();
       const content = document.getElementsByName('detail')[0].value.trim();

        // 제목이나 내용 중 하나라도 비어있으면 알림을 띄우고 추가적인 처리를 하지 않습니다.
        if (title === '' || content === '') {
            alert('제목 또는 내용이 비어있습니다. 작성 후 등록해주세요.');
        } else {
            // 등록이 완료되었을 때의 알림을 띄우고 추가적인 처리 로직을 추가하세요.
            alert('등록이 완료되었습니다.');

            // 여기에 등록 완료 후 추가적인 처리 로직을 추가하세요.
        }
    }
</script>
</body>
</html>