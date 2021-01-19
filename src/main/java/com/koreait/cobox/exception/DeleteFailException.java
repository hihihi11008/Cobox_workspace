package com.koreait.cobox.exception;
public class DeleteFailException extends RuntimeException{

	
	public DeleteFailException(String msg) {
		super(msg);
	}
	public DeleteFailException(String msg,Throwable e) {
		super(msg,e);
	}
}
