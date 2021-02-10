package com.koreait.cobox.model.member.service;

import java.util.List;


import com.koreait.cobox.model.domain.Member;

public interface MemberService {
	public List selectAll();//��� ȸ������Ʈ �ҷ�����
	public Member select(Member member); //ȸ��1�� �ҷ�����
	public void insert(Member member);//ȸ�����
	public void update(Member member); //ȸ����������
	public void delete(Member member); //ȸ����������
	
	public int idChk(String mid);//ȸ�� ���̵�üũ
	public int passChk(Member member);//ȸ�� ��й�ȣüũ
}
