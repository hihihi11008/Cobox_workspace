package com.koreait.cobox.model.notice.service;

import java.util.List;

import com.koreait.cobox.model.domain.Notice;

public interface NoticeService {
	public List<Notice> selectAll(); //���� ��ü�� ��������
	public List<Notice> selectAllById(int division_id); // ���а��� ���� ��������Ʈ ��������
	public Notice select(int notice_id); // ���� 1�� ��������
	public void insert(Notice notice); //1�� ����ϱ�
	public void update(Notice notice); // 1�� �����ϱ� 
	public void noticeHit(int notice_id); // ��ȸ�� ���� 
	public void delete(Notice notice); // 1�� �����ϱ�
	
}
