<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
  <title>글 내용</title>
</head>
<body>
<form action="/board/modify" method="post">
  <table width="500" cellpadding="0" cellspacing="0" border="1">
    <input type="hidden" name="bId" value="${content.BId}">
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
      <td>
        <input type="text" name="bName" value="${content.BName}">
      </td>
    </tr>
    <tr>
      <td>제목</td>
      <td>
        <input type="text" name="bTitle" value="${content.BTitle}">
      </td>
    </tr>
    <tr>
      <td>내용</td>
      <td>
        <textarea name="bContent" rows="10">
          ${content.BContent}"
        </textarea>
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="수정">&nbsp;&nbsp;
        <a href="/board/list">목록</a>&nbsp;&nbsp;
        <a href="/board/delete?bId=${content.BId}">삭제</a>&nbsp;&nbsp;
        <a href="/board/reply_view?bId=${content.BId}">답변달기</a>
      </td>
    </tr>
  </table>
</form>
</body>
</html>
