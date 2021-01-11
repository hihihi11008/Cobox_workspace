<%@page import="com.koreait.cobox.model.common.Pager"%>
<%@page import="com.koreait.cobox.model.domain.Notice"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<% 
	List<Notice> noticeList= (List<Notice>)request.getAttribute("noticeList");
	
	Pager pager = new Pager();
	pager.init(request, noticeList);
%>
<!doctype html>
<html>
<head>
<%@ include file="../inc/header.jsp"%>
<style type="text/css">
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
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
	getDivisionList();
}); 

/* 비동기 방식으로 구분리스트 가져오기  */
function getDivisionList(){
	//alert("안녕");
	$.ajax({
		url:"/client/notice/divisionlist",
		type:"get",
		success:function(result){
			$(".pill-nav").empty();
			$(".pill-nav").append("<a href=\"/client/notice/noticelist\" class=\"active\">전체</a>");

			for (var i = 0; i < result.length; i++) {
				var division = result[i];
				$(".pill-nav").append("<a href=\"/client/notice/noticelist2?division_id="+division.division_id+"\">"+division.dname+"</a>")

			}
		}
	});
}
</script>
</head>
<body class="single-cin">
	<div class="wrapper">
	<%@ include file="../inc/top.jsp" %>
	<!-- Main content -->
        <section class="container">
            <div class="overflow-wrapper">
                <div class="col-sm-12">
                
                    <h2 class="page-heading">공지사항</h2>
                    <p>COBOX의 주요한 이슈 및 여러가지 소식들을 확인하실 수 있습니다</p>
                    <div class="pill-nav" style="border-bottom:2px solid black;">
						<a  class="active" href="#home">전체</a>
					</div>
                    <!-- News post article-->
                    <% 
						int curPos=pager.getCurPos();
						int num = pager.getNum();
					%>
					<%for(int i=1; i<=pager.getPageSize();i++){ %>
					<%if(num<1)break; %>
					<%Notice notice = noticeList.get(curPos++); %>
                    <article class="post post--news">
                        <h1><a href="/client/notice/noticedetail?notice_id=<%=notice.getNotice_id() %>" class="post__title-link"><%=notice.getTitle() %></a> <h6><%=notice.getDivision().getDname() %></h6></h1> 
                        <p class="post__date"><%=notice.getRegdate().substring(0, 10)%> </p>
                        <div class="wave-devider"></div>
                        <p class="post__text"><%=notice.getContents() %></p> 
                        <div class="devider-huge"></div>
                    </article> 
                    <%} %>
                    <!-- end news post article-->
                     <div class="pagination">
                   	    <a href='#' class="pagination__prev">prev</a>
							<div class="pagination" align="center">
                        	<%for(int i=pager.getFirstPage();i<=pager.getLastPage();i++){ %>
							<%if(i>pager.getTotalPage()) break; %>
							<a <%if(pager.getCurrentPage()==i){ %>class="pageNum"<%} %> href="/client/notice/list?currentPage=<%=i%>">[<%=i %>]</a>
                        	<%} %>
                        	</div>
                        <a href='#' class="pagination__next">next</a>
                    </div>
                </div>
            </div>
        </section>
    <%@include file="../inc/footer.jsp" %>
	</div>
	<%@include file="../inc/script.jsp"%>
	<!-- Custom -->
	<script type="text/javascript">
		$(document).ready(function() {
			init_Home();
		});
	</script>
</body>
</html>
