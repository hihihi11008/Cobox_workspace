package com.koreait.cobox.controller.notice;

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

import com.koreait.cobox.exception.NoticeException;
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
	
	
	//���� ����� �������� 
	@RequestMapping(value = "/admin/notice/registform")
	public String getRegistForm() {
		return "admin/notice/regist_form";
	}
	
	
	//��������- ����(division)�� �������� 
	@RequestMapping(value = "/admin/notice/registform", method = RequestMethod.GET)
	public ModelAndView getDivisionList() {
		List<Division> divisionList = divisionService.selectAll();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("divisionList", divisionList);
		mav.setViewName("admin/notice/regist_form");
		return mav;
	}

	
	//�������� ��ü �������� 
	@RequestMapping(value = "/admin/notice/list", method = RequestMethod.GET)
	public ModelAndView selectAll(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		List<Notice> noticeList = noticeService.selectAll();
		pager.init(request, noticeList);
		mav.addObject("pager",pager);
		mav.setViewName("admin/notice/list");
		return mav;
	}
	
	//���� �Ѱ� �������� (�����ڰ� ���°��̹Ƿ� ��ȸ������ xxx)
	@RequestMapping(value = "/admin/notice/detail", method = RequestMethod.GET)
	public ModelAndView select(int notice_id) {
		ModelAndView mav = new ModelAndView();
		Notice notice = noticeService.select(notice_id);
		logger.debug("������ "+notice.getNotice_id());
		mav.addObject("notice",notice);
		return mav;
	}
	
	//���� ����ϱ� 
	@RequestMapping(value = "/admin/notice/regist", method = RequestMethod.POST)
	public String regist(Notice notice) {
		logger.debug("notice ������!!! "+notice.getContents());
		logger.debug("notice ������!!!"+notice.getTitle());
		logger.debug("notice �ۼ��ڴ�??"+notice.getWriter());
		logger.debug("notice �ۼ��ڴ�??"+notice.getDivision().getDivision_id());
		
		noticeService.insert(notice);
		return "redirect:/admin/notice/list";
	}
	
	//���� �����ϱ� POST
	@RequestMapping(value = "/admin/notice/edit", method = RequestMethod.POST)
	public String update(Notice notice) {
		logger.debug(""+notice.getNotice_id());
		noticeService.update(notice);
		return "redirect:/admin/notice/detail?notice_id="+notice.getNotice_id();
	}
	
	//���� �����ϱ� 
	@RequestMapping(value = "/admin/notice/del", method = RequestMethod.GET)
	public String delete(Notice notice) {
		noticeService.delete(notice);
		return "redirect:/admin/notice/list";
	}
	
	@ExceptionHandler(NoticeException.class)
	public ModelAndView handleException(NoticeException e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg",e.getMessage());
		//mav.setViewName("message/result"); //������ ������ 
		return mav;
	}
	
	/********************************************************
	 ��ȭ�� ����Ʈ ��û ó�� 
	********************************************************/
	//���� ����Ʈ ���� 
	@RequestMapping(value = "/client/notice/list", method = RequestMethod.GET)
	public ModelAndView getCinemaNotice(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		List<Notice> noticeList = noticeService.selectAll();
		pager.init(request, noticeList);
		mav.addObject("pager",pager);
		mav.setViewName("client/notice/noticelist");
		return mav;
	}
	
	//�񵿱� ���и���Ʈ �������� 
	@RequestMapping(value = "/client/notice/divisionlist", method = RequestMethod.GET)
	@ResponseBody
	public List<Division> getDivisionListByAjax(){
		List<Division>  divisionList = divisionService.selectAll();
		return divisionList;
	}
	
	
	
	 //����id �� ���� ��������Ʈ ����
	 @RequestMapping(value = "/client/notice/noticelist2", method = RequestMethod.GET)
	 public ModelAndView getCinemaNoticeByDivision(HttpServletRequest request, int division_id) { 
		 logger.debug("division_id ��????" + division_id);
		 List<Notice> noticeList = noticeService.selectAllById(division_id); 
		 
		 ModelAndView mav = new ModelAndView(); 
		 pager.init(request, noticeList);
		 mav.addObject("pager",pager);
		 //logger.debug("dname��??????" + noticeList.get(1).getDivision().getDname());
		 mav.setViewName("client/notice/noticelist2");
		 return mav; 
	 }


	//���� �󼼺��� ��û + ��ȸ�� ���� 
	@RequestMapping(value = "/client/notice/noticedetail", method = RequestMethod.GET)
	public ModelAndView getCinemaNoticeDetail(int notice_id) {
		ModelAndView mav = new ModelAndView();
		Notice notice = noticeService.select(notice_id);
		mav.addObject("notice", notice);
		mav.setViewName("client/notice/noticedetail");
		noticeService.noticeHit(notice.getNotice_id());
		return mav;
	}
	
	//1:1���� ������ �ҷ�����  
	@RequestMapping(value = "/client/contact/contactform", method = RequestMethod.GET)
	public String getContactForm() {
		return "client/contact/contact_form";
	}
	
	//1:1 ���� ������ 
	@RequestMapping(value = "/client/contact/sendmail", method = RequestMethod.POST)
	public ModelAndView sendMail(HttpServletRequest request) {
		String name = request.getParameter("uname");
		String email = request.getParameter("uemail");
		String message = request.getParameter("umessage");
		logger.debug("�޾ƿ� �̸��� ? " + name);
		logger.debug("�޾ƿ� ������ ? " + email);
		logger.debug("�޾ƿ� ������ ? " + message);
		
		mailSender.send(email, name, message);
		
		MessageData messageData = new MessageData();
		messageData.setResultCode(1);
		messageData.setMsg("���ǻ��� ������ �Ϸ�Ǿ����ϴ�.");
		messageData.setUrl("redirect:/client/contact/contactform");
		
		ModelAndView mav = new ModelAndView("client/error/message");
		mav.addObject("messageData", messageData);
		return mav;
	}
}