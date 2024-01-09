
const $roomTitle = document.getElementById('room-logo');

if (!!$roomTitle){
    $roomTitle.onclick  = ()=>{
        window.location.href='/room/main?roomId='+document.getElementById('room-title').dataset.room
    }
}
