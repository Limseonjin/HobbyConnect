<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
    <head>
    <meta charset="UTF-8">
    <title>My-Page DELETE</title>
<style>
    #d{
    text-align: center;
}
    #di {
    text-align: center;
    margin-top: 20px;

}
    table {
    border-collapse: collapse;
    width: 400px;
    margin: auto;
}
    td {
    padding: 10px;

}
    input[type="submit"],
    input[type="reset"] {
    padding: 8px 12px;
    font-size: 14px;
    cursor: pointer;
    margin-right: 10px;
}
</style>
</head>
<body>
<script src="/assets/js/personDelete.js" defer ></script>
<div id="d">
    <h3>회원정보를 삭제 하시겠습니까?</h3>
</div>

<div id="di">
    <table>
        <tr>
            <td>
                <input type="submit" value="회원탈퇴" onclick="withdrawalFunction()"/>
                <input type="reset" value="취소" onclick="cancelFunction()"/>
            </td>
        </tr>
    </table>
</div>

</body>
</html>