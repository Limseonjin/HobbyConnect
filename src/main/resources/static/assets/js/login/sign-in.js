const serverMessage = '${msg}';
console.log('msg: ' + serverMessage);

if (serverMessage === 'NO_ACC') {
    alert('계정이 없습니다 회원가입을 해주세요');
} else if (serverMessage === 'NO_PW') {
    alert('비밀번호가 틀렸습니다.');
}