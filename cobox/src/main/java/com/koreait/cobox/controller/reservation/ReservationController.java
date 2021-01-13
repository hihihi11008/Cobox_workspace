package com.koreait.cobox.controller.reservation;

import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.cobox.model.movie.service.MovieService;

@Controller
public class ReservationController implements ServletContextAware{
	@Autowired
	private MovieService movieService;
	@Override
	public void setServletContext(ServletContext servletContext) {
		// TODO Auto-generated method stub
		
	}
	@GetMapping("/client/movie/reservation")
	public ModelAndView reserMovie() {
		List movieList=movieService.selectAll();
		ModelAndView mav=new ModelAndView();
		mav.addObject("movieList",movieList);
		mav.setViewName("client/movie/reservation");
		return mav;
	}
	
	

}