<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Comment</title>
    <style>
        .table1 {
            width: 100%;
            text-align: center;
            border: 1px solid #585858;
        }
        .table1 td {
            align: left;
            background-color: #E6E6E6;
            padding: 10px;
        }
        .table2 {
            width: 100%;
            text-align: center;
            border: 1px solid #585858;
        }
        .table2 td {
            align: left;
        }
        .table3 {
            width: 100%;
            text-align: center;
            border: 1px solid #585858;
        }
        .table3 td {
            align: left;
        }
        .form-control {
            width: 100%;
        }
        .btn {
            display: inline-block;
            font-weight: 400;
            color: #ffffff;
            text-align: center;
            vertical-align: middle;
            user-select: none;
            background-color: #819FF7;
            border: 1px solid #ffffff;
            padding: 0.375rem 0.75rem;
            font-size: 1rem;
            line-height: 1.5;
            border-radius: 0.45rem;
        }
        .btn:hover {
            color: #FFF;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <table class="table1">
            <tbody>
            <tr>
                <td align="left" bgcolor="skyblue">댓글</td>
            </tr>
            <tr>
                <div class="container">
                    <div class="row">
                        <table class="table2" >
                            <tbody>
                            <tr>
                                <td align="left"></td>
                                <td align="right"></td>
                            </tr>
                            <tr>
                                <td align="left"></td>
                                <td align="right">
                                    <a href="#>"class=" btn btn u"> 수정 </a>
                                    <a href="#" class="btn btn d"> 삭제 </a>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </tr>
        </table>
    </div>
</div>
<br>
<div class="container">
    <div class="row">
        <form method="post">
            <table class="table3">
                <tbody>
                <tr>
                    <td align="left"></td>
                </tr>
                <tr>
                    <td><input type="text" class="form-control" laceholder="댓글 쓰기" name="commentContent" maxlength="300"></td>
                </tr>
                </tbody>
            </table>
            <input type="submit" class="btn btn s" value="댓글 쓰기">
        </form>
    </div>
</div>
</div>
</div>
</body>
</html>