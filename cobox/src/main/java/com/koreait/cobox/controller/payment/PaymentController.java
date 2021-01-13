package com.koreait.cobox.controller.payment;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.koreait.cobox.model.common.MessageData;
import com.koreait.cobox.model.domain.Member;
import com.koreait.cobox.model.domain.Reservation;
import com.koreait.cobox.model.movie.service.MovieService;
import com.koreait.cobox.model.reservation.service.ReservationService;
@Controller
public class PaymentController {
	private static final Logger logger=LoggerFactory.getLogger(PaymentController.class);
	
	@Autowired
	private ReservationService paymentService;
	@Autowired
	private MovieService movieService;
	
	/*
	//예약페이지 리스트업
	@GetMapping("/client/movie/reservation")
	public ModelAndView getMovieList() {
		List movieList=movieService.selectAll();
		ModelAndView mav=new ModelAndView();
		mav.addObject("movieList",movieList);
		mav.setViewName("client/movie/reservation");
		return mav;
	}*/
	
	@RequestMapping(value="/client/movie/reservationfinal", method=RequestMethod.POST)
	@ResponseBody
	public MessageData registReservation(Reservation reservation,HttpSession session) {
		Member member=(Member)session.getAttribute("member");
		reservation.setMember_id(member.getMember_id());
		paymentService.insert(reservation);
		
		MessageData messageData=new MessageData();
		messageData.setResultCode(1);
		messageData.setMsg("예약이 완료 되었습니다.");
		messageData.setUrl("client/movie/reservationfinal");
		return messageData;
	}
	
	//결제페이지 
	@GetMapping("/client/movie/reservation3")
	public String getPayment() {
		return "client/payment/reservation3";
	}
	
	//마지막 총 예매티켓페이지! 
	@GetMapping("/client/movie/reservationfinal")
	public String getReservation() {
		return "client/payment/reservationfinal";
	}

	
}
