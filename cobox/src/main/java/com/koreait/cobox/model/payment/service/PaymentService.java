package com.koreait.cobox.model.payment.service;

import java.util.List;

import com.koreait.cobox.model.domain.ResSummary;
import com.koreait.cobox.model.domain.Reservation;

public interface PaymentService {
	/*결제업무*/ 
	public List selectPaymethodList();//결제수단 가져오기 
	public void registReservation(ResSummary  resSummary,Reservation reservation); //결제요청 처리 (트랜젝션처리!)
}
