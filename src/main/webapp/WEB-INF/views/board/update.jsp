<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>BBS Update</title>
    <%@include file="../common/static-head.jsp"%>
    <style>
        <%--수정 폼 디자인--%>
        body {
            font-family: Arial, sans-serif;

        }
        /* 수정 창 전체를 감싸는 div의 스타일 */
        .conf {
            max-width: 600px;
            margin: 20px auto;
            padding: 20px;
            border: 3px solid #E0E6F8;
            border-radius: 8px;
            position: relative;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.5);
            background: aliceblue;
        }
        /* 입력 요소의 공통 스타일 */
        .fcon {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
            border-radius: 10px;
            border: 5px solid #A9D0F5;
            box-sizing: border-box;
            resize: none;
        }
        /* 테이블 스타일 */
        .tab {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 15px;

        }
        /* 테이블 헤더 스타일 */
        .tab th {
            background-color: #f2f2f2;
            padding: 10px;
            text-align: center;
        }

        /* 테이블 셀 스타일 */
        .tab td {
            padding: 10px;

        }
        .tab th:first-child,
        .tab td:first-child {
            padding-bottom: 15px;

        }
        /* 버튼 그룹 스타일 */
        .btn-group {
            margin-top: 20px;
            text-align: center;
        }
        /* 버튼 스타일 */
        .btn-default {
            background-color: #01DF3A;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        /* 버튼 호버 효과 */
        .btn-default:hover {
            background-color: #04B431;
        }

        .btn-default2 {
            background-color: #FA5858;
            color: #fff;
            padding: 10px 15px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        /* 버튼 호버 효과 */
        .btn-default2:hover {
            background-color: #DF0101;
        }
    </style>
</head>
<%--폼 메인 코드--%>
<body>
<%@ include file="../room/room-head.jsp"%>
<form action="/room/board/modify" method="post">
    <div class="conf">
        <input type="hidden" name="pageNum" value="#">
        <input type="hidden" name="artNum" value="#">
        <div class="ing" role="group" aria-label="...">
            <table class="tab">
                <thead>
                <tr>
                    <th>제목</th>
                    <td><input type="text" name="boardTitle" value="${b.boardTitle}" class="fcon" aria-describedby="basic-addon1"></td>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td colspan="2">
                        <textarea class="fcon" rows="20" name="boardContent">${b.boardContent}</textarea>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
        <input id="roomid" type="hidden" name="roomId" value=${roomId}>
        <input id="boardid" type="hidden" name="boardId" value=${boardId}>
        <div class="btn-group" role="group" aria-label="...">
            <input type="submit" class="btn-default" value="수정하기">
            <input type="button" class="btn-default2" onclick="confirmCancel()" value="취소하기">
        </div>
    </div>
</form>

<%@include file="../common/footer.jsp"%>
<script>
    const ROOM_ID = document.getElementById('roomid').value;
    const BOARD_ID = document.getElementById('boardid').value;
    function confirmCancel() {
        window.location.href=`/room/board/detail?roomId=\${ROOM_ID}&boardId=\${BOARD_ID}`
    }
</script>
</body>
</html>