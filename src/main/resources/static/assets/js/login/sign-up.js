


// 회원가입 입력값 검증 처리

// 입력값 검증 통과 여부 배열
const checkResultList = [false, false, false, false, false];

// 아이디 검사 정규표현식
const accountPattern = /^[a-zA-Z0-9]{4,14}$/;

// 아이디 입력값 검증
const $idInput = document.getElementById('user_id');

$idInput.onkeyup = e => {

    const idValue = $idInput.value;
    // console.log(idValue);

    if (idValue.trim() === '') {
        $idInput.style.borderColor = 'red';
        document.getElementById('idHelp').innerHTML
            = '<b style="color: red;">[아이디는 필수값입니다!]</b>';
        checkResultList[0] = false;
    } else if (!accountPattern.test(idValue)) {
        $idInput.style.borderColor = 'red';
        document.getElementById('idHelp').innerHTML
            = '<b style="color: red;">[아이디는 4~14글자의 영문,숫자로 입력하세요.]</b>';
        checkResultList[0] = false;
    } else {
        $idInput.style.borderColor = 'skyblue';
        document.getElementById('idHelp').innerHTML
            = '<b style="color: skyblue;">[사용가능한 아이디입니다.]</b>';
        checkResultList[0] = true;
        // fetch('/members/check?type=account&keyword=' + idValue)
        //     .then(res => res.json())
        //     .then(flag => {
        //         if (flag) { // 중복
        //             $idInput.style.borderColor = 'red';
        //             document.getElementById('idHelp').innerHTML
        //                 = '<b style="color: red;">[아이디가 중복되었습니다.]</b>';
        //             checkResultList[0] = false;
        //         } else {
        //             $idInput.style.borderColor = 'skyblue';
        //             document.getElementById('idHelp').innerHTML
        //                 = '<b style="color: skyblue;">[사용가능한 아이디입니다.]</b>';
        //             checkResultList[0] = true;
        //         }
        //     });


    }
};

// 패스워드 검사 정규표현식
const passwordPattern = /([a-zA-Z0-9].*[!,@,#,$,%,^,&,*,?,_,~])|([!,@,#,$,%,^,&,*,?,_,~].*[a-zA-Z0-9])/;

// 패스워드 입력값 검증
const $pwInput = document.getElementById('sign_pw');

$pwInput.onkeyup = e => {

    const pwValue = $pwInput.value;
    // console.log(idValue);
    extracted();
    if (pwValue.trim() === '') {
        $pwInput.style.borderColor = 'red';
        document.getElementById('pwHelp').innerHTML
            = '<b style="color: red;">[비밀번호는 필수값입니다!]</b>';
        checkResultList[1] = false;
    } else if (!passwordPattern.test(pwValue)) {
        $pwInput.style.borderColor = 'red';
        document.getElementById('pwHelp').innerHTML
            = '<b style="color: red;">[특수문자 포함 8자 이상!]</b>';
        checkResultList[1] = false;
    } else {

        $pwInput.style.borderColor = 'skyblue';
        document.getElementById('pwHelp').innerHTML
            = '<b style="color: skyblue;">[사용가능한 비밀번호입니다.]</b>';
        checkResultList[1] = true;

    }

};




// 패스워드 확인란 입력값 검증
const $pwCheckInput = document.getElementById('sign_pw2');

$pwCheckInput.onkeyup = e => {
    extracted();
};

// 이름 검사 정규표현식
const namePattern = /^[a-zA-Z0-9가-힣]+$/

// 이름 입력값 검증
const $nameInput = document.getElementById('sign_nickname');

$nameInput.onkeyup = e => {

    const nameValue = $nameInput.value;
    // console.log(idValue);

    if (nameValue.trim() === '') {
        $nameInput.style.borderColor = 'red';
        document.getElementById('nickHelp').innerHTML
            = '<b style="color: red;">[이름은 필수정보!]</b>';
        checkResultList[3] = false;
    } else if (!namePattern.test(nameValue)) {
        $nameInput.style.borderColor = 'red';
        document.getElementById('nickHelp').innerHTML
            = '<b style="color: red;">[이름에 특수문자는 불가능합니다]</b>';
        checkResultList[3] = false;
    } else {

        $nameInput.style.borderColor = 'skyblue';
        document.getElementById('nickHelp').innerHTML
            = '<b style="color: skyblue;">[사용가능한 이름입니다.]</b>';
        checkResultList[3] = true;
    }
};

// 이메일 검사 정규표현식
const emailPattern = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;

// 아이디 입력값 검증
const $emailInput = document.getElementById('sign_email');

$emailInput.onkeyup = e => {

    const emailValue = $emailInput.value;
    // console.log(idValue);

    if (emailValue.trim() === '') {
        $emailInput.style.borderColor = 'red';
        document.getElementById('emailHelp').innerHTML
            = '<b style="color: red;">[이메일 필수값입니다!]</b>';
        checkResultList[4] = false;
    } else if (!emailPattern.test(emailValue)) {
        $emailInput.style.borderColor = 'red';
        document.getElementById('emailHelp').innerHTML
            = '<b style="color: red;">[이메일 형식을 지켜주세요~]</b>';
        checkResultList[4] = false;
    } else {
        $emailInput.style.borderColor = 'skyblue';
        document.getElementById('emailHelp').innerHTML
            = '<b style="color: skyblue;">[사용가능한 이메일입니다.]</b>';
        checkResultList[4] = true;
        // fetch('/members/check?type=email&keyword=' + emailValue)
        //     .then(res => res.json())
        //     .then(flag => {
        //         if (flag) { // 중복
        //             $emailInput.style.borderColor = 'red';
        //             document.getElementById('emailHelp').innerHTML
        //                 = '<b style="color: red;">[이메일이 중복되었습니다.]</b>';
        //             checkResultList[4] = false;
        //         } else {
        //             $emailInput.style.borderColor = 'skyblue';
        //             document.getElementById('emailHelp').innerHTML
        //                 = '<b style="color: skyblue;">[사용가능한 이메일입니다.]</b>';
        //             checkResultList[4] = true;
        //         }
        //     });


    }
};


const $sign_ok = document.getElementById('sign_ok');

function signUpBtnHandler() {
    // 5개의 입력칸이 모두 통과되었을 경우 폼을 서브밋
    const $form = document.getElementById('signUpForm');

    if(!checkResultList.includes(false)) {
        $form.submit();
    } else {
        alert('입력란을 다시 확인하세요!');
    }
}

$sign_ok.addEventListener('click',signUpBtnHandler)


// =================비밀번호 검증 함수 =====================
function extracted() {
    const pwCheckValue = $pwCheckInput.value;
    // console.log(idValue)

    if (pwCheckValue.trim() === '') {
        $pwCheckInput.style.borderColor = 'red';
        document.getElementById('pw2Help').innerHTML
            = '<b style="color: red;">[비밀번호 확인란은 필수값입니다!]</b>';
        checkResultList[2] = false;
    } else if ($pwCheckInput.value !== $pwInput.value) {
        $pwCheckInput.style.borderColor = 'red';
        document.getElementById('pw2Help').innerHTML
            = '<b style="color: red;">[위에랑 똑같이 쓰세요!]</b>';
        checkResultList[2] = false;
    } else {

        $pwCheckInput.style.borderColor = 'skyblue';
        document.getElementById('pw2Help').innerHTML
            = '<b style="color: skyblue;">[참 잘했어요~]</b>';
        checkResultList[2] = true;

    }
}