package com.koreait.cobox.model.domain;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> e67746f7da3158b3653e25e65dea06fccdcd9523
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
<<<<<<< HEAD
	private String poster;//movie_id.png
=======
	private String poster;//currentTimeMills
>>>>>>> e67746f7da3158b3653e25e65dea06fccdcd9523
	
	//�̹��� ó��
	private MultipartFile repImg;
	
	//insert�� �������
	private Genre[] genre;
	private String rating;
	
	
<<<<<<< HEAD
	//���ο� �������
	private List<Genre> genreList;
	
	
	
	
	
	
	
	

	
	



	
=======
>>>>>>> e67746f7da3158b3653e25e65dea06fccdcd9523
}