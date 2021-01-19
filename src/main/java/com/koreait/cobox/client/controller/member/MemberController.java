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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.koreait.cobox.exception.DeleteFailException;
import com.koreait.cobox.exception.MemberEditException;
import com.koreait.cobox.exception.MemberNotFoundException;
import com.koreait.cobox.exception.MemberRegistException;
import com.koreait.cobox.model.common.MessageData;
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
	public String login(Member member, HttpServletRequest request) {
		//db�� ���翩�� Ȯ�� 
				Member obj=memberService.select(member);
				
				//���� O : ���ǿ� ȸ������ ��Ƶα�
				HttpSession session=request.getSession();
				session.setAttribute("member", obj); //���� Ŭ���̾�Ʈ ��û�� ����� ���ǿ� ������ ���´�
				
				return "redirect:/client/";
	}
	
	//�α׾ƿ� Ȩ ��û 
	@RequestMapping(value="/member/logoutform", method=RequestMethod.GET)
	public ModelAndView getLogoutForm() {
		ModelAndView mav = new ModelAndView("client/member/logout");
		
		return mav;
	}
	
	//�α׾ƿ� ��û ó�� 
	@RequestMapping("/member/logout")
	public ModelAndView logout(HttpServletRequest request) {
		
		request.getSession().invalidate(); //���� ��ȿȭ, �̽������� ����� �����Ͱ� �� ��ȿ�� �ȴ�
		
		MessageData messageData = new MessageData();
		messageData.setResultCode(1);
		messageData.setMsg("�α׾ƿ� �Ǿ����ϴ�");
		messageData.setUrl("/");
		
		ModelAndView mav = new ModelAndView("/");
		
		mav.addObject("messageData", messageData);
		return mav;
	}
	//����/admin/member/edit �̾��µ� ..�ϴ� client������ �� �տ� admin�M
	@RequestMapping(value="/member/edit", method=RequestMethod.POST)
	@ResponseBody
	public String edit(Member member) {
		
		memberService.update(member);
		
		StringBuffer sb=new StringBuffer();
		sb.append("{");
		sb.append("\"result\":1");
		sb.append("}");
		return sb.toString();
	}
	
	// ȸ�� Ż��(delete)
	@RequestMapping("/member/delete")
	public String Withdraw(HttpSession session, Member member, RedirectAttributes rttr) throws MemberNotFoundException {
	 
	 Member membervo = (Member)session.getAttribute("member");
	 
	 String oldPass = membervo.getPassword();
	 String newPass = member.getPassword();
	     
	 //ȸ��Ż�� ���� �Է��� ��й�ȣ�� ���� ��й�ȣ�� ��ġ�ϴ��� ���ϱ� ���� equals ���.
	 //�ٷ� ���ٿ��� ���� ��й�ȣ�� �Է��� ��й�ȣ�� ���ϱ� ���� ������ �ٸ��� ����.
	 if(!(oldPass.equals(newPass))) {
	  rttr.addFlashAttribute("msg", false);
	  return "redirect:/";
	 }
	 
	 //�����Ϳ��� ������ ����
	 memberService.delete(member);
	 
	 //Ż��� ���ÿ� �α׾ƿ���Ű��
	 session.invalidate();
	  
	 return "redirect:/";
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
	
	@ExceptionHandler(MemberEditException.class)
	@ResponseBody
	public String editException(MemberEditException e) {
		StringBuffer sb=new StringBuffer();
		sb.append("{");
		sb.append("result:0");
		sb.append("}");		
		System.out.println("���� ��û����"+sb);
		return sb.toString();
	}
	
	@ExceptionHandler(DeleteFailException.class)
	@ResponseBody
	public String deleteException(DeleteFailException e) {
		StringBuffer sb=new StringBuffer();
		sb.append("{");
		sb.append("result:0");
		sb.append("}");		
		System.out.println("��������"+sb);
		return sb.toString();
	}

}