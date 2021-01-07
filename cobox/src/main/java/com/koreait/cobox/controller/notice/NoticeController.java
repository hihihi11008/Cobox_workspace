package com.koreait.cobox.controller.notice;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.cobox.exception.NoticeException;
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
	public ModelAndView selectAll() {
		ModelAndView mav = new ModelAndView();
		List<Notice> noticeList = noticeService.selectAll();
		mav.addObject("noticeList",noticeList);
		mav.setViewName("admin/notice/list");
		return mav;
	}
	
	//공지 한건 가져오기 
	@RequestMapping(value = "/admin/notice/detail", method = RequestMethod.GET)
	public ModelAndView select(int notice_id) {
		ModelAndView mav = new ModelAndView();
		Notice notice = noticeService.select(notice_id);
		mav.addObject("notice",notice);
		return mav;
	}
	
	//공지 등록하기 
	@RequestMapping(value = "/admin/notice/regist", method = RequestMethod.POST)
	public String regist(Notice notice) {
		logger.debug(notice.getContents());
		noticeService.insert(notice);
		return "redirect:/admin/notice/list";
	}
	
	//공지 수정하기 
	@RequestMapping(value = "/admin/notice/edit", method = RequestMethod.GET)
	public String update(Notice notice) {
		noticeService.update(notice);
		String viewPage="redirect:/admin/notice/detail?notice_id="+notice.getNotice_id();
		return viewPage;
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
}
