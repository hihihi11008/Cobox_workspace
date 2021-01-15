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
		
		//���� ��� 
		HttpServletRequest request = null;
		//������ arg�� HttpServletRequest�� �´ٸ�, 
		for (Object arg : args) {
			if (arg instanceof HttpServletRequest) {
				request =(HttpServletRequest)arg;
			}
		}

		//������ ���ٸ�, ExceptionHandler -> ���� �߻�
		//�����ִٸ�, �޼���ȣ�� ����
		HttpSession session = null;
		session = request.getSession();
		Object result = null;
		
		if (session.getAttribute("member")==null) {
			throw new LoginRequiredException("�α����� �ʿ��� �����Դϴ�.");
		}else {
			result = joinPoint.proceed();
		}
		return result;
	}
}
