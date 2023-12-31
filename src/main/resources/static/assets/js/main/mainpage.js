
const $creteBtn = document.getElementById('create-room');

const URL = '/mainpage';
(() => {
    // postList();
})()

// 게시글 조회 화면 렌더링
function postListRender(dtoList){
    const $postBody = document.getElementById('post-list-body');
    let tag = ``;
    for (const dto of `${dtoList}`) {
        tag +=`<div class="card room-post">
                        <div class="card-header">
                            <h2> ${dto.boardTitle}Title (${dto.currUser}/${dto.maxUser})</h2>
                            <div class="icon">
                                <svg id="modify" xmlns="http://www.w3.org/2000/svg"  fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                                    <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                                    <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5z"/>
                                </svg>
                                <svg id="delete" xmlns="http://www.w3.org/2000/svg"  fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                    <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z"/>
                                    <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z"/>
                                </svg>
                            </div>
                        </div>
                        <div class="card-body">
                            <p class="contents">content:${dto.boardContent}</p>
                            <div class="jcend">
                                <p class="card-text">작성자:${dto.nickname}</p>
                            </div>

                            <button class="btn btn-primary" type="submit">참여하기</button>
                        </div>
                    </div>`
    }
    $postBody.innerHTML = tag;
}

// 게시글 비동기 처리
function postList(){
    fetch(`${URL}`)
        .then(dto=> dto.json())
        .then(dtoList =>
            postListRender(dtoList)
        )
}

// 수정 비동기 처리
function updateBoard(bno){
    console.log(bno)
    const requestInfo = {
        method : 'DELETE',
    }
    fetch(`${URL}/${bno}`,requestInfo)
        .then(res => res.json())
        .then(boardList => {
            postListRender(boardList)
        })
}


const $deleteModal = new bootstrap.Modal(document.getElementById('delete-modal'), {keyboard: false})
const $postBody = document.getElementById('post-list-body')
const $okDelete = document.getElementById('delete-Btn');

const myModalEl = document.getElementById('delete-modal')


// 모달창이 뜨고 나서 실행할 코드
myModalEl.addEventListener('shown.bs.modal', function (e) {
    //relatedTarget : 모달을 열기전 클릭한 타켓
    const targetClass =e.relatedTarget.getAttribute('class');
    if(targetClass !== 'trash' && targetClass !== 'bi-trash' ) return

    myModalEl.dataset.dataBno = e.relatedTarget.closest('.room-post').dataset.bno
})

// 삭제 모달에서 삭제버튼 클릭시
$okDelete.onclick = () =>{
    const bno = myModalEl.dataset.dataBno;
    $deleteModal.hide()
    updateBoard(bno);
}

// 수정 버튼 클릭시
const $modifyBtn = document.getElementById('update-Btn');
$modifyBtn.addEventListener('click',()=>{
    //수정 비동기 처리
})

// 방 만들기 클릭시
$creteBtn.addEventListener('click',()=>{
    window.location.href = '/board'
})