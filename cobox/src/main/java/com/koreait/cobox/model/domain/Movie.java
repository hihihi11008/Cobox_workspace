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
	
	//�̹��� ó��
	private MultipartFile repImg;
	
	//insert�� �������
	private Genre[] genre;
	private String rating;
	
	
}