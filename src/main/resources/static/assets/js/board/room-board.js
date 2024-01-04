
const $roomBoard = document.querySelectorAll(...['.room-post']);

(()=>{
    // roomPostList()
})()

/** room 안에 게시글 렌더링 하는 함수  */
function roomPostRender(bList){
    let tag = ``;
    tag += `
    <div class="card room-post" data-bno="2">
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



/** room 안에 게시글 비동기 조회*/
function roomPostList(){
    fetch(${URL})
        .then(res=>res.json())
        .then(b => {
            roomPostList(bList)
        })
}

//** 개별 board 클릭시 나타는 클릭 이벤트 핸들러 */
function boardClickHandler() {
    console.log('클릭함')
}

$roomBoard.forEach(rm => {rm.addEventListener('click',boardClickHandler)})