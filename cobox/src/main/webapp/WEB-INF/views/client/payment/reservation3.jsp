<%@ page contentType="text/html; charset=UTF-8"%>
<!doctype html>
<html>
<head>
<%@ include file="../inc/header.jsp"%>
<style type="text/css">
.button {
  border-radius: 4px;
  background-color: #733B74;
  border: none;
  color: #FFFFFF;
  text-align: center;
  font-size: 15px;
  padding: 3px;
  width: 200px;
  transition: all 0.5s;
  cursor: pointer;
  margin: 5px;
}

.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}

.button:hover span {
  padding-right: 25px;
}

.button:hover span:after {
  opacity: 1;
  right: 0;
}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
var buttonID;

function reply_click(obj){
	buttonID=$(obj).attr("id");
	var $except =$('#payMethod').find('div.'+buttonID);
	//alert(buttonID);
	$('#'+buttonID).click(function(){
		//alert("안녕");
		if ($('.'+buttonID).css("display")=="none") {
			$('.'+buttonID).show();
			$("#payMethod").find('div').not($except).css({
				"display" : "none"
			});
		}
	});
}



</script>
</head>
<body class="single-cin">
	<div class="wrapper">
		<%@include file="../inc/top.jsp"%>
		<!-- Main content -->		
 	<section class="container">
 	<h2 class="page-heading">Reservation</h2>
       <div class="order-step-area">
           <div class="order-step first--step order-step--disable ">1.영화/상영관/날짜</div>
           <div class="order-step second--step order-step--disable">2.좌석선택</div>
           <div class="order-step third--step">3.결제하기</div>
       </div>

       <div class="col-sm-12">
           <div class="checkout-wrapper">
               <h2 class="page-heading">price</h2>
               <ul class="book-result">
                   <li class="book-result__item">Tickets: <span class="book-result__count booking-ticket">3</span></li>
                   <li class="book-result__item">One item price: <span class="book-result__count booking-price">$20</span></li>
                   <li class="book-result__item">Total: <span class="book-result__count booking-cost">$60</span></li>
               </ul>
               
				<div class="pay-select">
				<h2 class="page-heading">Choose payment method</h2>
					<!-- <a href="#" class="btn btn-sm btn-warning">신용카드</a> -->
					<button id="CreditCard" class="button" onclick="reply_click(this)"><span>신용카드 </span></button>
					<button id="WithoutABankbook" class="button" onclick="reply_click(this)"><span>무통장입금 </span></button>
					<button id="CreditTransfer" class="button" onclick="reply_click(this)"><span>실시간계좌이체 </span></button>
					<button id="CellPhone" class="button" onclick="reply_click(this)"><span>휴대폰결제 </span></button>
					<button id="OnSite" class="button" onclick="reply_click(this)"><span>현장결제 </span></button>
				</div>
				
			<div id=payMethod>
				<div class="CreditCard" style="display: none;">
					<h4>신용카드 결제정보</h4>
					<table>
						<caption>신용카드 결제정보</caption>
						<colgroup>
						<col style="width:18%;" />
						</colgroup>
						<tbody>
							<tr>
								<th><label>카드종류</label></th>
								<td>
									<select>
										<option value="0">카드선택</option>
										<option value="1">롯데카드</option>
										<option value="2">신한카드</option>
										<option value="3">현대카드</option>
										<option value="4">삼성카드</option>
										<option value="5">우리카드</option>
										<option value="6">국민카드</option>
										<option value="7">신한카드</option>
									</select>
									<div>
										<ul>
											<li> 카카오뱅크 체크카드 이용 시, [국민카드]를 선택하세요.</li>
											<li> 카드에 BC마크가 있는 경우, [BC카드]를 선택하세요.</li>
											<li> 구LG카드는 [신한카드]를 선택하세요.</li>
										</ul>
									</div>
								</td>
							</tr>
							<tr>
								<th><label>할부기간</label></th>
								<td>
									<select>
										<option value="0">할부선택</option>
										<%-- <%if(넘오오는 금액이 >5만이상이면 ){ %> --%>
										<option value="1">무이자할부</option>
										<option value="2">일반할부</option>
										<%-- <%} %> --%>
									</select>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				
				
				<div class="WithoutABankbook" style="display: none;">
					<h4>무통장입금 결제정보</h4>
					<table>
						<caption>무통장입금 결제정보</caption>
						<colgroup>
							<col style="width:18%;" />
						</colgroup>
						<tbody>
							<tr>
								<th><label>은행명</label></th>
								<td>
									<select>
										<option value="">은행선택</option>
										<option value="004">국민은행</option>
										<option value="011">농협은행</option>
										<option value="026">신한은행</option>
										<option value="020">우리은행</option>
										<option value="005">KEB하나은행</option>
										<option value="003">기업은행</option>
										<option value="071">우체국</option>
										<option value="023">SC제일은행</option>
										<option value="027">씨티은행</option>
										<option value="037">전북은행</option>
										<option value="032">부산은행</option>
										<option value="039">경남은행</option>
										<option value="031">대구은행</option>
										<option value="034">광주은행</option>
									</select>
								</td>
							</tr>
							<tr>
								<th scope="row"><label for="remitter">입금자</label></th>
									<td><input type="text" name="remitter" class="txt" value="김지언" style="width:115px;" title="입금자" /></td>
								</tr>
								<tr>
									<th scope="row">입금기한</th>
									<td id="depositDeadlineWhole">
										<strong class="point">2021년 01월 14일</strong>
										<p class="mgt5">* 주문일 기준, 다음날까지 미입금 시 자동 취소됩니다.<br />&nbsp;&nbsp;(토,일,공휴일 제외)</p>
									</td>
								</tr>
						</tbody>
					</table>
				</div>
				
				<div class="CreditTransfer" style="display: none;">
					<h4>실시간 계좌이체 결제정보</h4>
					<table>
						<caption>실시간 계좌이체 결제정보</caption>
						<colgroup>
							<col style="width:17%;" />
							<col />
						</colgroup>
						<tbody>
							<tr>
								<td>
									<p>* [결제하기] 버튼을 클릭하면  KSNet의 계좌이체 결제 창으로 연결<br/>되며 결제 창에서 결제정보(은행/계좌번호)를 입력하실 수 있습니다.</p>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				
				<div class="CellPhone" style="display: none;">
				<h4>휴대폰 결제정보</h4>
					<table>
						<caption>휴대폰 결제정보</caption>
						<colgroup>
							<col style="width:17%;" />
							<col />
						</colgroup>
						<tbody>
							<tr>
								<td>
									<p>* [결제하기] 버튼을 클릭시, 휴대폰 결제 화면으로 연결되어<br/>결제정보를 입력하실 수 있습니다.</p>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				
				<div class="OnSite" style="display:none;">
				<h4>현장결제</h4>
					<table>
						<caption>현장결제</caption>
						<colgroup>
							<col style="width:17%;" />
							<col />
						</colgroup>
						<tbody>
							<tr>
								<td>
									<p>* [결제하기] 버튼을 클릭시, 예매화면으로 넘어가며<br/>현장에서 결제할 수 있습니다.</p>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>


               <h2 class="page-heading">Contact information</h2>
       
               <form id='contact-info' method='post' novalidate="" class="form contact-info">
                   <div class="contact-info__field contact-info__field-mail">
                       <input type="text" name='user-name' placeholder='Your name' class="form__mail">
                   </div>
                   <div class="contact-info__field contact-info__field-mail">
                       <input type='email' name='user-mail' placeholder='Your email' class="form__mail">
                   </div>
                   <div class="contact-info__field contact-info__field-tel">
                       <input type='tel' name='user-tel' placeholder='Phone number' class="form__mail">
                   </div>
               </form>
           </div>
           <div class="order">
               <a href="/client/movie/reservationfinal" class="btn btn-md btn--warning btn--wide">결제하기</a>
           </div>
       </div>
   </section>

   <div class="booking-pagination">
           <a href="book2.html" class="booking-pagination__prev">
               <p class="arrow__text arrow--prev">prev step</p>
               <span class="arrow__info">좌석선택</span>
           </a>
   </div>
	<%@include file="../inc/footer.jsp" %>
	</div>
	<%@include file="../inc/script.jsp"%>
</body>
</html>
