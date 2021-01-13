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
	
	//메일발송객체 
	@Autowired
	private MailSender mailSender;
	
	//페이징처리 
	@Autowired
	private Pager pager;
	
	
	//공지 등록폼 가져오기 
	@RequestMapping(value = "/admin/notice/registform")
	public String getRegistForm() {
		return "admin/notice/regist_form";
	}
	
	
	//공지사항- 구분(division)값 가져오기 
	@RequestMapping(value = "/admin/notice/registform", method = RequestMethod.GET)
	public ModelAndView getDivisionList() {
		List<Division> divisionList = divisionService.selectAll();
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("divisionList", divisionList);
		mav.setViewName("admin/notice/regist_form");
		return mav;
	}

	
	//공지사항 전체 가져오기 
	@RequestMapping(value = "/admin/notice/list", method = RequestMethod.GET)
	public ModelAndView selectAll(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		List<Notice> noticeList = noticeService.selectAll();
		pager.init(request, noticeList);
		mav.addObject("pager",pager);
		mav.setViewName("admin/notice/list");
		return mav;
	}
	
	//공지 한건 가져오기 (관리자가 보는것이므로 조회수증가 xxx)
	@RequestMapping(value = "/admin/notice/detail", method = RequestMethod.GET)
	public ModelAndView select(int notice_id) {
		ModelAndView mav = new ModelAndView();
		Notice notice = noticeService.select(notice_id);
		logger.debug("디테일 "+notice.getNotice_id());
		mav.addObject("notice",notice);
		return mav;
	}
	
	//공지 등록하기 
	@RequestMapping(value = "/admin/notice/regist", method = RequestMethod.POST)
	public String regist(Notice notice) {
		logger.debug("notice 내용은!!! "+notice.getContents());
		logger.debug("notice 제목은!!!"+notice.getTitle());
		logger.debug("notice 작성자는??"+notice.getWriter());
		logger.debug("notice 작성자는??"+notice.getDivision().getDivision_id());
		
		noticeService.insert(notice);
		return "redirect:/admin/notice/list";
	}
	
	//공지 수정하기 POST
	@RequestMapping(value = "/admin/notice/edit", method = RequestMethod.POST)
	public String update(Notice notice) {
		logger.debug(""+notice.getNotice_id());
		noticeService.update(notice);
		return "redirect:/admin/notice/detail?notice_id="+notice.getNotice_id();
	}
	
	//공지 삭제하기 
	@RequestMapping(value = "/admin/notice/del", method = RequestMethod.GET)
	public String delete(Notice notice) {
		noticeService.delete(notice);
		return "redirect:/admin/notice/list";
	}
	
	@ExceptionHandler(NoticeException.class)
	public ModelAndView handleException(NoticeException e) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg",e.getMessage());
		//mav.setViewName("message/result"); //보여줄 페이지 
		return mav;
	}
	
	/********************************************************
	 영화관 프론트 요청 처리 
	********************************************************/
	//공지 리스트 보기 
	@RequestMapping(value = "/client/notice/list", method = RequestMethod.GET)
	public ModelAndView getCinemaNotice(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		List<Notice> noticeList = noticeService.selectAll();
		pager.init(request, noticeList);
		mav.addObject("pager",pager);
		mav.setViewName("client/notice/noticelist");
		return mav;
	}
	
	//비동기 구분리스트 가져오기 
	@RequestMapping(value = "/client/notice/divisionlist", method = RequestMethod.GET)
	@ResponseBody
	public List<Division> getDivisionListByAjax(){
		List<Division>  divisionList = divisionService.selectAll();
		return divisionList;
	}
	
	
	
	 //구분id 에 따른 공지리스트 보기
	 @RequestMapping(value = "/client/notice/noticelist2", method = RequestMethod.GET)
	 public ModelAndView getCinemaNoticeByDivision(HttpServletRequest request, int division_id) { 
		 logger.debug("division_id 는????" + division_id);
		 List<Notice> noticeList = noticeService.selectAllById(division_id); 
		 
		 ModelAndView mav = new ModelAndView(); 
		 pager.init(request, noticeList);
		 mav.addObject("pager",pager);
		 //logger.debug("dname은??????" + noticeList.get(1).getDivision().getDname());
		 mav.setViewName("client/notice/noticelist2");
		 return mav; 
	 }


	//공지 상세보기 요청 + 조회수 증가 
	@RequestMapping(value = "/client/notice/noticedetail", method = RequestMethod.GET)
	public ModelAndView getCinemaNoticeDetail(int notice_id) {
		ModelAndView mav = new ModelAndView();
		Notice notice = noticeService.select(notice_id);
		mav.addObject("notice", notice);
		mav.setViewName("client/notice/noticedetail");
		noticeService.noticeHit(notice.getNotice_id());
		return mav;
	}
	
	//1:1문의 메일폼 불러오기  
	@RequestMapping(value = "/client/contact/contactform", method = RequestMethod.GET)
	public String getContactForm() {
		return "client/contact/contact_form";
	}
	
	//1:1 메일 보내기 
	@RequestMapping(value = "/client/contact/sendmail", method = RequestMethod.POST)
	public ModelAndView sendMail(HttpServletRequest request) {
		String name = request.getParameter("uname");
		String email = request.getParameter("uemail");
		String message = request.getParameter("umessage");
		logger.debug("받아온 이름은 ? " + name);
		logger.debug("받아온 메일은 ? " + email);
		logger.debug("받아온 내용은 ? " + message);
		
		mailSender.send(email, name, message);
		
		MessageData messageData = new MessageData();
		messageData.setResultCode(1);
		messageData.setMsg("문의사항 전송이 완료되었습니다.");
		messageData.setUrl("redirect:/client/contact/contactform");
		
		ModelAndView mav = new ModelAndView("client/error/message");
		mav.addObject("messageData", messageData);
		return mav;
	}
}