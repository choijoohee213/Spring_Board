<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>글 답변</title>
</head>
<body>
    <form action="/board/reply" method="post">
      <table width="500" cellpadding="0" cellspacing="0" border="1">
        <input type="hidden" name="bId" value="${reply.bId}">
        <input type="hidden" name="bGroup" value="${reply.bGroup}">
        <input type="hidden" name="bStep" value="${reply.bStep}">
        <input type="hidden" name="bIndent" value="${reply.bIndent}">

        <tr>
          <td>번호</td>
          <td>${reply.bId}</td>
        </tr>
        <tr>
          <td>조회수</td>
          <td>${reply.bHit}</td>
        </tr>
        <tr>
          <td>이름</td>
          <td>
            <input type="text" name="bName" value="${reply.bName}">
          </td>
        </tr>
        <tr>
          <td>제목</td>
          <td>
            <input type="text" name="bTitle" value="${reply.bTitle}">
          </td>
        </tr>
        <tr>
          <td>내용</td>
          <td>
            <textarea name="bContent" rows="10">
              ${reply.bContent}
            </textarea>
          </td>
        </tr>
        <tr>
          <td colspan="2">
            <input type="submit" value="답변">
            <a href="/board/list">목록</a>
          </td>
        </tr>
      </table>
    </form>

</body>
</html>
