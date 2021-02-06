<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
  <title>글 내용</title>
</head>
<body>
<form action="/board/modify" method="post">
  <table width="500" cellpadding="0" cellspacing="0" border="1">
    <input type="hidden" name="bId" value="${content.bId}">
    <tr>
      <td>번호</td>
      <td>${content.bId}</td>
    </tr>
    <tr>
      <td>조회수</td>
      <td>${content.bHit}</td>
    </tr>
    <tr>
      <td>이름</td>
      <td>
        <input type="text" name="bName" value="${content.bName}">
      </td>
    </tr>
    <tr>
      <td>제목</td>
      <td>
        <input type="text" name="bTitle" value="${content.bTitle}">
      </td>
    </tr>
    <tr>
      <td>내용</td>
      <td>
        <textarea name="bContent" rows="10">
          ${content.bContent}"
        </textarea>
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="수정">&nbsp;&nbsp;
        <a href="/board/list">목록</a>&nbsp;&nbsp;
        <a href="/board/delete?bId=${content.bId}">삭제</a>&nbsp;&nbsp;
        <a href="/board/reply_view?bId=${content.bId}">답변</a>
      </td>
    </tr>
  </table>
</form>
</body>
</html>
