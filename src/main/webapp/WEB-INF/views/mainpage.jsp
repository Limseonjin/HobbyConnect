<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>MAIN</title>

    <%@include file="common/static-head.jsp"%>
    <%-- 필요한 css나 js 선언   --%>
    <link rel="stylesheet" href="/assets/css/mainpage/main.css">

    <script src="/assets/js/main/mainpage.js" defer></script>

</head>
<body>
<div id="delete-modal" class="modal" tabindex="-1" >
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">정말 삭제 하시겠습니까?</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <p>삭제하면 되돌릴 수 없습니다.</p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button id="delete-Btn" type="button" class="btn btn-primary">Delete</button>
            </div>
        </div>
    </div>
</div>
<div id="update-modal" class="modal" tabindex="-1" >
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">게시글 수정</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="input-group flex-nowrap">
                    <span class="input-group-text" id="update-board-title">제목</span>
                    <input type="text" class="form-control" name="boardTitle" placeholder="Title" aria-label="Username" aria-describedby="addon-wrapping">
                </div>
                <div class="input-group flex-nowrap">
                    <span class="input-group-text" id="update-board-content">내용</span>
                    <input type="text" class="form-control" name="boardContent" placeholder="Content" aria-label="Content" aria-describedby="addon-wrapping">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button id="update-Btn" type="button" class="btn btn-primary">Update</button>
            </div>
        </div>
    </div>
</div>
<%@include file="common/head.jsp"%>

<%-- 여기서 부터 코드 입력 --%>
<div id="main-wrapper">
<%--       서치와 간단 프로필 --%>
   <div id="main-head">
       <div id="serch" class="input-group mb-3">
           <input type="text" class="form-control" placeholder="Recipient's username" aria-label="Recipient's username" aria-describedby="button-addon2">
           <button class="btn btn-outline-secondary" type="button" id="button-addon2">검색</button>
       </div>
       <div class="card" style="width: 18rem;">
           <div class="card-body">
               <h2 class="card-title">어서오세요 ${nickName}님!</h2>
               <a href="/mypage/board" class="card-link">My Page</a>
               <a href="/login/sign-out" class="card-link">Logout</a>
           </div>
       </div>
   </div>
<%--       게시글 목록들 --%>
    <div id="main-body">
        <button id="create-room" type="button" class="btn btn-warning">방 만들기</button>
        <div id="post-list" class="card">
            <div id="post-list-body" class="card-body">
<%--                <c:forEach var="b" items="${bList}">--%>
                    <div class="card room-post">
                        <div class="card-header">
                            <h2> ${b.boardTitle}Title (${currUser}/${maxUser})</h2>
                            <div class="icon">
                                <button id="modify" data-bs-toggle="modal"  data-bs-target="#update-modal">
                                    <svg xmlns="http://www.w3.org/2000/svg"  fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                                        <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                                        <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5z"/>
                                    </svg>
                                </button>
                                <button id="trash" data-bs-toggle="modal"  data-bs-target="#delete-modal">
                                    <svg xmlns="http://www.w3.org/2000/svg"  fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                        <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z"/>
                                        <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z"/>
                                    </svg>
                                </button>
                            </div>
                        </div>
                        <div class="card-body">
                            <p class="contents">content:${b.boardContent}</p>
                            <div class="jcend">
                                <p class="card-text">작성자:${nickname}</p>
                            </div>

                            <button class="btn btn-primary" type="submit">참여하기</button>
                        </div>
                    </div>
<%--                </c:forEach>--%>
            </div>
        </div>
    </div>
<%--    페이지 번호 --%>
    <nav id="page-num" aria-label="Page navigation example">
        <ul class="pagination">
            <li class="page-item">
                <a class="page-link" href="#" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item"><a class="page-link" href="#">4</a></li>
            <li class="page-item"><a class="page-link" href="#">5</a></li>
            <li class="page-item">
                <a class="page-link" href="#" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </ul>
    </nav>
</div>

<%@include file="common/footer.jsp"%>
</body>
<script>
    const myModal = document.getElementById('delete-modal')
    const $delBtn = document.getElementById('trash')
    console.log($delBtn)

    function delBtnHandler() {
        myModal.classList.remove('non');
    }
    // 쓰레기통 버튼 클릭시 모달창 띄우기
    // $delBtn.addEventListener('click',delBtnHandler)
</script>
</html>