package com.iu.start.bankmembers;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.start.bankaccount.AccountService;

@Controller 
@RequestMapping(value = "/member/*")
// 이 클래스는 Controller 역할,
// Container에게 이 클래스의 객체를 생성을 위임.
public class MemberController {
	
	@Autowired
	private MembersService membersService;
	
	// annotation
	// @ : 설명 + 실행
	
	// /member/login
	@RequestMapping(value = "login.iu", method = RequestMethod.GET)
	public String login() {
		System.out.println("Login 실행");
		
		return "member/login";
	}
	
	@RequestMapping(value = "login.iu", method = RequestMethod.POST)
	public String login(BankMembersDTO bankMembersDTO, Model model, HttpSession session) throws Exception {
		System.out.println("Login 실행");
		bankMembersDTO = membersService.getLogin(bankMembersDTO);
		System.out.println(bankMembersDTO);
		session.setAttribute("member", bankMembersDTO);
		// redirect 방법 => redirect:URL 주소(절대 or 상대)
		return "redirect:../";
	}
	
	// /member/join GET
	@RequestMapping(value = "join.iu", method = RequestMethod.GET)
	public String join() {
		System.out.println("join GET 실행");
		
		return "member/join";
	}
	
	// /member/join POST
	// 절대경로로 작성
	@RequestMapping(value = "join.iu", method = RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO, String email1, String email2) throws Exception {
		System.out.println("join POST 실행");
		String email = email1+"@"+email2;
		bankMembersDTO.setEmail(email);
		int result = membersService.setJoin(bankMembersDTO);
		if(result == 0) {
			System.out.println("실패");
		} else {
			System.out.println("성공");
		}
		
		return "redirect:login.iu";
	}
	
	@RequestMapping(value = "search.iu", method = RequestMethod.GET)
	public ModelAndView getSearchById(ModelAndView mv) {
		System.out.println("Search Get 실행");
		mv.setViewName("member/search");
		
		
		return mv;
	}
	
	@RequestMapping(value = "search.iu", method = RequestMethod.POST)
	public ModelAndView getSearchById(ModelAndView mv, String search) throws Exception {
		System.out.println("Search Post 실행");
		
		List<BankMembersDTO> list = membersService.getSearchByID(search);
		mv.setViewName("member/list");
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping(value = "logout.iu", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		System.out.println("LogOut 실행");
		// 대개 세션을 소멸시킴
		
		session.invalidate();
		return "redirect:../";
	}
	
	@RequestMapping(value = "myPage.iu", method = RequestMethod.GET)
	public void myPage(HttpSession session, Model model) throws Exception {
		model.addAttribute("getMyPage", membersService.myPage((BankMembersDTO) session.getAttribute("member")));
	}
}