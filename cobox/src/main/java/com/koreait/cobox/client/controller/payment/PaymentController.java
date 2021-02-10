package com.koreait.cobox.client.controller.payment;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.cobox.model.common.MessageData;
import com.koreait.cobox.model.domain.Member;
import com.koreait.cobox.model.domain.ResSummary;
import com.koreait.cobox.model.domain.Reservation;
import com.koreait.cobox.model.domain.Schedule;
import com.koreait.cobox.model.payment.service.PaymentService;
@Controller
public class PaymentController {
	private static final Logger logger=LoggerFactory.getLogger(PaymentController.class);
	
	@Autowired
	private PaymentService paymentService;
	
	/********************************************************
		결제업무
	 ********************************************************/


	//결제페이지 요청
	@GetMapping("/movie/reservation3")
	public String getPayment(HttpSession session, Model model) {
	//결제수단 가져오기 
	List paymethodList = paymentService.selectPaymethodList();
	model.addAttribute("paymethodList", paymethodList);
	
	//예약정보 가져오기 (session에 담아서 받아온다) 
	session.getAttribute("schedule");//schedule_id
	session.getAttribute("seat");//seat_id
	session.getAttribute("seatQuantity");//seat_quantity
	
	return "client/payment/reservation3";
	}
	
	//결제요청 처리 
	@PostMapping("/movie/reservation/regist")
	public ModelAndView pay(HttpSession session, ResSummary payment,Reservation reservation,Schedule schedule) {
	logger.debug("결제방법은? "+payment.getPaymethod_id());
	logger.debug("total_price? "+payment.getTotal_price());
	logger.debug("tota_pay? "+payment.getTotal_pay());
	
	//넘겨받은 파라미터를 reservation...에 심어주자 
	Member member= (Member)session.getAttribute("member");
	payment.setMemeber_id(member.getMember_id());
	
	paymentService.registReservation(payment,reservation,schedule);
	
	//결제 완료됐다는  메시지를 보고싶다면 message.jsp로 응답 
	MessageData messageData = new MessageData();
	messageData.setResultCode(1);
	messageData.setMsg("예매가 완료되었습니다. " );
	messageData.setUrl("/movie/reservationfinal");
	
	
	ModelAndView mav = new ModelAndView();
	mav.addObject("messageData", messageData);
	mav.setViewName("client/error/message");
	//음... final부분에 또 넘겨야하나 ..? 받아야지정보를 ... session에 담나 또? ㅋㅋㅋ 똑같이 반복 ?? 2-3 하듯이 
	
	return mav;
	}
	
	//마지막 총 예매티켓페이지! 
	@GetMapping("/movie/reservationfinal")
	public String getReservation() {
	return "client/payment/reservationfinal";
	}
}
