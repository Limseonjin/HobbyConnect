<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>WEB STUDY</title>
    <link rel="stylesheet" href="./board/board.css">
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
<div class="container">
    <div class="row">
        <table class="table1">
            <tbody>
            <tr>
                <td align="left" bgcolor="skyblue">댓글</td>
            </tr>
            <tr>
                <div class="container">
                    <div class="row">
                        <table class="table2" >
                            <tbody>
                            <tr>
                                <td align="left"></td>
                                <td align="right"></td>
                            </tr>
                            <tr>
                                <td align="left"></td>
                                <td align="right">
                                    <a href="#>"class=" btn btn u"> 수정 </a>
                                    <a href="#" class="btn btn d"> 삭제 </a>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </tr>
        </table>
    </div>
</div>
<br>
<div class="container">
    <div class="row">
        <form method="post">
            <table class="table3">
                <tbody>
                <tr>
                    <td align="left"></td>
                </tr>
                <tr>
                    <td><input type="text" class="form-control" laceholder="댓글 쓰기" name="commentContent" maxlength="300"></td>
                </tr>
                </tbody>
            </table>
            <input type="submit" class="btn btn s" value="댓글 쓰기">
        </form>
    </div>
</div>
</div>
</div>
</body>
</html>