package com.koreait.cobox.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Controller
public class MainController {   
   private static final Logger logger = LoggerFactory.getLogger(MainController.class);
   
   @RequestMapping(value="/", method=RequestMethod.GET)
   public String main() {
      return "main";
   }
   
   @RequestMapping(value = "/client/movie/reservation", method = RequestMethod.GET)
   public String reservation() {
      
      return "client/movie/reservation";
   }
   
   @RequestMapping(value = "/client/movie/reservation2", method = RequestMethod.GET)
   public String reservation2() {
      
      return "client/movie/reservation2";
   }
   @RequestMapping(value = "/client/movie/reservation3", method = RequestMethod.GET)
   public String reservation3() {
      
      return "client/movie/reservation3";
   }
   @RequestMapping(value = "/client/movie/list", method = RequestMethod.GET)
   public String list() {
      
      return "client/movie/movielist";
   }
   @RequestMapping(value = "/client/movie/detail", method = RequestMethod.GET)
   public String detail() {
      
      return "client/movie/moviedetail";
   }
   @RequestMapping(value = "/client/movie/snack", method = RequestMethod.GET)
   public String snack() {
      
      return "client/movie/snack";
   }
   //공지사항 
   /*
   @RequestMapping(value = "/client/movie/notice", method = RequestMethod.GET)
   public String notice() {
      
      return "client/notice/noticelist";
   }
   
   @RequestMapping(value = "/client/movie/noticedetail", method = RequestMethod.GET)
   public String noticedetail() {
      
      return "client/movie/noticedetail";
   }
   */
}