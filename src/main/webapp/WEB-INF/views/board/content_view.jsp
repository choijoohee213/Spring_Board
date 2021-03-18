<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
  <title>글 내용</title>

  <script src="https://code.jquery.com/jquery-3.4.1.js" type="text/javascript"></script>
  <script src="/js/reply.js"></script>
  <script type="text/javascript">
    function replyWrite(){
      let reply = {};
      let bId = document.getElementById("bId").innerText;
      let name = document.getElementById("replyName").value;
      let content = document.getElementById("replyContent").value;

      reply.bId = bId;
      reply.rName = name;
      reply.rContent = content;

      replyService().add(reply,
        function(){
          alert('test');
        }
      );
    }
  </script>
</head>
<body>
<!-- 글 내용 보여주기 -->
<table width="500" cellpadding="0" cellspacing="0" border="1">
  <tr>
    <td>번호</td>
    <td id="bId">${content.BId}</td>
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
    <td>게시글 내용</td>
    <td>${content.BContent}</td>
  </tr>
  <c:if test="${file != null}">
    <tr>
      <td>첨부파일</td>
      <td>
        <a href="/board/fileDown?fId=${file.FId}">${file.FOrgi_name}</a>
      </td>
    </tr>
  </c:if>
  <tr>
    <td colspan="2">
      <a href="/board/modify_view?bId=${content.BId}">수정</a>
      <a href="/board/list">목록</a>&nbsp;&nbsp;
      <a href="/board/delete?bId=${content.BId}">삭제</a>&nbsp;&nbsp;
    </td>
  </tr>
</table>

<!-- 댓글 -->
<div id="reply">
  <div>
    <input id="replyName" type="text" size="10">
  </div>
  <textarea id="replyContent" rows="8" cols="80"></textarea>
  <button id="btn_replyWrite" onclick="replyWrite()">
    댓글 등록
  </button>
</div>

</body>
</html>
