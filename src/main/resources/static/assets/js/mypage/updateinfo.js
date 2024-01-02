const $pwUpdateBtn = document.getElementById('pw-update-btn')

function pwUpdateBtnClickHandler() {
    const $pwForm = document.getElementById('pwform')
    $pwForm.innerHTML = `
       <div class="mb-3">
            <label for="sign_pw" class="form-label">비밀번호*</label>
            <input type="password" class="form-control" id="sign_pw" name="password">
            <div id="pwHelp" class="form-text"></div>
       </div>
       <div class="mb-3">
            <label for="sign_pw2" class="form-label">비밀번호 재입력*</label>
            <input type="password" class="form-control" id="sign_pw2">
            <div id="pw2Help" class="form-text"></div>
       </div>
       <button id="pwok" class="btn btn-primary">비밀번호 수정하기</button>
    `;

    const $pwok = document.getElementById('pwok');
    $pwok.onclick = e =>{
        $pwForm.innerHTML = ``;
    }
}

$pwUpdateBtn.addEventListener('click',pwUpdateBtnClickHandler)