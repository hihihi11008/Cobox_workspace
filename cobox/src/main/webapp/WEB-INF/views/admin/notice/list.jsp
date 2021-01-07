<%@page import="com.koreait.cobox.common.Pager"%>
<%@page import="com.koreait.cobox.model.domain.Notice"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	List<Notice> noticeList= (List<Notice>)request.getAttribute("noticeList");
	Pager pager = new Pager();
	pager.init(request, noticeList);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<style>
/* 게시판메뉴바 디자인 */
body {
  font-family: Arial, Helvetica, sans-serif;
}

.pill-nav a {
  display: inline-block;
  color: black;
  text-align: center;
  padding: 14px;
  text-decoration: none;
  font-size: 17px;
  border-radius: 5px;
}

.pill-nav a:hover {
  background-color: #ddd;
  color: black;
}

.pill-nav a.active {
  background-color: #B80000;
  color: white;
}
/* 게시판 디자인 */
table {
  border-collapse: collapse;
  border-spacing: 0;
  width: 100%;
  border: 1px solid #ddd;
}

th, td {
  text-align: left;
  padding: 16px;
}

tr:nth-child(even) {
  background-color: #E6E0EC;
}

button {
  background-color: #005072;
  color: white;
  padding: 12px 20px;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:hover {
  background-color: #B80000;
}

a{
	text-decoration: none;
	color: black;
}

a:hover {
	color: #B80000;
}

.pageNum{
	font-size:12pt;
	color: #5C5E60;
	font-weight:bold;
}
</style>
</head>
<body>
<!-- 글씨체 변경가능!!!  -->
<h2 style="font-family:맑은 고딕;">공지/뉴스</h2>
<p>COBOX의 주요한 이슈 및 여러가지 소식들을 확인하실 수 있습니다</p>

<div class="pill-nav" style="border-bottom:2px solid black;">
	<a class="active" href="#home">전체</a>
	<a href="#news">시스템점검</a>
	<a href="#contact">극장</a>
	<a href="#about">기타</a>
</div>

<p>총 <%=noticeList.size() %>건이 검색되었습니다.</p>

	<table>
		<tr>
			<th>No.</th>
			<th>구분</th>
			<th>제목</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
		<% 
			int curPos=pager.getCurPos();
			int num = pager.getNum();
		%>
		<%for(int i=1; i<pager.getPageSize();i++){ %>
		<%if(num<1)break; %>
			<%Notice notice = noticeList.get(curPos++); %>
			<tr>
				<td><%=num-- %></td>
				<td><%=notice.getDivision().getDname() %></td>
				<td><a href="/admin/notice/detail?notice_id=<%=notice.getNotice_id() %>"><%=notice.getTitle() %></a></td>
				<td><%=notice.getRegdate().substring(0, 10)%></td>
				<td><%=notice.getHit() %></td>
			</tr>
		<%} %>
		<tr>
			<td colspan="5" style="text-align: center">
			<%for(int i=pager.getFirstPage();i<=pager.getLastPage();i++){ %>
			<%if(i>pager.getTotalPage()) break; %>
				<a <%if(pager.getCurrentPage()==i){ %>class="pageNum"<%} %> href="/admin/notice/list?currentPage=<%=i%>">[<%=i %>]</a>
			<%} %>
			</td>
		</tr>
		<tr>
			<td colspan="5">
				<button onclick="location.href='registform'">글등록</button>
			</td>
		</tr>
	</table>

</body>
</html>
