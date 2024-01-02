<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="mypage-side-bar">
    <div id="userInfo">
        <div class="card border-secondary mb-3" >
            <div class="card-body">
                <p class="card-text">닉네임 : ${login.nickname}</p>
                <p class="card-text">아이디 : ${m.personId}</p>
                <p class="card-text">한줄소개 : ${m.introduction}</p>
            </div>
        </div>

    </div>
    <div id="mypage-side-menu">
        <div class="card border-secondary mb-3">
            <div class="row">
                <div >
                    <nav id="navbar-example3" class="h-100 flex-column align-items-stretch pe-4 border-end">
                        <nav class="nav nav-pills flex-column">
                            <a class="nav-link" href="#item-1">나의 활동</a>
                            <nav class="nav nav-pills flex-column">
                                <a class="nav-link ms-3 my-1" href="/mypage/room">참여중인 방</a>
                                <a class="nav-link ms-3 my-1" href="/mypage/board">내가 쓴 글</a>
                                <a class="nav-link ms-3 my-1" href="/mypage/reply">내가 쓴 댓글</a>
                            </nav>
                            <a class="nav-link" href="#item-3">회원 정보</a>
                            <nav class="nav nav-pills flex-column">
                                <a class="nav-link ms-3 my-1" href="/mypage/info">회원정보 수정</a>
                                <a class="nav-link ms-3 my-1" href="/mypage/del">회원정보 삭제</a>
                            </nav>
                        </nav>
                    </nav>
                </div>
            </div>
        </div>
    </div>
</div>