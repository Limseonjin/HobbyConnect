
const $modifyBtn = document.getElementById('board-modity');
const $replyAddBtn = document.getElementById('add-reply');
const $inputReply = document.getElementById('comment-area')
const $replyDelBtn = document.getElementById('delete-Btn')
const $deleteModal = new bootstrap.Modal(document.getElementById('delete-modal'), {keyboard: true})
const deleteModalEl = document.getElementById('delete-modal')
const $boardDelBtn = document.getElementById('board-delete')
const BOARD_NO = document.querySelector('.form-1').dataset.bno
const URL = `/room/board/detail`;
(()=>{
    replyList(BOARD_NO)
})()

/** 댓글을 화면에 렌더링 하는 함수*/
function replyRender({replies}){
    let tag = ``;
    for (const r of replies) {
        tag +=`
        <li class="comment" data-rno="${r.replyId}">
            <div class="reply-wrap">
                <div class="author">${r.personId}</div>
                <p class="reply-content">${r.content}</p>
            </div>
            <div class="reply-btn-wrap">
                <button type="button" class="reply-modify btn-comment-up">수정</button>
                <button type="button" class="reply-delete btn-comment-delete" data-bs-toggle="modal"  data-bs-target="#delete-modal">
                    삭제</button>
            </div>
        </li>`
    }
    document.querySelector('.comments').innerHTML=tag
    const $reply = document.querySelectorAll(...['.comment']);
    // 댓글 클릭시
    $reply.forEach(r => r.addEventListener('click',
        modifyReplyClickHandler))
}

/** 댓글 조회 비동기 처리 */
function replyList(boardId){
    console.log(boardId)
    fetch(`${URL}/${boardId}`)
        .then(res => res.json())
        .then(r =>{
            console.log(r)
            replyRender(r)
        })
}

/** 댓글 등록 비동기 처리 */
function replyAddList(){
    console.log(document.getElementById('comment-area').value)
    const payload = {
        'boardId' : BOARD_NO ,
        'content' : $inputReply.value
    }
    const reqInfo = {
        method : 'POST',
        headers : {
            'content-type' : 'application/json'
        },
        body : JSON.stringify(payload)
    }
    fetch(`${URL}/insert`,reqInfo)
        .then(res => res.json())
        .then(r =>{
            console.log(r)
            replyRender(r)
        })
}
/** 댓글 수정 비동기 처리 */
function replyUpdateList(newComment,rno){
    console.log('replyUpdateList : '+rno)
    const payload = {
        'replyId' : rno,
        'content' : newComment,
        'boardId' : BOARD_NO
    }
    const reqInfo = {
        method : 'PUT',
        headers : {
            'content-type' : 'application/json'
        },
        body : JSON.stringify(payload)
    }
    fetch(`${URL}/${rno}/update`,reqInfo)
        .then(res => res.json())
        .then(r =>{
            console.log(r)
            replyRender(r)
        })
}
/** 댓글 삭제 비동기 처리 */
function replyDeleteList(rno){
    const reqInfo = {
        method : 'DELETE'
    }
    fetch(`${URL}/${rno}`,reqInfo)
        .then(res => res.json())
        .then(r =>{
            console.log(r)
            replyRender(r)
        })
}


/** 댓글 수정 버튼을 누르면 p태그가 input으로 바뀌는 js코드 */

function editComment($comment,rno,$replyBtnWrap) {
    const commentText =$comment.innerText;
    const $parentElement = $comment.parentElement;

    const $inputElement = document.createElement('input');
    $inputElement.type = 'text';
    $inputElement.classList.add('form-control')
    $inputElement.value = commentText;

    // Create a button element
    const $buttonElement = document.createElement('button');
    $buttonElement.type = 'button';
    $buttonElement.textContent = '저장';
    $buttonElement.classList.add('reply-save');
    $buttonElement.classList.add('btn-comment-up');
    // Replace the paragraph element with the input element
    $parentElement.replaceChild($inputElement, $comment);
    $parentElement.appendChild($buttonElement);
    $replyBtnWrap.classList.add('non');

    $inputElement.focus();

    // Change the event listener of the "수정" button to save the changes
    const modifyButton = $parentElement.querySelector('.reply-save');
    modifyButton.onclick = function () {
        saveChanges($inputElement,$buttonElement,rno);
        $replyBtnWrap.classList.remove('non')
    };
}

/** 수정된 댓글 내용 저장하기 */
function saveChanges($inputElement, $saveButton,rno) {
    const updatedText = $inputElement.value;

    // p태그 재 생성
    const $newParagraph = document.createElement('p');
    $newParagraph.classList.add('reply-content');
    $newParagraph.dataset.rno = rno
    $newParagraph.innerText = updatedText;

    //input 태그 원래 태그로 바꾸기
    $inputElement.parentElement.replaceChild($newParagraph, $inputElement);
    $saveButton.remove();

    replyUpdateList(updatedText,rno)
}
/** 댓글 수정 버튼 클릭 핸들러 */
function modifyReplyClickHandler(e) {
    const rno = e.target.closest('.comment').dataset.rno;
    const $replyBtnWrap = e.target.closest('.reply-btn-wrap')
    if (e.target.classList.contains('reply-modify')){ //수정 버튼 클릭시 실행
        const $replyContent = e.target.closest('.comment').querySelector('.reply-content');
        editComment($replyContent,rno,$replyBtnWrap)
    }
    else if (e.target.classList.contains('reply-delete')){ //삭제 버튼 클릭시 실행

    }
}
// 댓글 추가 이벤트 핸들러
function replyaddClickHandler(e) {
    replyAddList()
    $inputReply.value = ''

}


// 댓글 추가 클릭시
$replyAddBtn.addEventListener('click',
    replyaddClickHandler)

// 게시글 수정 버튼 클릭시
$modifyBtn.addEventListener('click',function modifyBtnOnClick(){
    window.location.href = `/room/board/detail/write?boardId=${boardId}`
})

//삭제 모달창이 뜨고 나서 실행할 코드
deleteModalEl.addEventListener('shown.bs.modal', function (e) {
    //relatedTarget : 모달을 열기전 클릭한 타켓
    const targetClass =e.relatedTarget.getAttribute('class');
    if(targetClass !== 'reply-delete btn-comment-delete') return
    deleteModalEl.dataset.rno = e.relatedTarget.closest('.comment').dataset.rno
})

// 댓글 삭제 모달에서 삭제버튼 클릭시
$replyDelBtn.addEventListener('click', () =>{
    console.log('클릭은 됏슈')
    const rno = deleteModalEl.dataset.rno
    $deleteModal.hide()
    replyDeleteList(rno)

})