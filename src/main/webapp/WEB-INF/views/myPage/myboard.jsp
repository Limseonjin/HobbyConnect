<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>마이페이지</title>

    <%@ include file="../common/static-head.jsp"%>
    <link rel="stylesheet" href="/assets/css/myPage/mainpage.css">

</head>
<body>
    <%@include file="../common/head.jsp"%>
    <div class="page-wrapper">
        <%@include file="./side-menu.jsp"%>

        <div class="activies">
            <button id="room-list" type="button" class="btn btn-light">참여중인 방 </button>
            <button id="board-list" type="button" class="btn btn-light">내가 쓴 글</button>
            <button id="reply-list" type="button" class="btn btn-light">내가 쓴 댓글</button>
            <div class="active-list-wrapper">
                <div class="card border-secondary mb-3">
                    <div class="card-body">
                        <div class="mypage-board card border-secondary mb-3" >
                            <div class="card-body board-wrapper">
                                <div class="title">
                                    <p>boardTitle</p>
                                    <p>boardContent</p>
                                </div>
                                <div class="other">
                                    <p>작성자 : nickname</p>
                                    <p>조회수 : viewCount</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <%@include file="../common/footer.jsp"%>
</body>
</html>