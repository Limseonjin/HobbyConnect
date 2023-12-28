<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="mypage-side-bar">
    <div id="userInfo">
        <div class="card border-secondary mb-3" style="width: 18rem;">
            <div class="card-body">
                <p class="card-text">닉네임 : <sapn>${nickName}</sapn></p>
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