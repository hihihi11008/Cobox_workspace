package com.koreait.cobox.model.notice.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.cobox.exception.NoticeDeleteException;
import com.koreait.cobox.exception.NoticeEditException;
import com.koreait.cobox.exception.NoticeRegistException;
import com.koreait.cobox.model.domain.Notice;

@Repository
public class MybatisNoticeDAO implements NoticeDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<Notice> selectAll() {
		List<Notice> noticeList = sqlSessionTemplate.selectList("Notice.selectAll");
		return noticeList;
	}

	@Override
	public Notice select(int notice_id) {
		Notice notice = sqlSessionTemplate.selectOne("Notice.select", notice_id);
		return notice;
	}

	@Override
	public void insert(Notice notice) throws NoticeRegistException{
		int result = sqlSessionTemplate.insert("Notice.insert", notice);
		if (result==0) {
			throw new NoticeRegistException("������ ��Ͽ� �����Ͽ����ϴ�.");
		}
	}

	@Override
	public void update(Notice notice) throws NoticeEditException{
		int result = sqlSessionTemplate.update("Notice.update", notice);
		if (result==0) {
			throw new NoticeEditException("������ ���� �����Ͽ����ϴ�.");
		}
	}

	@Override
	public void delete(Notice notice) throws NoticeDeleteException{
		int result = sqlSessionTemplate.delete("Notice.delete", notice);
		if (result==0) {
			throw new NoticeDeleteException("������ ���� �����Ͽ����ϴ�.");
		}
	}

	@Override
	public void noticeHit(int notice_id) throws NoticeEditException{
		int result = sqlSessionTemplate.update("Notice.noticeHit", notice_id);
		if (result==0) {
			throw new NoticeEditException("��ȸ�� ���� �����Ͽ����ϴ�.");
		}
	}

	@Override
	public List<Notice> selectAllById(int division_id) {
		return sqlSessionTemplate.selectList("Notice.selectAllById", division_id);
	} 
}