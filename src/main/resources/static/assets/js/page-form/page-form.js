function writeCheck()
{
    var form = document.writeform;

    // 이름 필드 체크
    if (!form.name.value) {
        alert("이름을 적어주세요");
        form.name.focus();
        return;
    }

    // 비밀번호 필드 체크
    if (!form.password.value) {
        alert("비밀번호를 적어주세요");
        form.password.focus();
        return;
    }

    // 제목 필드 체크
    if (!form.title.value) {
        alert("제목을 적어주세요");
        form.title.focus();
        return;
    }

    // 내용 필드 체크
    if (!form.memo.value) {
        alert("내용을 적어주세요");
        form.memo.focus();
        return;
    }
}
