package com.koreait.cobox.model.domain;

<<<<<<< HEAD
public class Rating {
 private int rating_id;
 private String rating_name;
public int getRating_id() {
	return rating_id;
}
public void setRating_id(int rating_id) {
	this.rating_id = rating_id;
}
public String getRating_name() {
	return rating_name;
}
public void setRating_name(String rating_name) {
	this.rating_name = rating_name;
}
=======
import lombok.Data;

@Data
public class Rating {
	private int rating_id;
	private String rating_name;
>>>>>>> e67746f7da3158b3653e25e65dea06fccdcd9523
}
