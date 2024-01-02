<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>WEB</title>
    <style>
        body{
            background-color: #FAFAFA;
        }
        h1{
            text-align: center;
            padding: 10px 10px;
            padding-bottom: 30px;
            border-bottom:1px solid #848484;
            font-family: 'Black Han Sans', sans-serif;
        }
        .board-top {
            width : 80%;
            height: 50px;
            margin: 0 auto;
            max-width: 100%;
        }
        .form-0{
            position: relative;
        }
        .form-1 {
            width : 80%;
            height: 50px;
            margin: 0 auto;
            max-width: 100%;
        }
        .write-1 {
            height: 50px;
            border : none;
            font-size: 40px;
            background-color: #f5f6f7;
            outline: none;
        }

        .write-2 {
            margin-top: 30px;
            font-size: 15px;
            border: none;
            background-color: #f5f6f7;
            outline: none;
        }

        .write-3 {
            margin-top: 10px;
        }

        .write-4 {
            margin-top: 10px;

            width: 70px;
            height: 30px;
            border: none;
            background-color: #f5f6f7;
            Cursor:pointer;
        }

        .write-5 {
            position: absolute;
            bottom: 0;
            left: 200px;
            width: 70px;
            height: 30px;
            border: none;
            background-color: #f5f6f7;
            Cursor:pointer;
        }
    </style>
</head>
<body>
<h1>COMMENT</h1>
<div class='form-0'>
    <div class="board-top">
        <form class='form-1' method="POST"  enctype="multipart/form-data">
            <input class='write-1' type="text" name="title" maxlegth="44"
                   placeholder="제목 입력, 최대 44자까지 가능합니다" required>
            <hr>
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
</body>
</html>