<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
  <title>글 내용</title>
</head>
<body>
  <table width="500" cellpadding="0" cellspacing="0" border="1">
    <tr>
      <td>번호</td>
      <td>${content.BId}</td>
    </tr>
    <tr>
      <td>조회수</td>
      <td>${content.BHit}</td>
    </tr>
    <tr>
      <td>이름</td>
      <td>${content.BName}</td>
    </tr>
    <tr>
      <td>제목</td>
      <td>${content.BTitle}</td>
    </tr>
    <tr>
      <td>날짜</td>
      <td><fmt:formatDate value="${content.BDate}" pattern="yyyy.MM.dd HH:mm"/></td>
    </tr>
    <tr>
      <td>내용</td>
      <td>${content.BContent}</td>
    </tr>
    <tr>
      <td colspan="2">
        <a href="/board/modify_view?bId=${content.BId}">수정</a>
        <a href="/board/list">목록</a>&nbsp;&nbsp;
        <a href="/board/delete?bId=${content.BId}">삭제</a>&nbsp;&nbsp;
        <a href="/board/reply_view?bId=${content.BId}">답변달기</a>
      </td>
    </tr>
  </table>
</body>
</html>
