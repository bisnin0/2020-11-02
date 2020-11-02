package com.bitcamp.myapp;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


// @Controller 어노테이션을 표기하면 현재클래스는 컨트롤러 클래스가 된다.
@Controller
public class HomeController {
	
	//@RequestMapping 접속자 주소를 매핑하는 메소드가 된다. 메핑되어있는 주소를 찾아다닌다.  
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView home() {
		//ModelAndView : 클라이언트로 보내는 데이터와 뷰 파일명을 가진다.
		
		ModelAndView mav = new ModelAndView();
		String name = "홍길동";
		int data[] = {12,35,62,356,15,31,65};
		mav.addObject("username", name);
		mav.addObject("data", data);
		//컨트롤러에서 뷰페이지로 데이터를 보낼때 ModelAndView에서 세팅하면 된다.
		
		mav.setViewName("home");
		return mav;
	}
	
}
