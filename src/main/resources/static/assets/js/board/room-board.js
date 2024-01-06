
const $roomBoard = document.querySelectorAll(...['.room-post']);
const $writePost = document.getElementById('create-board')
const $boardList = document.getElementById('board-list');
const URL = '/room';
(()=>{
    roomPostList(document.getElementById('room-title').dataset.room)
})()

/** room 안에 게시글 렌더링 하는 함수  */
function roomPostRender(bList){
    let tag = ``;
    for (const b of bList) {
        tag += `
    <div  class="card room-post" data-bno="${b.boardNo}">
                    <div class="card-header">
                        <p class="card-text">작성자:${nickname}</p>
                    </div>
                    <div class="card-body">
                        <p class="contents">content:${b.boardContent}</p>
                    </div>
                    <div class="card-footer">
                        <p>조회수:${b.viewCount} </p>
                        <p>댓글수:${b.replyCount} </p>
                    </div>
                </div>
    `
    }
    $boardList.innerHTML = tag;
}

/** room 안에 게시글 비동기 조회*/
function roomPostList(){
    fetch(`${URL}`)
        .then(res=>res.json())
        .then(bList => {
            roomPostList(bList)
        })
}

//** 개별 board 클릭시 나타는 클릭 이벤트 핸들러 */
function boardClickHandler(e) {
    console.log('클릭함')
    const bno = e.target.closest('.room-post').dataset.bno;
    window.location.href = `/room/board/detail?boardNo=${bno}`;
}

/** 글 쓰기 버튼 이벤트 핸들러 */
function writePostClickHandler() {
    window.location.href = 'room/board/write';
}

// 룸 안에 게시글마다 클릭 이벤트 걸기
$roomBoard.forEach(rm => {rm.addEventListener('click',boardClickHandler)})

//글 쓰기 클릭 이벤트
$writePost.addEventListener('click',writePostClickHandler)