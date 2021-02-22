<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
  <title>게시판 목록</title>
</head>
<body>
<!-------------------------------------------------------------------------------------->
<!-- 글 검색 -->
<div>
  <form>
    <div>
      <div>
        <select name="key">
          <option value="t" ${(pageObject.key == "t")? "selected" : ""}>
            제목
          </option>
          <option value="c" ${(pageObject.key == "c")? "selected" : ""}>
            내용
          </option>
          <option value="w" ${(pageObject.key == "w")? "selected" : ""}>
            작성자
          </option>
          <option value="tc" ${(pageObject.key == "tc")? "selected" : ""}>
            제목/내용
          </option>
          <option value="tw" ${(pageObject.key == "tw")? "selected" : ""}>
            제목/작성자
          </option>
          <option value="cw" ${(pageObject.key == "cw")? "selected" : ""}>
            내용/작성자
          </option>
          <option value="tcw" ${(pageObject.key == "tcw")? "selected" : ""}>
            제목/내용/작성자
          </option>
        </select>
        <input type="text" placeholder="Search" name="word" value="${pageObject.word}">
      </div>
      <button type="submit">검색</button>
    </div>
  </form>
</div>

<!-------------------------------------------------------------------------------------->
<!-- 게시판 글 목록 불러오기 -->
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

<!-------------------------------------------------------------------------------------->
<!--페이징 처리-->
<div>
  <c:set var="startPage" value="${pageObject.startPage}"/>
  <c:set var="endPage" value="${pageObject.endPage}"/>

  <!--이전 페이지 그룹 이동 버튼 -->
  <div>
    <c:if test="${startPage > 1}">
      <a href="/board/list?page=${startPage - 1}&perPageNum=${pageObject.perPageNum}
      &key=${pageObject.key}&word=${pageObject.word}">◀</a>
    </c:if>
    <c:if test="${startPage == 1}">
      <a onclick="alert('이전 페이지가 없습니다.')">◀</a>
    </c:if>
  </div>

  <!--페이지 버튼 리스트-->
  <div class="pageNav">
    <c:forEach var="page" begin="${startPage}" end="${endPage}">
      <c:set var="curPageStyle" value="text-decoration:none;"/>
      <c:if test="${pageObject.page == page}">
        <c:set var="curPageStyle" value="color:red;"/>
      </c:if>
      <a href="/board/list?page=${page}&perPageNum=${pageObject.perPageNum}
      &key=${pageObject.key}&word=${pageObject.word}" style="${curPageStyle}">${page}</a>
    </c:forEach>
  </div>

  <!--다음 페이지 그룹 이동 버튼 -->
  <div>
    <c:if test="${pageObject.totalPage > endPage}">
      <a href="/board/list?page=${startPage + pageObject.perGroupPageNum}&perPageNum=${pageObject.perPageNum}
      &key=${pageObject.key}&word=${pageObject.word}">▶</a>
    </c:if>
    <c:if test="${pageObject.totalPage == endPage}">
      <a onclick="alert('다음 페이지가 없습니다.')">▶</a>
    </c:if>
  </div>
</div>

</body>
</html>
