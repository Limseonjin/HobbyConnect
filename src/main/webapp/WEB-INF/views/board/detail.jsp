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
<header>
    <div class="hero">
        <h1>Bulletin Board</h1>
<%--        <form class="btnc">--%>
<%--            <input class='write-6' type="submit" value="BACK" onclick="confirmBack()">--%>
<%--        </form>--%>
    </div>
    <p class="note">"It's HOBBY CONNECT with you.
        Feel free to share your opinions,<br> share news,
        ask questions, and participate in event notifications and more!"</p>
</header>
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
    <ol class="comments">
        <li class="comment">
            <div class="comment-text">
                <div class="author">Susan Sanddollar</div>
                <p>Lorem ipsum dolor sit amet</p>

                <button type="button" class="btn-comment-up" onclick="editComment()">수정</button>
                <button type="button" class="btn-comment-delete">삭제</button>
            </div>
        </li>
        <li class="comment">
            <div class="comment-text">
                <div class="author">Susan Sanddollar</div>
                <p>Lorem ipsum dolor</p>

                <button type="button" class="btn-comment-up" onclick="editComment()">수정</button>
                <button type="button" class="btn-comment-delete">삭제</button>
            </div>
        </li>
    </ol>
</div>
<script>
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
    // 댓글 수정 버튼을 누르면 p태그가 input으로 바뀌는 js코드
    function editComment() {
        // 현재 댓글 텍스트를 가져옵니다.
        const commentText = document.getElementById('commentText').innerText;

        // 새로운 input 엘리먼트를 생성합니다.
        const inputElement = document.createElement('input');
        inputElement.type = 'text';
        inputElement.value = commentText;

        // <p> 태그를 input 엘리먼트로 교체합니다.
        document.getElementById('commentText').replaceWith(inputElement);

        // 사용자 편의를 위해 input에 포커스를 맞춥니다.
        inputElement.focus();

        // "수정" 버튼 클릭 이벤트를 변경하여 변경 사항을 저장합니다.
        document.querySelector('.btn-comment-up').onclick = saveChanges;
    }

    function saveChanges() {
        // input의 값을 가져옵니다.
        const updatedComment = document.querySelector('input').value;

        // 업데이트된 댓글이 담긴 새로운 <p> 태그를 생성합니다.
        const newParagraph = document.createElement('p');
        newParagraph.innerText = updatedComment;

        // input 엘리먼트를 새로운 <p> 태그로 교체합니다.
        document.querySelector('input').replaceWith(newParagraph);

        // "수정" 버튼 클릭 이벤트를 다시 편집 모드로 변경합니다.
        document.querySelector('.btn-comment-up').onclick = editComment;
    }
</script>
</body>
</html>