<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
  <title>게시판 목록</title>
</head>
<body>
  <table width="500" cellpadding="0" cellspacing="0" border="1">
    <tr>
      <td>번호</td>
      <td>이름</td>
      <td>제목</td>
      <td>날짜</td>
      <td>조회수</td>
    </tr>

    <c:forEach var="vo" items="${list}">
      <tr>
        <td>${vo.BId}</td>
        <td>${vo.BName}</td>
        <td>
          <a href="/board/content_view?bId=${vo.BId}">${vo.BTitle}</a>
        </td>
        <td><fmt:formatDate value="${vo.BDate}" pattern="yyyy.MM.dd HH:mm"/></td>
        <td>${vo.BHit}</td>
      </tr>
    </c:forEach>

    <tr>
      <td colspan="5"><a href="/board/write_view">글 작성</a></td>
    </tr>
  </table>

</body>
</html>
