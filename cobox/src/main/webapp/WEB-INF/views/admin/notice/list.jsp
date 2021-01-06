<%@ page contentType="text/html; charset=UTF-8"%>
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
  background-color: red;
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
  background-color: #f2f2f2;
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

<p>총 100건이 검색되었습니다.?</p>

<table>
  <tr>
    <th>No.</th>
    <th>구분</th>
    <th>제목</th>
    <th>등록일</th>
    <th>조회수</th>
  </tr>
  <tr>
    <td>Jill</td>
    <td>Smith</td>
    <td>50</td>
  </tr>
  <tr>
    <td>Eve</td>
    <td>Jackson</td>
    <td>94</td>
  </tr>
  <tr>
    <td>Adam</td>
    <td>Johnson</td>
    <td>67</td>
  </tr>
</table>

</body>
</html>
