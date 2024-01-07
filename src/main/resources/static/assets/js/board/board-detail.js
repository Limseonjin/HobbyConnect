
const $reply = document.querySelectorAll(...['.comment']);
const $replyBtnWrap = document.querySelector(".reply-btn-wrap")
const $modifyBtn = document.getElementById('board-modity');
const $replyAddBtn = document.getElementById('add-reply');

const URL = `/room/board/detail/`;
(()=>{
    replyList()
})()

/** 댓글을 화면에 렌더링 하는 함수*/
function replyRender(replyList){
    let tag = ``;
    for (const r of replyList) {
        tag +=`
        <li class="comment" data-rno="${r.replyNo}">
            <div class="reply-wrap">
                <div class="author">${nickname}</div>
                <p class="reply-content">${r.content}</p>
            </div>
            <div class="reply-btn-wrap">
                <button type="button" class="reply-modify btn-comment-up">수정</button>
                <button type="button" class="reply-delete btn-comment-delete" data-bs-toggle="modal"  data-bs-target="#delete-modal">
                    삭제</button>
            </div>
        </li>`
    }
    document.querySelector('.comment').innerHTML=tag
}

/** 댓글 조회 비동기 처리 */
function replyList(){
    fetch(`${URL}`)
        .then(res => res.json())
        .then(r =>{
            console.log(r)
            replyRender(r)
        })
}

/** 댓글 등록 비동기 처리 */
function replyAddList(){
    const payload = {
        'content' : document.getElementById('comment-area').text
    }
    const reqInfo = {
        method : 'POST',
        headers : {
            'content-type' : 'application.json'
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
    const payload = {
        'content' : newComment
    }
    const reqInfo = {
        method : 'PUT',
        headers : {
            'content-type' : 'application.json'
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
    fetch(`${URL}/${rno}/delete`,reqInfo)
        .then(res => res.json())
        .then(r =>{
            console.log(r)
            replyRender(r)
        })
}


/** 댓글 수정 버튼을 누르면 p태그가 input으로 바뀌는 js코드 */

function editComment($comment,rno) {
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
    $newParagraph.innerText = updatedText;

    //input 태그 원래 태그로 바꾸기
    $inputElement.parentElement.replaceChild($newParagraph, $inputElement);
    $saveButton.remove();

    replyUpdateList(updatedText,rno)
}
/** 댓글 수정 버튼 클릭 핸들러 */
function modifyReplyClickHandler(e) {
    const rno = e.target.closest('.comment').dataset.rno;
    console.log(rno)
    if (e.target.classList.contains('reply-modify')){ //수정 버튼 클릭시 실행
        const $replyContent = e.target.closest('.comment').querySelector('.reply-content');
        editComment($replyContent,rno)
    }
    else if (e.target.classList.contains('reply-delete')){ //삭제 버튼 클릭시 실행
        replyDeleteList(rno)
    }
}
// 댓글 추가 이벤트 핸들러
function replyaddClickHandler(e) {
    replyAddList()
}
// 댓글 클릭시
$reply.forEach(r => r.addEventListener('click',
    modifyReplyClickHandler))

// 댓글 추가 클릭시
$replyAddBtn.addEventListener('click',
    replyaddClickHandler)

// 게시글 수정 버튼 클릭시
$modifyBtn.addEventListener('click',function modifyBtnOnClick(){
    window.location.href = `/room/board/detail/write?boardId=${boardId}`
})