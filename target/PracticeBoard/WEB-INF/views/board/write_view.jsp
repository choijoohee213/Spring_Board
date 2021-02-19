<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>글 작성하기</title>
</head>
<body>
    <form action="/board/write" method="post">
      <table width="500" cellpadding="0" cellspacing="0" border="1">
        <tr>
          <td>이름</td>
          <td><input type="text" name="bName" size="50"></td>
        </tr>
        <tr>
          <td>제목</td>
          <td><input type="text" name="bTitle" size="50"></td>
        </tr>
        <tr>
          <td>내용</td>
          <td><textarea name="bContent" rows="10"></textarea></td>
        </tr>
      </table>
      <div>
        <input type="submit" value="입력" width="50">
      </div>
    </form>

</body>
</html>
