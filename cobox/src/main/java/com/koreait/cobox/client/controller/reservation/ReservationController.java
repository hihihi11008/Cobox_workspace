package com.koreait.cobox.client.controller.reservation;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.cobox.model.domain.Member;
import com.koreait.cobox.model.domain.ResSummary;
import com.koreait.cobox.model.domain.Reservation;
import com.koreait.cobox.model.movie.service.MovieService;
import com.koreait.cobox.model.reservation.service.ReservationService;

@Controller
public class ReservationController{
	private static final Logger logger = LoggerFactory.getLogger(ReservationController.class);
	@Autowired
	private MovieService movieService;
	
	
	
	@GetMapping("/movie/reservation")
	public ModelAndView reserMovie(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("memeber");
		
		List movieList=movieService.selectAll();
		ModelAndView mav=new ModelAndView();
		mav.addObject("movieList",movieList);
		mav.setViewName("client/movie/reservation");
		
		return mav;
	}
	
	
	
	

}