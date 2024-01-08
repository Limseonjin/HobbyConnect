
const $creteBtn = document.getElementById('create-room');
const $searchInput = document.getElementById('search-content');
const $searchType = document.getElementById('search-type')
const URL = '/api/v1/mainBoards';
const ROOM_PW = '';

// ============= 비동기 처리 관련 ==============================
(() => {
    postList();
    makePageButtonClickEvent();
})()

// 게시글 조회 화면 렌더링
function postListRender({mainBoards, pageInfo}){
    console.log(mainBoards);
    console.log(pageInfo);
    const $postBody = document.getElementById('post-list-body');
    let tag = ``;
    for (const dto of mainBoards) {
        tag +=`<div class="card room-post" data-bno="${dto.roomId}">
                    <div class="card-header">
                           <h2>`
        if(dto.roomPw !== ""){
            tag +=  `<span id="isPw" class="lnr lnr-lock"></span>`
        }
        tag +=`${dto.mainBoardTitle} (${dto.currUser}/${dto.maxUser})
</h2>
                             <div class="icon">
                                <button class="icon-btn modify" data-bs-toggle="modal"  data-bs-target="#update-modal">
                                    <svg xmlns="http://www.w3.org/2000/svg"  fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                                        <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                                        <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5z"/>
                                    </svg>
                                </button>
                                <button class="icon-btn trash" data-bs-toggle="modal"  data-bs-target="#delete-modal">
                                    <svg xmlns="http://www.w3.org/2000/svg"  fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                        <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5m3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0z"/>
                                        <path d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4zM2.5 3h11V2h-11z"/>
                                    </svg>
                                </button>
                            </div>
                    </div>
                    <div class="card-body">
                         <p class="contents">${dto.mainBoardContent}</p>
                         <div class="jcend">
                             <p class="card-text">작성자:${dto.personId}</p>
                         </div>
                        <button class="foward-room btn btn-primary" data-bs-toggle="modal" data-bs-target="#room-pw-modal" type="button">참여하기</button>
                    </div>
              </div>`
    }
    $postBody.innerHTML = tag;
    pageNoRender(pageInfo);
}

/** 페이지 넘버 렌더링 함수  */
function pageNoRender({begin, end, prev, next, page, finalPage}){
    let tag = ``;
    // 이전 버튼
    if (prev){
        tag += `<li className="page-item">
            <a className="page-link" href="\${begin - 1}" aria-label="Previous">
                <span aria-hidden="true">&laquo;</span>
            </a>
        </li>`
    }
    //페이지 번호 리스트 만들기
    for (let i = begin; i <= end; i++) {
        let active = '';
        if (page.pageNo === i) {
            active = 'p-active';
        }

        tag += `<li class='page-item \${active}'><a class='page-link page-custom' href='${i}' data-pageNo='${i}'>${i}</a></li>`;
    }
    //  다음 버튼
    if (next) {
        tag += `<li className="page-item">
        <a className="page-link" href="\${end + 1}" aria-label="Next">
            <span aria-hidden="true">&raquo;</span>
        </a>
    </li>
        `
    }
    // 페이지 태그 렌더링
    const $pageUl = document.querySelector('.pagination');
    $pageUl.innerHTML = tag;
    // ul에 마지막 페이지 번호 저장
    $pageUl.dataset.fp = finalPage;
}

// 게시글 비동기 처리
function postList(pageNo=1){
    fetch(`${URL}/main/page/${pageNo}`)
        .then(res=>res.json())
        .then(dtoList =>{
            postListRender(dtoList)
        })
}

function SearchPostList(type,input,pageNo=1){
    console.log("hi")
    fetch(`${URL}/${type}/${input}/page/${pageNo}`)
        .then(res=> res.json())
        .then(dtoList =>{
            postListRender(dtoList)
        })
}
// 검색시 게시글 비동기 처리

