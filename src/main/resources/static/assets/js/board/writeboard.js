// 음... 입력 검사 처리 예정
const $pwCheck = document.getElementById('flexCheckDefault')
const $inputPw = document.getElementById('inputPw')
function pwCheckClick() {
    const flag = $pwCheck.checked;
    $inputPw.disabled = !flag
}

$pwCheck.addEventListener('change',pwCheckClick)