package com.koreait.cobox.model.member.repository;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.cobox.exception.MemberDeleteException;
import com.koreait.cobox.exception.MemberEditException;
import com.koreait.cobox.exception.MemberNotFoundException;
import com.koreait.cobox.exception.MemberRegistException;
import com.koreait.cobox.model.domain.Member;

@Repository
public class MybatisMemberDAO implements MemberDAO {
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List selectAll() {
		return null;
	}

	@Override
	public Member select(Member member) throws MemberNotFoundException {
		Member obj = sqlSessionTemplate.selectOne("Member.select", member); //���⼭ ���ü� �ִ� ���  selectOne �� �Ἥ ������ ������ 
		if (obj == null) {// ���Ե��� ���� ������ �α����� �Ϸ��� �ϸ�
			throw new MemberNotFoundException("���� �� ������ �����ϴ�.");
		}
		return obj;
	}

	@Override
	public void insert(Member member) throws MemberRegistException {
		int result = sqlSessionTemplate.insert("Member.insert", member);
		if (result == 0) {// ȸ������ �� ���� ���� ������ �Է��ϸ�
			throw new MemberRegistException("ȸ�����Կ� �����Ͽ����ϴ�.");
		}
	}

	@Override
	public void update(Member member) throws MemberEditException {
		int result = sqlSessionTemplate.update("Member.update", member);
		if (result != 1) {// ȸ�������߿� ������ �� ä������ �ƴ϶��
			throw new MemberEditException("���������� �����߽��ϴ�.");
		}
	}

	@Override
	public void delete(Member member) throws MemberDeleteException {
		int result = sqlSessionTemplate.delete("Member.delete", member.getMember_id());
		if (result == 0) {// ȸ������ �� ���� ���� ������ �Է��ϸ�
			throw new MemberRegistException("ȸ��Ż�� �����߽��ϴ�.\n ���̵�� ��й�ȣ�� Ȯ�����ּ���.");
		}
	}

	//���̵� �ߺ�üũ
	@Override
	public int idChk(Member member) throws MemberNotFoundException {
		int result = sqlSessionTemplate.selectOne("memberMapper.idChk", member);
		return result;
	}

	@Override
	public int passChk(Member member) {
		int result = sqlSessionTemplate.selectOne("memberMapper.passChk", member);
		return 0;
	}


}
