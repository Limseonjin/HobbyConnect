
const $creteBtn = document.getElementById('create-room');
const $searchInput = document.getElementById('search-content');
const $searchType = document.getElementById('search-type')
const URL = '/api/v1/mainBoards';
const SEARCH_URL = '/api/mainboard';
(() => {
    postList();
})()

// 게시글 조회 화면 렌더링
function postListRender(dtoList){
    console.log(dtoList)
    const $postBody = document.getElementById('post-list-body');
    let tag = ``;
    for (const dto of dtoList) {
        tag +=`<div class="card room-post" data-bno="${dto.mainBoardId}">
                        <div class="card-header">
                       
                            <h2>`
        if(dto.roomPw !== null){
            tag +=  `<span class="lnr lnr-lock"></span>`
        }

                            tag +=`${dto.mainBoardTitle}Title (${dto.currUser}/${dto.maxUser})</h2>
                             <div class="icon">
                            <button class="modify" data-bs-toggle="modal"  data-bs-target="#update-modal">
                                <svg xmlns="http://www.w3.org/2000/svg"  fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                                    <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                                    <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5z"/>
                                </svg>
                            </button>
                            <button class="trash" data-bs-toggle="modal"  data-bs-target="#delete-modal">
                                <svg xmlns="http://www.w3.org/2000/svg"  fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                    <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z"/>
                                    <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z"/>
                                </svg>
                            </button>
                        </div>
                        </div>
                        <div class="card-body">
                            <p class="contents">content:${dto.mainBoardContent}</p>
                            <div class="jcend">
                                <p class="card-text">작성자:${dto.personId}</p>
                            </div>

                            <button class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#room-pw-modal" type="button">참여하기</button>
                        </div>
                    </div>`
    }
    $postBody.innerHTML = tag;
}

//
function replyRender(boards){
    let tag = ``;
    if (prev){
        tag += `<li className="page-item">
            <a className="page-link" href="#" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>`
    }
    for (let i = begin; i < prev; i++) {
       tag += `<li className="page-item"><a className="page-link" href="#">${i}</a></li>`
    }
    //
    // <li className="page-item">
    //     <a className="page-link" href="#" aria-label="Next">
    //         <span aria-hidden="true">&raquo;</span>
    //     </a>
    // </li>
}

// 게시글 비동기 처리
function postList(){
    fetch(`${URL}/main`)
        .then(res=>res.json())
        .then(dtoList =>
            postListRender(dtoList)
        )
}

// 검색시 게시글 비동기 처리
function SearchPostList(type,input){
    fetch(`${SEARCH_URL}/${type}/${input}`)
        .then(res=> res.json())
        .then(dtoList =>
            postListRender(dtoList)
        )
}

//수정 비동기 처리
function updateBoard(bno) {
    const payload = {
        boardId : bno,
        boardTitle : document.querySelector('.update-board-title').value,
        boardContent : document.querySelector('.update-board-content').value
    }
    console.log(payload);
    const requestInfo = {
        method : 'PUT',
        headers : {
            'content-type' : 'application/json'
        },
        body : JSON.stringify(payload)
    }
    fetch(`${URL}/bno`,requestInfo)
        .then(res => res.json())
        .then(boardList => {

            postListRender(boardList)
        })
    document.querySelector('.update-board-title').value = ''
    document.querySelector('.update-board-content').value = ''
}
// 삭제 비동기 처리
function deleteBoard(bno){
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
const $updateModal = new bootstrap.Modal(document.getElementById('update-modal'), {keyboard: false})
const $roomPwModal = new bootstrap.Modal(document.getElementById('room-pw-modal'), {keyboard: false})
const $okDelete = document.getElementById('delete-Btn');
const $okUpdate = document.getElementById('update-Btn');
const $searchBtn = document.getElementById('search-btn');

const deleteModalEl = document.getElementById('delete-modal')
const updateModalEl = document.getElementById('update-modal')
const roomPwModalEl = document.getElementById('room-pw-modal')

// 룸 암호 모달창이 뜰 때 실행할 코드
roomPwModalEl.addEventListener('show.bs.modal',function (e){
    const preTarget = e.relatedTarget;
    const boardId= preTarget.closest('.room-post').dataset.bno
    if (boardId === id){

    }
})

// 수정 모달창이 뜨고 나서 실행할 코드
updateModalEl.addEventListener('shown.bs.modal', function (e) {
    //relatedTarget : 모달을 열기전 클릭한 타켓
    const targetClass = e.relatedTarget.getAttribute('class');
    //수정버튼 아니면 돌아가
    if(targetClass !== 'modify' ) return
    //게시물 넘버 저장
    updateModalEl.dataset.bno = e.relatedTarget.closest('.room-post').dataset.bno
})

//삭제 모달창이 뜨고 나서 실행할 코드
deleteModalEl.addEventListener('shown.bs.modal', function (e) {
    //relatedTarget : 모달을 열기전 클릭한 타켓
    const targetClass =e.relatedTarget.getAttribute('class');
    if(targetClass !== 'trash' && targetClass !== 'bi-trash' ) return
    console.log(e.relatedTarget.closest('.room-post').dataset.bno)
    deleteModalEl.dataset.bno = e.relatedTarget.closest('.room-post').dataset.bno
})
// 삭제 모달에서 삭제버튼 클릭시
$okUpdate.onclick = () =>{
    const bno = updateModalEl.dataset.bno;
    $updateModal.hide()
    updateBoard(bno);
}

// 삭제 모달에서 삭제버튼 클릭시
$okDelete.onclick = () =>{
    const bno = deleteModalEl.dataset.bno;
    $deleteModal.hide()
    deleteBoard(bno);
}

// 수정 버튼 클릭시
const $modifyBtn = document.getElementById('update-Btn');
$modifyBtn.addEventListener('click',()=>{
    //수정 비동기 처리
})

// 방 만들기 클릭시
$creteBtn.addEventListener('click',()=>{
    window.location.href = '/board/room'
})


function searchClickHandler() {
    let sInput = $searchInput.value
    let sType = $searchType.value
    console.log(sInput);
    console.log(sType);
    SearchPostList(sType, sInput);
}
// 서치 버튼 클릭시
$searchBtn.addEventListener('click',searchClickHandler)