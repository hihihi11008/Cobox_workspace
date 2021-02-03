package com.koreait.cobox.client.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.cobox.exception.MemberNotFoundException;
import com.koreait.cobox.exception.MemberRegistException;
import com.koreait.cobox.model.domain.Member;
import com.koreait.cobox.model.member.service.MemberService;

@Controller
public class MemberController {
	private static final Logger logger=LoggerFactory.getLogger(MemberController.class);

	@Autowired
	private MemberService memberService;
		
	//ȸ�������� ��û 
	@RequestMapping(value="/member/join", method=RequestMethod.GET)
	public ModelAndView getRegistForm(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("client/member/join");
		return mav;	
	}

	//ȸ�������� ����(insert)
	@RequestMapping(value="/member/regist", method=RequestMethod.POST, produces="text/html;charset=utf-8")
	@ResponseBody
	public String regist(Member member) {
		
		logger.debug("���̵� "+member.getMid());
		logger.debug("��й�ȣ "+member.getPassword());
		logger.debug("�̸� "+member.getName());
		logger.debug("�������"+member.getBirth());
		logger.debug("�̸���id "+member.getEmail_id());
		logger.debug("�̸���server "+member.getEmail_server());
		logger.debug("�ڵ�����ȣ "+member.getPhone());
		
		memberService.insert(member);

		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append(" \"result\":1, ");
		sb.append(" \"msg\":\"ȸ������ ����\"");
		sb.append("}");
		
		return sb.toString();
	} 
	
	//�α��� Ȩ ��û 
	@RequestMapping(value="/member/formtable", method=RequestMethod.GET)
	public ModelAndView getLoginForm() {
		ModelAndView mav = new ModelAndView("client/member/login");
		
		return mav;
	}
	
	//�α��� ��û ó��(select)
	@RequestMapping(value="/member/login", method=RequestMethod.POST)
	public String login(Member member, HttpServletRequest request) throws MemberNotFoundException{
		//db�� ���翩�� Ȯ�� 
		Member obj=memberService.select(member);
		
		//���� O : ���ǿ� ȸ������ ��Ƶα�
		HttpSession session=request.getSession();
		session.setAttribute("member", obj); //���� Ŭ���̾�Ʈ ��û�� ����� ���ǿ� ������ ���´�
		
		return "redirect:/client/main";
	}

	//�α׾ƿ� ��û ó�� 
	@RequestMapping(value="/member/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		
		request.getSession().invalidate(); //���� ��ȿȭ, �̽������� ����� �����Ͱ� �� ��ȿ�� �ȴ�
		
		return "redirect:/client/";
	}

	//���� �ڵ鷯 2���� ó��
	@ExceptionHandler(MemberRegistException.class)
	@ResponseBody
	public String handleException(MemberRegistException e) {
		StringBuffer sb = new StringBuffer();
		sb.append("{");
		sb.append(" \"result\":0, ");
		sb.append(" \"msg\":\""+e.getMessage()+"\"");
		sb.append("}");
		
		return sb.toString();
	}
}
