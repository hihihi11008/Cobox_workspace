package com.koreait.cobox.model.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Movie {
	
	private int movie_id;
	private String movie_name;
	private  int rating_id;
	private  String director;
	private  String actor;
	private  String release;
	private  String story;
	private String poster;//currentTimeMills
	
	//이미지 처리
	private MultipartFile repImg;
	
	//insert에 써먹을것
	private Genre[] genre;
	private String rating;
	
	
}