package com.koreait.cobox.model.notice.repository;

import java.util.List;

import com.koreait.cobox.model.domain.Notice;

public interface NoticeDAO {
	public List<Notice> selectAll(); //���� ��ü�� ��������
	public Notice select(int notice_id); // ���� 1�� ��������
	public List<Notice> selectAllById(int division_id); // ���а��� ���� ���������� ��������
	public void insert(Notice notice); //1�� ����ϱ�
	public void update(Notice notice); // 1�� �����ϱ� 
	public void noticeHit(int notice_id); //��ȸ�� �ø���
	public void delete(Notice notice); // 1�� �����ϱ� (�����ϴٸ� �����ڸ� ���� �����ϵ���)
	
}
