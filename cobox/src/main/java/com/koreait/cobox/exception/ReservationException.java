package com.koreait.cobox.exception;

public class ReservationException extends RuntimeException{
	public ReservationException(String msg) {
		super(msg);
	}
	public ReservationException(String msg, Throwable e) {
		super(msg, e);
	}
}
