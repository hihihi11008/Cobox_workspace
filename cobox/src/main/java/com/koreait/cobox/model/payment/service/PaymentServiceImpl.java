/********************************************************
 	��������
 ******************************************************/
package com.koreait.cobox.model.payment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.cobox.model.domain.ResSummary;
import com.koreait.cobox.model.domain.Reservation;
import com.koreait.cobox.model.payment.repository.PaymethodDAO;
import com.koreait.cobox.model.payment.repository.ResSummaryDAO;
import com.koreait.cobox.model.reservation.repository.ReservationDAO;

@Service
public class PaymentServiceImpl implements PaymentService{
	@Autowired
	private PaymethodDAO paymethodDAO;
	
	//�������� 2���� DAO(ResSummary,Reservation)
	@Autowired
	private ResSummaryDAO resSummaryDAO;
	
	@Autowired
	private ReservationDAO reservationDAO;

	//�������ܸ���Ʈ �ҷ�����
	@Override
	public List selectPaymethodList() {
		return paymethodDAO.selectAll();
	}
	
	//�ֹ���� 
	@Override
	public void registReservation(ResSummary resSummary, Reservation reservation) {
		//�ֹ����� ���(ResSummay)
		resSummaryDAO.insert(resSummary);
		
		//����� �ֹ���ȣ�� reservation�� �־�����Ѵ� 
		reservation.setRes_summary_id(resSummary.getRes_summay_id());
		
		//�������� ���(Reservation)-�츮�� ��ٱ������̺��� �����Ƿ� detail(Reservation)�� �Ѱܹ޾Ƽ� insert�ؾ���
		reservationDAO.insert(reservation);
	}
}
