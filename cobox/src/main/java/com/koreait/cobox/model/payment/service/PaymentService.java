package com.koreait.cobox.model.payment.service;

import java.util.List;

import com.koreait.cobox.model.domain.ResSummary;
import com.koreait.cobox.model.domain.Reservation;

public interface PaymentService {
	/*��������*/ 
	public List selectPaymethodList();//�������� �������� 
	public void registReservation(ResSummary  resSummary,Reservation reservation); //������û ó�� (Ʈ������ó��!)
}
