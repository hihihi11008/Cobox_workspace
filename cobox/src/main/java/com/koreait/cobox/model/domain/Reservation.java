package com.koreait.cobox.model.domain;

import lombok.Data;

@Data
public class Reservation {
	private int reservation_id;
	private int member_id;
	private int schedule_id;
	private int snack_id;
	private int seatquantity;

}