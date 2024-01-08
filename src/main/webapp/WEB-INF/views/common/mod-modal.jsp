<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="update-modal" class="modal" data-bno=0 tabindex="-1" >
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">게시글 수정</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <div class="input-group flex-nowrap">
                    <span class="input-group-text" id="update-board-title">제목</span>
                    <input type="text" class="form-control update-board-title" name="boardTitle" placeholder="Title" aria-label="Username" aria-describedby="addon-wrapping">
                </div>
                <div class="input-group flex-nowrap">
                    <span class="input-group-text" id="update-board-content">내용</span>
                    <input type="text" class="form-control update-board-content" name="boardContent" placeholder="Content" aria-label="Content" aria-describedby="addon-wrapping">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                <button id="update-Btn" type="button" class="btn btn-primary">Update</button>
            </div>
        </div>
    </div>
</div>