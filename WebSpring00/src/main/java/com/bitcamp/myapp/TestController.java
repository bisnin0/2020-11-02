package com.bitcamp.myapp;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
	//매핑
	//@RequestMapping(value="/aLink", method=RequestMethod.GET) /aLink로 접속하면 아래 메소드 실행 겟방식으로 가져온다.
	@RequestMapping("/aLink") //위와 같다. 겟방식일때는 메핑 주소만 적어도 된다. post방식일때는 위의 형식으로 쓴다.
	public String aLinkTest(HttpServletRequest req, Model model) {
		//겟방식으로 받게 설정되었고 home.jsp에서 a링크로 보냈다. 
		// req를 통해서 home이 보낸 변수 2개 no와 name을 여기로 가져올수있다.
		String no = req.getParameter("no")+666;
		String name = req.getParameter("name")+"님";
		
		model.addAttribute("no", no);
		model.addAttribute("name", name);
		
		
		
		return "test";
		
	}
	//폼의 데이터를 서버로 전송하는방법 1
	@RequestMapping(value="/form1", method=RequestMethod.POST)
	public ModelAndView formTest1(HttpServletRequest r) { //매개변수에 request객체를 써도 되고 
		TestVO vo = new TestVO();
		vo.setUsername(r.getParameter("username"));
		vo.setTel(r.getParameter("tel"));
		vo.setAddr(r.getParameter("addr"));
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("vo", vo);

		//	/WEB-INF/views/sample/formView.jsp로 하겠다는 뜻이다.
		mav.setViewName("sample/formView");
		
		return mav;
	}
	//폼의 데이터를 서버로 전송하는방법 2 @RequestParam = request.getParameter라고 보면 된다.
	@RequestMapping(value="/form2", method=RequestMethod.POST)
	public ModelAndView formTest2(@RequestParam("username") String name, 
									@RequestParam("tel") String tel, 
									@RequestParam("addr") String addr) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("username", name);
		mav.addObject("tel", tel);
		mav.addObject("addr", addr);
		
		mav.setViewName("sample/formView");
		
		return mav;
	}
	//폼의 데이터를 서버로 전송하는방법3 --> 이게 가장 편한 방법인듯.
	//폼에 있는 변수를 자동으로 vo의 변수에 담는다. 없는 변수는 담지 않는다.
	@RequestMapping(value="/form3", method=RequestMethod.POST)
	public ModelAndView formTest3(TestVO vo) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("vo", vo);
		mav.setViewName("sample/formView");
		
		return mav;
	}
}

















