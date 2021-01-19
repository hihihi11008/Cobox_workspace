package com.koreait.cobox.model.payment.service;

import java.util.List;

import com.koreait.cobox.model.domain.ResSummary;
import com.koreait.cobox.model.domain.Reservation;

public interface PaymentService {
	/*��������*/ 
	public List selectPaymethodList();//�������� �������� 
	public ResSummary selectById(int res_summary_id); // �Ѱ��� �������� 
	public void registReservation(ResSummary  resSummary,Reservation reservation); //������û ó�� (Ʈ������ó��!)
	public void update(ResSummary resSummary); // ���� ���� .... ����.. ?? ? ���� ����??
	public void delete(ResSummary resSummary); // ȯ�� ...? 
}