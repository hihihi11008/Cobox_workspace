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
		��������
	 ********************************************************/


	//���������� ��û
	@GetMapping("/movie/reservation3")
	public String getPayment(HttpSession session, Model model) {
	//�������� �������� 
	List paymethodList = paymentService.selectPaymethodList();
	model.addAttribute("paymethodList", paymethodList);
	
	//�������� �������� (session�� ��Ƽ� �޾ƿ´�) 
	session.getAttribute("schedule");//schedule_id
	session.getAttribute("seat");//seat_id
	session.getAttribute("seatQuantity");//seat_quantity
	
	return "client/payment/reservation3";
	}
	
	//������û ó�� 
	@PostMapping("/movie/reservation/regist")
	public ModelAndView pay(HttpSession session, ResSummary payment,Reservation reservation,Schedule schedule) {
	logger.debug("���������? "+payment.getPaymethod_id());
	logger.debug("total_price? "+payment.getTotal_price());
	logger.debug("tota_pay? "+payment.getTotal_pay());
	
	//�Ѱܹ��� �Ķ���͸� reservation...�� �ɾ����� 
	Member member= (Member)session.getAttribute("member");
	payment.setMemeber_id(member.getMember_id());
	
	paymentService.registReservation(payment,reservation,schedule);
	
	//���� �Ϸ�ƴٴ�  �޽����� ����ʹٸ� message.jsp�� ���� 
	MessageData messageData = new MessageData();
	messageData.setResultCode(1);
	messageData.setMsg("���Ű� �Ϸ�Ǿ����ϴ�. " );
	messageData.setUrl("/movie/reservationfinal");
	
	
	ModelAndView mav = new ModelAndView();
	mav.addObject("messageData", messageData);
	mav.setViewName("client/error/message");
	//��... final�κп� �� �Ѱܾ��ϳ� ..? �޾ƾ��������� ... session�� �㳪 ��? ������ �Ȱ��� �ݺ� ?? 2-3 �ϵ��� 
	
	return mav;
	}
	
	//������ �� ����Ƽ��������! 
	@GetMapping("/movie/reservationfinal")
	public String getReservation() {
	return "client/payment/reservationfinal";
	}
}
