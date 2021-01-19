package com.koreait.cobox.model.domain;

import lombok.Data;

@Data
public class Seat {
	private int seat_id;
	private Theater theater;
	private String seat_name;
	private int seat_price;
	private boolean hold;
}