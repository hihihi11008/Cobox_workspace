package com.koreait.cobox.model.domain;

import lombok.Data;

@Data
public class Reservation {
	private int reservation_id;
	private int res_summary_id;
	private int schedule_id;
	private int seat_id;
	private int seatquantity;
}