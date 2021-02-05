<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

    <c:forEach var="dto" items="${list}">
      <tr>
        <td>${dto.bId}</td>
        <td>${dto.bName}</td>
        <td>
          <c:forEach begin="1" end="${dto.bIndent}">-</c:forEach>
          <a href="/board/content_view?bId=${dto.bId}">${dto.bTitle}</a>
        </td>
        <td>${dto.bDate}</td>
        <td>${dto.bHit}</td>
      </tr>
    </c:forEach>

    <tr>
      <td colspan="5"><a href="/board/write_view">글 작성</a></td>
    </tr>
  </table>

</body>
</html>
