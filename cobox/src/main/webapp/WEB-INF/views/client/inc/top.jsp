<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import ="com.koreait.cobox.model.domain.Member" %>
<!-- Banner -->
<div class="banner-top">
	<img alt='top banner' src="/resources/images/banners/bra.jpg">
</div>
<!-- Header section -->
<header class="header-wrapper">
	<div class="container">
		<!-- Logo link-->
		<a href='/' class="logo"> <img alt='logo'
			src="/resources/images/logo.png">
		</a>

		<!-- Main website navigation-->
		<nav id="navigation-box">
			<!-- Toggle for mobile menu mode -->
			<a href="#" id="navigation-toggle"> <span class="menu-icon">
					<span class="icon-toggle" role="button"
					aria-label="Toggle Navigation"> <span class="lines"></span>
				</span>
			</span>
			</a>

			<!-- Link navigation -->
			<ul id="navigation">
				<li><span class="sub-nav-toggle plus"></span> <a
					href="/client/movie/list">영화</a></li>
				<li><span class="sub-nav-toggle plus"></span> <a
					href="/client/movie/reservation">영화예매</a></li>
				<li><span class="sub-nav-toggle plus"></span> <a
					href="/client/movie/snack">스낵</a></li>
				<li><span class="sub-nav-toggle plus"></span> <a
					href="/client/notice/list">공지사항</a></li>
			</ul>
		</nav>

		<!-- Additional header buttons / Auth and direct link to booking-->
		<div class="control-panel">
		<%
			if(session.getAttribute("member")==null){
		%>
			<a href="/client/member/formtable" id="login" style="color: #ffffff; width: 17px; height: 20px; background-color: #F2A14B; border-radius: 3px; font: 12px 'aleobold', sans-serif; text-transform: uppercase; transition: 0.5s; padding: 7px 20px; margin-top: 30px;">Login</a>
		<%
			}else{
		%>	
			<a href="/client/member/logoutfrom" id="logout" style="color: #ffffff; width: 17px; height: 20px; background-color: #F2A14B; border-radius: 3px; font: 12px 'aleobold', sans-serif; text-transform: uppercase; transition: 0.5s; padding: 7px 20px; margin-top: 30px;">Logout</a>
		<%} %>
		</div>

	</div>
	<!-- 
	<script>
	$(document).ready(function(){
		$("#logout").on("click", function(){
			location.href="/client/member/logout";
		})
		
	})
	</script>
	 -->
</header>