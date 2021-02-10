<%@ page contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html>
<head>
<%@ include file="../inc/header.jsp"%>
<script>
//회원가입 버튼을 누르면
	$(function(){
		//회원가입 처리 
		$(".signupbtn").click(function(){
			regist();
		});	
	});
	
	//요청이 완료되는 시점에 프로그래스바를 감춘다!!
	function regist(){
		//form 태그의 파라미터들을 전송할수있는 상태로 둬야  data키값에 form 자체를 넣을 수 있다.
		var formData = $("#member-form").serialize(); //전부 문자열화 시킨다!!
		
		$.ajax({
			url:"/client/member/regist",
			type:"post",
			data:formData,
			success:function(responseData){
				//데이터를 받으면 문구없애기
				var json = JSON.parse(responseData);
				if(json.result==1){
					alert("회원가입이 완료되었습니다.");
					location.href="/client/member/loginForm"; //로그인 페이지
				}else{
					alert("회원가입에 실패했습니다. \n 다시 시도해주세요.");
				}
			}
		});
	}
	
	//아이디랑 비번이 맞지 않는 경우 가입버튼 비활성화를 위한 변수 설정 
	var idChk=0;
	var passChk=0;
	//아이디 체크하여 가입버튼 비활성화, 중복확인 
	function idCheck(){
		var inputId = $("#mid").val();
		//alert(inputId);
		var hoho = "gabi";
		$.ajax({
			url : "/client/member/idChk",
			type : "post", 
			data: inputId,
			dataType: "json",
            contentType: "application/json; charset=UTF-8",
			success:function(result){
				if (inputId=="" && result=='0') {
					$(".signupbtn").prop("disabled", true);
					$(".signupbtn").css("background-color", "#aaaaaa"); //회
					$("#mid").css("background-color", "#FFCECE"); //빨 
					idChk=0;
				} else if(result=='0'){
					$("#mid").css("background-color", "#B0F6AC"); //초
					idChk=1;
					if (idChk==1 && passChk==1) {
						$(".signupbtn").prop("disabled", false);
						$(".signupbtn").css("background-color", "#4CAF50");
					}
				} else if(result=="1"){
					$(".signupbtn").prop("disabled", true);
                    $(".signupbtn").css("background-color", "#aaaaaa");
                    $("#mid").css("background-color", "#FFCECE");
                    idChk = 0;
				}
			}
		});
	}
	
	//재입력 비밀번호 체크해서 가입버튼 비활성화 또는 맞지않음을 알려줌
	function passCheck(){
		var pass = $("#password").val();
        var repass = $("#psw-repeat").val();
        if(repass=="" && (pass != repass || pass == repass)){
            $(".signupbtn").prop("disabled", true);
            $(".signupbtn").css("background-color", "#aaaaaa");
            $("#psw-repeat").css("background-color", "#FFCECE");
        } else if (pass == repass) {
            $("#psw-repeat").css("background-color", "#B0F6AC");
            passChk = 1;
            if(idChk==1 && passChk == 1) {
                $(".signupbtn").prop("disabled", false);
                $(".signupbtn").css("background-color", "#4CAF50");
                signupCheck();
            }
        } else if (pass != repass) {
        	passChk = 0;
            $(".signupbtn").prop("disabled", true);
            $(".signupbtn").css("background-color", "#aaaaaa");
            $("#psw-repeat").css("background-color", "#FFCECE");
            
        }
	}
	
	 //닉네임과 이메일 입력하지 않았을 경우 가입버튼 비활성화
    function signupCheck() {
        var phone = $("#phone").val();
        var name = $("#name").val();
        if(name=="" || phone=="") {
            $(".signupbtn").prop("disabled", true);
            $(".signupbtn").css("background-color", "#aaaaaa");
        }
    }

</script>
</head>
<body class="single-cin">
	<div class="wrapper">
		<%@ include file="../inc/top.jsp"%>
		<!-- ------------------------------------------------------------------------------------------- -->
		<form id="member-form" style="border:1px solid #ccc">
			<div class="container">
				<h1>회원가입</h1>
				<hr>
				
				<label><b>ID</b></label>
				<input type="text" placeholder="Enter ID" id="mid" name="mid" oninput="idCheck()">
				
				<label><b>Password</b></label>
				<input type="password" placeholder="Enter Password" id="password" name="password" oninput="passCheck()">
				
				<label><b>Repeat Password</b></label>
				<input type="password" placeholder="Repeat Password" id="psw-repeat" name="psw-repeat" oninput="passCheck()">
				
				<label><b>Name</b></label>
				<input type="text" placeholder="Enter Name" id="name" name="name">
				  
				<label><b>Phone</b></label>
				<input type="text" placeholder="Enter Phone" id="phone" name="phone">
				  
				<label id="email"><b>Email</b></label>
				<input id="email_id" type="text" placeholder="Enter Email" name="email_id">@
				<select id="email_server" name="email_server">
					<option>naver.com</option>
					<option>gmail.com</option>
					<option>nate.com</option>
				</select>
				
				<label id="birth2"><b>Birth</b></label>
				<input type="date" id="birth" name="birth" value="2021-01-01">
				
				<div class="clearfix">
					<button type="reset" class="cancelbtn">Reset</button>
					<button type="button" class="signupbtn" disabled="disabled">Sign Up</button>
				</div>
			</div>
		</form>
		<!-- ------------------------------------------------------------------------------------------- -->
		<%@include file="../inc/footer.jsp"%>
	</div>
	<%@include file="../inc/script.jsp"%>
<!-- 	
<script src="/resources/js/custom.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		init_Home();
	});
</script> 
-->
</body>
</html>
