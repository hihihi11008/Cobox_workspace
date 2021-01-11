package com.koreait.cobox.model.domain;

import lombok.Data;

@Data
public class Genre {
	private int genre_id;
	private int movie_id;
	private String genre_name;
}