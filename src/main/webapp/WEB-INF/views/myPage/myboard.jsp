<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>마이페이지</title>

    <%@ include file="../common/static-head.jsp"%>
    <link rel="stylesheet" href="/assets/css/common.css">
    <link rel="stylesheet" href="/assets/css/head.css">
    <link rel="stylesheet" href="/assets/css/footer.css">
    <link rel="stylesheet" href="/assets/css/myPage/mainpage.css">

</head>
<body>
    <%@include file="../common/head.jsp"%>
    <div class="page-wrapper">
        <div id="mypage-side-bar">
            <div id="userInfo">
                <div class="card border-secondary mb-3" style="width: 18rem;">
                    <div class="card-body">
                        <p class="card-text">닉네임 : <sapn>nickName</sapn></p>
                        <p class="card-text">personId</p>
                        <p class="card-text">한줄소개</p>
                    </div>
                </div>

            </div>
            <div id="mypage-side-menu">
                <div class="card border-secondary mb-3" style="width: 18rem;">
                    <div class="card-body">
                        <ul class="category">나의 활동
                            <li>참여중인 방</li>
                            <li>내가 쓴 글</li>
                            <li>내가 쓴 댓글</li>
                        </ul>
                        <div class="line"></div>
                        <ul class="category">회원정보
                            <li>회원정보 수정</li>
                            <li>회원정보 삭제</li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>

        <div class="activies">
            <button id="room-list" type="button" class="btn btn-light">참여중인 방 </button>
            <button id="board-list" type="button" class="btn btn-light">내가 쓴 글</button>
            <button id="reply-list" type="button" class="btn btn-light">내가 쓴 댓글</button>
            <div class="active-list-wrapper">
                <div class="card border-secondary mb-3">
                    <div class="card-body">
<%--                       게시글 생성 jstl --%>
<%--                        <c:forEach var="b" items="${bList}">--%>
<%--                            <div class="mypage-board card border-secondary mb-3" >--%>
<%--                                <div class="card-body board-wrapper">--%>
<%--                                    <div class="title">--%>
<%--                                        <p>boardTitle</p>--%>
<%--                                    </div>--%>
<%--                                    <div class="other">--%>
<%--                                        <p>작성자 : nickname</p>--%>
<%--                                        <p>조회수 : viewCount</p>--%>
<%--                                    </div>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                        </c:forEach>--%>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <%@include file="../common/footer.jsp"%>
</body>
</html>