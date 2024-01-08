
const $roomTitle = document.getElementById('room-logo');
$roomTitle.onclick  = ()=>{
    window.location.href='/room/main?roomId='+document.getElementById('room-title').dataset.room
}