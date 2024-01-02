const $myroom = document.getElementById('room-list');
const $myboard = document.getElementById('board-list');
const $myreply = document.getElementById('reply-list');

$myroom.addEventListener('click',()=>{
    window.location.href = '/mypage/room';
})
$myboard.addEventListener('click',()=>{
    window.location.href = '/mypage/board';
})
$myreply.addEventListener('click',()=>{
    window.location.href = '/mypage/reply';
})