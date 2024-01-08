

const $writePost = document.getElementById('create-board')
const $boardList = document.getElementById('board-list');
const $delMember = document.querySelectorAll(...['.del-mem']);
const $exitRoom = document.getElementById('exitRoom');

const URL = '/room';
const ROOM_ID = document.getElementById('room-title').dataset.room;
console.log(ROOM_ID);
(()=>{
    roomPostList()
    makePageButtonClickEvent();
})()

/** room 안에 게시글 렌더링 하는 함수  */
function roomPostRender({boards, pageInfo}){
    let tag = ``;
    if (boards !== null && boards.length > 0) {
        for (const b of boards) {
            tag += `
    <div class="card room-board-post" data-bno="${b.boardId}">
                    <div class="card-header">
                        <h2>${b.boardTitle}</h2>
                        <p class="card-text">작성자:${b.nickname}</p>
                    </div>
                    <div class="card-body">
                        <p class="contents">${b.boardContent}</p>
                    </div>
                    <div class="card-footer">
                        <p>조회수:${b.viewCount} </p>
                        <p>댓글수:${b.replyCount} </p>
                    </div>
                </div>
    `
        }
    } else {
        tag += "<div id='boardContent' class='card-body'>게시글을 작성해 사람들과 소통하세요</div>";
    }
    $boardList.innerHTML = tag;
    const $roomBoard = document.querySelectorAll(...['.room-board-post']);
    // 룸 안에 게시글마다 클릭 이벤트 걸기
    $roomBoard.forEach(rm => {rm.addEventListener('click',boardClickHandler)})
    // 페이지 렌더링
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

/** room 안에 게시글 비동기 조회*/
function roomPostList(pageNo= 1){
    fetch(`${URL}/${ROOM_ID}/${pageNo}`)
        .then(res=>res.json())
        .then(bList => {
            roomPostRender(bList)
        })
}

/** roomMember 강퇴(삭제) 비동기 처리 */
function deleteMember(personId,roomId){
    console.log('비동기 할거유 ')
    const reqInfo = {
        method : 'DELETE'
    }
    fetch(`${URL}/${personId}/${roomId}`,reqInfo)
        .then(res => res.json())
        .then(r =>{
            console.log(r)
            window.location.href="/room/main?roomId="+roomId;
        })
}
function exitMy(personId,roomId) {
    console.log('비동기 할거유 ')
    const reqInfo = {
        method : 'DELETE'
    }
    fetch(`${URL}/${personId}/${roomId}`,reqInfo)
        .then(res => res.json())
        .then(r =>{
            console.log(r)
            window.location.href="/main/main-page";
        })
}

//** 개별 board 클릭시 나타는 클릭 이벤트 핸들러 */
function boardClickHandler(e) {
    console.log('클릭함')
    const bno = e.target.closest('.room-board-post').dataset.bno;
    window.location.href = `/room/board/detail?roomId=${ROOM_ID}&boardId=${bno}`;
}

/** 글 쓰기 버튼 이벤트 핸들러 */
function writePostClickHandler() {
    window.location.href = `/room/board/write?roomId=${ROOM_ID}`;
}

//글 쓰기 클릭 이벤트
$writePost.addEventListener('click',writePostClickHandler)

// 룸 멤버 삭제 클릭 이벤트
$delMember.forEach(m =>m.onclick= (e)=>{
    console.log('클릭될듯')

    // 삭제 아이디 가져오고 삭제 비동기 처리 로 이동
    const personId = e.target.closest('.user-wrap').querySelector('p[data-id]').dataset.id
    console.log(personId)
    deleteMember(personId ,ROOM_ID)
} )


// 페이지 클릭 이번테 핸들러 등록 함수
function makePageButtonClickEvent() {
    const $pageUl = document.querySelector('.pagination');

    $pageUl.onclick = e => {
        // 이벤트 타겟이 a링크가 아니면 타겟 제한
        if (!e.target.matches('.page-item a')) return;
        e.preventDefault(); // 태그 기본 동작 기능 중단.
        // 페이지 번호에 맞는 새로운 댓글 목록 비동기 요청
        roomPostList(e.target.getAttribute('href'));
    }
}


//모달 안에 방 나가기 클릭 이벤트
const $LeaveBtn = document.getElementById('confirmLeaveBtn');
$LeaveBtn.addEventListener('click',()=>{
    exitMy(document.getElementById('myuser').dataset.id,ROOM_ID)
})
