<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>WEB STUDY</title>
    <link rel="stylesheet" href="/assets/css/board/board.css">
</head>
<body>
<h1>COMMENT</h1>
<div class='form-0'>
    <div class="board-top">
        <form class='form-1' method="POST"  enctype="multipart/form-data">
            <input class='write-1' type="text" name="title" maxlegth="44"
                   placeholder="제목 입력, 최대 44자까지 가능합니다" required>
            <textarea class='write-2' name="detail" rows="20"
                      cols="20" maxlength="254" placeholder="내용 작성,최대 254자 가능합니다" required>
        </textarea>
            <input class='write-3' type="file" name="file" id="fileToUpload">
            <hr>
            <input class='write-4' type="submit" value="올리기">
        </form>
        <form>
            <input class='write-5' type="submit" value="돌아가기">
        </form>
    </div>
</div>
<br>
</body>
</html>