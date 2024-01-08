
const $headBtn = document.getElementById("head-btn");

const tag = ``;
if ('${msg}' === '')
$headBtn.innerHTML = `
    <button type="button" class="btn btn-light">LOGOUT</button>
    <button type="button" class="btn btn-light">MY PAGE</button>

`
//
// const $roomTitle = document.getElementById('room-logo');
// $roomTitle.onclick  = ()=>{
//     window.location.href='/room/main?roomId='+document.getElementById('room-title').dataset.room
// }