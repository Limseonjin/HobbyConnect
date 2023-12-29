<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>MAIN</title>

    <%@include file="common/static-head.jsp"%>
    <%-- 필요한 css나 js 선언   --%>
    <link rel="stylesheet" href="/assets/css/mainpage/main.css">
</head>
<body>
<%@include file="common/head.jsp"%>
<%-- 여기서 부터 코드 입력 --%>
<div id="main-wrapper">
   <%--검색 창--%>
    <table>
      <tr>
          <form>
              <fieldset class="search">
                  <input class="inpt" placeholder="컨텐츠를 검색해주세요" type="text">
                  <button id="sch-bnt" type="submit" style="background: none; border:0px;"; ><img src="/assets/img/7.png"></button>
              </fieldset>
          </form>
      </tr>
    </table>

</div>
<%@include file="common/footer.jsp"%>
</body>
</html>