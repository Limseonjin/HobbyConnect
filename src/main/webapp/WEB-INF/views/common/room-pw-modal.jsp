<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="room-pw-modal" class="modal" data-bno=0 tabindex="-1" >
    <div class="modal-dialog">
        <div class="modal-content">
            <form class="row g-3 needs-validation" novalidate>
                <div class="modal-header">
                    <h5 class="modal-title">방 비밀번호를 입력하세요</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                        <div class="col-md-4">
                            <label for="validationCustom01" class="form-label">암호</label>
                            <input type="text" class="form-control input-room-pw" id="validationCustom01" name="roomPw" value="" required>
                            <div class="invalid-feedback">
                                틀렸습니다
                            </div>
                        </div>

                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
                    <button id="forward-room-Btn" type="submit" class="btn btn-primary">입장</button>
                </div>
            </form>
        </div>
    </div>
</div>