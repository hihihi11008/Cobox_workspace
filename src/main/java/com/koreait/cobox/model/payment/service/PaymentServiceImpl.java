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
		
		//����� �ֹ���ȣ�� reservation�� �־�����Ѵ�   (���Ծ���� ...��ü�ȿ� ���̵�... )
		/* reservation.setRes_summary_id(resSummary.getRes_summay_id()); */
		reservation.setResSummary(resSummary);
		
		//�������� ���(Reservation)-�츮�� ��ٱ������̺��� �����Ƿ� detail(Reservation)�� �Ѱܹ޾Ƽ� insert�ؾ���
		reservationDAO.insert(reservation);
	}

	@Override
	public ResSummary selectById(int res_summary_id) {
		return resSummaryDAO.selectById(res_summary_id);
	}

	@Override
	public void update(ResSummary resSummary) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ResSummary resSummary) {
		// TODO Auto-generated method stub
		
	}
}
