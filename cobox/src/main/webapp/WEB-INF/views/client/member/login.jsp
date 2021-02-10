<%@ page contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html>
<head>
<style type="text/css">
<%@include file="/resources/css/login.css" %>
</style>
<%@ include file="../inc/header.jsp"%>
<script>
$(function(){
	$("#loginBtn").click(function(){
		alert();
		$("form").attr({
			action : "/client/member/login",
			method : "post"
		});
		$("form").submit();
	});
});
</script>
</head>
<body class="single-cin">
	<div class="wrapper">
		<%@ include file="../inc/top.jsp"%>
		<!-- -------------------------------------------------------------------- -->
		<div class="loginContainer">
			<form>
				<div class="row">
					<h2 style="text-align:center">Login</h2>
					<div class="vl">
						<span class="vl-innertext">or</span>
					</div>
				
					<div class="col">
					<!-- 
						<img src="/resources/images/member/kakao_login.png">
						<img src="/resources/images/member/naver_login.PNG">
					-->
						<a href="#" class="fb btn">
							<i class="fa fa-facebook fa-fw"></i> Login with Facebook
						</a>
						<a href="#" class="twitter btn">
							<i class="fa fa-twitter fa-fw"></i> Login with Twitter
						</a>
						<a href="#" class="google btn"><i class="fa fa-google fa-fw">
							</i> Login with Google+
						</a>
					</div>
					
					<div class="col">
						<div class="hide-md-lg">
							<p>Or sign in manually:</p>
						</div>
						
						<input type="text" name="mid" placeholder="Username" required>
						<input type="password" name="password" placeholder="Password" required>
						<input id="loginBtn" type="button" value="Login">
					</div>
				    
				</div>
			</form>
		</div>

		<div class="bottom-container">
			<div class="row">
				<div class="col">
					<a href="/client/member/registForm" style="color:white" class="btn">Sign up</a>
				</div>
				<div class="col">
					<a href="#" style="color:white" class="btn">Forgot password?</a>
				</div>
			</div>
		</div>
		<!-- -------------------------------------------------------------------- -->
		<%@include file="../inc/footer.jsp"%>
	</div>
	<%@include file="../inc/script.jsp"%>
</body>
</html>
