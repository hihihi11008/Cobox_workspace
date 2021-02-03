package com.koreait.cobox.client.controller.notice;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.cobox.exception.ContactException;
import com.koreait.cobox.exception.NoticeEditException;
import com.koreait.cobox.exception.NoticeRegistException;
import com.koreait.cobox.model.common.MailSender;
import com.koreait.cobox.model.common.MessageData;
import com.koreait.cobox.model.common.Pager;
import com.koreait.cobox.model.domain.Division;
import com.koreait.cobox.model.domain.Notice;
import com.koreait.cobox.model.notice.service.DivisionService;
import com.koreait.cobox.model.notice.service.NoticeService;

@Controller
public class NoticeController {
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private DivisionService divisionService;
	
	//���Ϲ߼۰�ü 
	@Autowired
	private MailSender mailSender;
	
	//����¡ó�� 
	@Autowired
	private Pager pager;
	
	/********************************************************
	 ��ȭ�� ����Ʈ ��û ó�� 
	********************************************************/
	//�񵿱� ���и���Ʈ �������� 
	@RequestMapping(value = "/notice/divisionlist", method = RequestMethod.GET)
	@ResponseBody
	public List<Division> getDivisionListByAjax(){
		List<Division>  divisionList = divisionService.selectAll();
		return divisionList;
	}

	//���� ����Ʈ ���� 
	@RequestMapping(value = "/notice/list", method = RequestMethod.GET)
	public ModelAndView getCinemaNotice(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();

		List<Notice> noticeList = noticeService.selectAll();
		pager.init(request, noticeList);
		mav.addObject("pager",pager);
		mav.setViewName("client/notice/noticelist");
		return mav;
	}
	 //����id �� ���� ��������Ʈ ����
	 @RequestMapping(value = "/notice/listByDivision", method = RequestMethod.GET)
	 public ModelAndView getCinemaNoticeByDivision(HttpServletRequest request, int division_id) { 
		 logger.debug("division_id ��????" + division_id);
		 List<Notice> noticeList = noticeService.selectAllById(division_id); 
		 //logger.debug("��ݴ��� ���а��� �̸���???"+noticeList.get(1).getDivision().getDname());
		 
		 ModelAndView mav = new ModelAndView(); 
		 pager.init(request, noticeList);
		 mav.addObject("pager",pager);
		 mav.setViewName("client/notice/noticelist");
		 return mav; 
	 }


	//���� �󼼺��� ��û + ��ȸ�� ���� 
	@RequestMapping(value = "/notice/noticedetail", method = RequestMethod.GET)
	public ModelAndView getCinemaNoticeDetail(int notice_id) {
		ModelAndView mav = new ModelAndView();
		Notice notice = noticeService.select(notice_id);
		mav.addObject("notice", notice);
		mav.setViewName("client/notice/noticedetail");
		noticeService.noticeHit(notice.getNotice_id());
		return mav;
	}
	
	//1:1���� ������ �ҷ�����  
	@RequestMapping(value = "/contact/contactform", method = RequestMethod.GET)
	public String getContactForm() {
		return "client/contact/contact_form";
	}
	
	//1:1 ���� ������ 
	@RequestMapping(value = "/contact/sendmail", method = RequestMethod.POST)
	public ModelAndView sendMail(HttpServletRequest request,String uname, String uemail, String umessage) {
		/*
		String name = request.getParameter("uname");
		String email = request.getParameter("uemail");
		String message = request.getParameter("umessage");
		*/
		logger.debug("�޾ƿ� �̸��� ? " + uname);
		logger.debug("�޾ƿ� ������ ? " + uemail);
		logger.debug("�޾ƿ� ������ ? " + umessage);
		
		mailSender.send(uemail,uname, umessage);
		
		MessageData messageData = new MessageData();
		messageData.setResultCode(1);
		messageData.setMsg("���ǻ��� ������ �Ϸ�Ǿ����ϴ�.");
		messageData.setUrl("/client/contact/contactform");
		
		ModelAndView mav = new ModelAndView("client/error/message");
		mav.addObject("messageData", messageData);
		return mav;
	}
	
	//�Խ��� ����ó�� �ڵ鷯
	@ExceptionHandler(ContactException.class)
	public MessageData hadleException(ContactException e) {
		MessageData messageData = new MessageData();
		messageData.setResultCode(0);
		messageData.setMsg(e.getMessage());
		
		return messageData;
	}
	
	@ExceptionHandler(NoticeEditException.class)
	public MessageData hadleException(NoticeEditException e) {
		MessageData messageData = new MessageData();
		messageData.setResultCode(0);
		messageData.setMsg(e.getMessage());
		
		return messageData;
	}
}
