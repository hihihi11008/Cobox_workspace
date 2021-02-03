package com.koreait.cobox.model.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.koreait.cobox.exception.MailSendException;
import com.koreait.cobox.exception.MemberNotFoundException;
import com.koreait.cobox.exception.MemberRegistException;
import com.koreait.cobox.model.common.MailSender;
import com.koreait.cobox.model.common.SecureManager;
import com.koreait.cobox.model.domain.Member;
import com.koreait.cobox.model.member.repository.MemberDAO;
import com.koreait.cobox.model.member.repository.MybatisMemberDAO;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;

	private MybatisMemberDAO mybatisMemberDAO;

	// ���Ϲ߼� ��ü
	@Autowired
	private MailSender mailSender;

	// ��ȣȭ ��ü
	@Autowired
	private SecureManager secureManager;

	@Override
	public List selectAll() {
		// ȸ�� ���θ� �ҷ����� �޼��� �ʿ��Ѱ�??
		return null;
	}

	@Override
	public Member select(Member member) throws MemberNotFoundException {
		// ������ ������ �Ķ���ͺ���� �ؽð����� ��ȯ�Ͽ� �Ʒ��� �޼��� ȣ��
		String hash = secureManager.getSecureData(member.getPassword());
		member.setPassword(hash); // VO�� �ؽð� ����!!
		Member obj = memberDAO.select(member);
		return obj;
	}
	
	@Override
	public void insert(Member member) throws MemberRegistException, MailSendException {

		// ��ȣȭ ó��
		String secureData = secureManager.getSecureData(member.getPassword());
		member.setPassword(secureData); // ��ȯ���� �ٽ� VO�� ����

		memberDAO.insert(member);
	}

	@Override
	public void update(Member member) throws MemberRegistException {
		String secureData = secureManager.getSecureData(member.getPassword());// ��й�ȣ ��ȣȭ
		member.setPassword(secureData); // ��ȯ���� �ٽ� VO�� ����
		
		memberDAO.update(member);
		

	}

	@Override
	public void delete(Member member) {

		memberDAO.delete(member);

	}
	

	@Override
	public int idChk(Member member) throws MemberNotFoundException {
		int result = memberDAO.idChk(member);
		return result;
	}

	@Override
	public int passChk(Member member) {
		int result = memberDAO.passChk(member);
		return result;
	}

}
