package com.koreait.cobox.client.aop;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.cobox.exception.ContactException;
import com.koreait.cobox.exception.LoginRequiredException;
import com.koreait.cobox.model.common.MessageData;

@Component
public class GlobalExceptionHandler {
	//로그인 예외처리 핸들러
	@ExceptionHandler(LoginRequiredException.class)
	@ResponseBody
	public ModelAndView hadleException(LoginRequiredException e) {
		ModelAndView mav = new ModelAndView();
		
		MessageData messageData = new MessageData();
		messageData.setResultCode(0);
		messageData.setMsg(e.getMessage());
		
		mav.addObject("messageData", messageData);
		mav.setViewName("client/error/message");
		
		return mav;
	}
}
