
const $userReply = document.querySelectorAll(...['.comment']);
const $replyBtnWrap = document.querySelector(".reply-btn-wrap")
// 댓글 수정 버튼을 누르면 p태그가 input으로 바뀌는 js코드
function editComment(comment) {
    const commentText = comment.innerText;
    const parentElement = comment.parentElement;

    const inputElement = document.createElement('input');
    inputElement.type = 'text';
    inputElement.classList.add('form-control')
    inputElement.value = commentText;

    // Create a button element
    const buttonElement = document.createElement('button');
    buttonElement.type = 'button';
    buttonElement.textContent = '저장';
    buttonElement.classList.add('reply-save');
    buttonElement.classList.add('btn-comment-up');

    console.log(inputElement)
    // Replace the paragraph element with the input element
    parentElement.replaceChild(inputElement, comment);
    parentElement.appendChild(buttonElement);
    $replyBtnWrap.classList.add('non');

    inputElement.focus();

    // Change the event listener of the "수정" button to save the changes
    const modifyButton = parentElement.querySelector('.reply-save');
    modifyButton.onclick = function () {
        saveChanges(inputElement, comment,buttonElement);
        $replyBtnWrap.classList.remove('non')
    };
}

/** 수정된 댓글 내용 저장하기 */
function saveChanges(inputElement, commentParagraph, saveButton) {
    const updatedText = inputElement.value;

    // Create a new paragraph element with the updated text
    const newParagraph = document.createElement('p');
    newParagraph.classList.add('reply-content');
    newParagraph.innerText = updatedText;

    // Replace the input element and remove the save button
    inputElement.parentElement.replaceChild(newParagraph, inputElement);
    saveButton.remove();
}
// 댓글 수정 버튼 클릭시
function modifyReplyClickHandler(e) {
    if (!e.target.classList.contains('reply-modify')) return;
    console.log(e.target)
    const $replyContent = e.target.closest('.comment').querySelector('.reply-content');
    editComment($replyContent)

}

$userReply.forEach(r => r.addEventListener('click',
    modifyReplyClickHandler))