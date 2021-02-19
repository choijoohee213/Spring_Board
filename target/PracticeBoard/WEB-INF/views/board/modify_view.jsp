<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
  <title>글 작성하기</title>
</head>
<body>
    <form action="/board/modify" method="post">
      <input type="hidden" name="bId" value="${content.BId}">
      <table width="500" cellpadding="0" cellspacing="0" border="1">
        <tr>
          <td>이름</td>
          <td><input type="text" name="bName" value="${content.BName}" size="50"></td>
        </tr>
        <tr>
          <td>제목</td>
          <td><input type="text" name="bTitle" value="${content.BTitle}" size="50"></td>
        </tr>
        <tr>
          <td>내용</td>
          <td><textarea name="bContent" rows="10">${content.BContent}</textarea></td>
        </tr>
      </table>
      <div>
        <input type="submit" value="수정" width="50">
      </div>
    </form>

</body>
</html>
