package com.koreait.cobox.client.controller.comments;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.koreait.cobox.admin.controller.AdminMovieController;
import com.koreait.cobox.exception.DMLException;
import com.koreait.cobox.model.comments.repository.CommentsDAO;
import com.koreait.cobox.model.comments.service.CommentsService;
import com.koreait.cobox.model.domain.Comments;
import com.koreait.cobox.model.domain.Movie;
import com.koreait.cobox.model.movie.repository.MovieDAO;

@Controller
public class CommentsController {
	private static final Logger logger=LoggerFactory.getLogger(AdminMovieController.class);
	@Autowired
	private MovieDAO movieDAO;
	
	@Autowired
	private CommentsDAO commentsDAO;
	@Autowired
	private CommentsService commentsService;
	@RequestMapping(value="/comments/regist",method=RequestMethod.POST)
	public String registComments(Comments comments,Movie movie) throws DMLException{
		logger.debug("?���?번호: "+ comments.getComments_id());
		logger.debug("?��?��번호: "+ movie.getMovie_id());
		logger.debug("?���??��?��: "+ comments.getMsg());
		logger.debug("?��?��?���?: "+ comments.getCdate());
		
		
		commentsService.insert(comments);
		
		StringBuilder sb=new StringBuilder();
		   sb.append("{");
		   sb.append("\"result\":1,");
		   sb.append("\"msg\":\"등록성공\"");
		   sb.append("}");
		return sb.toString();
	}
}