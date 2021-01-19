package com.koreait.cobox.client.aop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

import com.koreait.cobox.exception.LoginRequiredException;

@Component
public class MemberSessionCheckAspect {
	public Object sessionCheck(ProceedingJoinPoint joinPoint) throws Throwable {
		Object target = joinPoint.getTarget();
		String methodName =  joinPoint.getSignature().getName();
		Object[] args = joinPoint.getArgs();
		
		//세션 얻기 
		HttpServletRequest request = null;
		//가져온 arg가 HttpServletRequest가 맞다면, 
		for (Object arg : args) {
			if (arg instanceof HttpServletRequest) {
				request =(HttpServletRequest)arg;
			}
		}

		//세션이 없다면, ExceptionHandler -> 예외 발생
		//세션있다면, 메서드호출 진행
		HttpSession session = null;
		session = request.getSession();
		Object result = null;
		
		if (session.getAttribute("member")==null) {
			throw new LoginRequiredException("로그인이 필요한 서비스입니다.");
		}else {
			result = joinPoint.proceed();
		}
		return result;
	}
}