//수정 비동기 처리
function updateBoard(bno) {
    const payload = {
        roomId : bno,
        mainBoardTitle : document.querySelector('.update-board-title').value,
        mainBoardContent : document.querySelector('.update-board-content').value
    }
    console.log(payload);
    const requestInfo = {
        method : 'PUT',
        headers : {
            'content-type' : 'application/json'
        },
        body : JSON.stringify(payload)
    }
    fetch(`${URL}/modfiy`,requestInfo)
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
// ================================ JSP 관련(버튼) JS =======================

const $deleteModal = new bootstrap.Modal(document.getElementById('delete-modal'), {keyboard: true})
const $updateModal = new bootstrap.Modal(document.getElementById('update-modal'), {keyboard: true})
const $roomPwModal = new bootstrap.Modal(document.getElementById('room-pw-modal'), {keyboard: true})
const $okDelete = document.getElementById('delete-Btn');
const $okUpdate = document.getElementById('update-Btn');
const $searchBtn = document.getElementById('search-btn');

const deleteModalEl = document.getElementById('delete-modal')
const updateModalEl = document.getElementById('update-modal')
const roomPwModalEl = document.getElementById('room-pw-modal')

// 룸 암호 입력 창
const $inputPw = document.querySelector('.input-room-pw')
// 룸 암호 모달창이 뜰 때 실행할 코드
roomPwModalEl.addEventListener('show.bs.modal',function (e){
    const preTarget = e.relatedTarget;
    const roomId= preTarget.closest('.room-post').dataset.bno
    console.log(roomId)
    const closest = preTarget.closest('.room-post').querySelector('#isPw');

    /** 방 암호 입력 후 입장을 누르면 나타나는 핸들러  */
    function pwBtnClickHandler(e) {
        // 동작(이벤트)을 실행하지 못하게 막는 메서드입니다.
        e.preventDefault();
        if ($inputPw.value.trim() === ''){
            $inputPw.classList.add('is-invalid');
            $inputPw.nextElementSibling.textContent = '값을 입력하세요!';
        }else{
            // 비동기 (회원가입 유효성 검사 참고할 것 => flag 프론트로 넘겨줘야함 )
            fetch(`/room/check/${roomId}?roomPw=`+$inputPw.value)
                .then(res => res.json())
                .then(flag=>{  // flag = 비밀번호 일치 검사 결과
                    if (flag) { // 일치
                        window.location.href = `/room/main?roomId=${roomId}`
                    } else { // 비일치
                        $inputPw.classList.add('is-invalid');
                        $inputPw.nextElementSibling.textContent = '틀렸습니다!';
                    }
                })
        }
    }
    // 방 암호가 걸려있는지 체크
    if (!!closest){
        const $pwSubmitBtn = document.getElementById('forward-room-Btn')
        $pwSubmitBtn.addEventListener('click',pwBtnClickHandler)

    }else{ //없으면 바로 방으로 이동
        $inputPw.value =''
        $roomPwModal.hide()
        window.location.href = `/room/main?roomId=${roomId}`
    }
})
/** 룸 암호 입력모달이 닫히고 실행 될 코드 */
roomPwModalEl.addEventListener('hide.bs.modal',()=>{
    $inputPw.value =''
    $inputPw.classList.remove('is-invalid');
})
// 수정 모달창이 뜨고 나서 실행할 코드
updateModalEl.addEventListener('shown.bs.modal', function (e) {
    //relatedTarget : 모달을 열기전 클릭한 타켓
    const targetClass = e.relatedTarget.getAttribute('class');
    //수정버튼 아니면 돌아가
    if(targetClass !== 'icon-btn modify' ) return
    //게시물 넘버 저장
    updateModalEl.dataset.bno = e.relatedTarget.closest('.room-post').dataset.bno
})

//삭제 모달창이 뜨고 나서 실행할 코드
deleteModalEl.addEventListener('shown.bs.modal', function (e) {
    //relatedTarget : 모달을 열기전 클릭한 타켓
    const targetClass =e.relatedTarget.getAttribute('class');
    console.log(targetClass)
    if(targetClass !== 'icon-btn trash' ) return
    console.log(e.relatedTarget.closest('.room-post').dataset.bno)
    deleteModalEl.dataset.bno = e.relatedTarget.closest('.room-post').dataset.bno
})

// 방 만들기 클릭시
$creteBtn.addEventListener('click',()=>{
    window.location.href = '/room/room'
})

// 수정 모달에서 수정버튼 클릭시
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


// 페이지 클릭 이번테 핸들러 등록 함수
function makePageButtonClickEvent() {
    const $pageUl = document.querySelector('.pagination');

    $pageUl.onclick = e => {
        // 이벤트 타겟이 a링크가 아니면 타겟 제한
        if (!e.target.matches('.page-item a')) return;
        e.preventDefault(); // 태그 기본 동작 기능 중단.
        // 페이지 번호에 맞는 새로운 댓글 목록 비동기 요청
        postList(e.target.getAttribute('href'));
    }
}

/** 검색 버튼 클릭 이벤트 핸들러 (비동기)*/
function searchClickHandler() {
    let sInput = $searchInput.value
    if (sInput === "") {
        alert("검색어가 없습니다.")
        return
    }
    let sType = $searchType.value
    SearchPostList(sType, sInput);
}
// 서치 버튼 클릭시
$searchBtn.addEventListener('click',searchClickHandler);



// =====================유효성 검사 ============

