

const $writePost = document.getElementById('create-board')
const $boardList = document.getElementById('board-list');
const $delMember = document.querySelectorAll(...['.del-mem']);

const URL = '/room';
const ROOM_ID = document.getElementById('room-title').dataset.room;
console.log(ROOM_ID);
(()=>{
    roomPostList(document.getElementById('room-title').dataset.room)
})()

/** room 안에 게시글 렌더링 하는 함수  */
function roomPostRender(bList){
    let tag = ``;
    if (bList !== null && bList.length > 0) {
        for (const b of bList) {
            tag += `
    <div class="card room-post" data-bno="${b.boardId}">
                    <div class="card-header">
                        <p class="card-text">작성자:${b.nickname}</p>
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
    } else {
        tag += "<div id='boardContent' class='card-body'>게시글을 작성해 사람들과 소통하세요</div>";
    }
    $boardList.innerHTML = tag;
    const $roomBoard = document.querySelectorAll(...['.room-post']);
    // 룸 안에 게시글마다 클릭 이벤트 걸기
    $roomBoard.forEach(rm => {rm.addEventListener('click',boardClickHandler)})
}

/** room 안에 게시글 비동기 조회*/
function roomPostList(){
    fetch(`${URL}/${ROOM_ID}`)
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
    fetch(`${URL}/${personId}/exitRoom/${roomId}`,reqInfo)
        .then(res => res.json())
        .then(r =>{
            console.log(r)
            // window.location.href="/room/main?roomId="+roomId;
        })
}

//** 개별 board 클릭시 나타는 클릭 이벤트 핸들러 */
function boardClickHandler(e) {
    console.log('클릭함')
    const bno = e.target.closest('.room-post').dataset.bno;
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