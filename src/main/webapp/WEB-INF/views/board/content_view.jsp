<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<html>
<head>
  <title>글 내용</title>
</head>
<body>
    <table width="500" cellpadding="0" cellspacing="0" border="1">
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
        <td>${content.bName}</td>
      </tr>
      <tr>
        <td>제목</td>
        <td>${content.bTitle}</td>
      </tr>
      <tr>
        <td>내용</td>
        <td>${content.bContent}</td>
      </tr>
    </table>
    <a href="/board/list">목록</a>
</body>
</html>
