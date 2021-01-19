package com.koreait.cobox.model.member.repository;

import java.util.List;

import com.koreait.cobox.model.domain.Member;

public interface MemberDAO {
	public List selectAll();//��� ȸ����������
	public Member select(Member member); //ȸ��1�� ��������
	public void insert(Member member);//ȸ�����
	public void update(Member member); //ȸ������ ����
	public void delete(Member member); //ȸ��Ż��
	
	public int idChk(Member member);//���̵� �ߺ�üũ
	public int passChk(Member member);//�н����� �ߺ�üũ
	
}
