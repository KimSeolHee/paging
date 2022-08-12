package com.iu.start.bankbook;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/book/*")
public class BookController {
	
	BankBookDAO bankBookDAO = new BankBookDAO();
	@RequestMapping(value = "list.iu", method = RequestMethod.GET)
	public String list(Model model) throws Exception {
		System.out.println("리스트 실행");
		
		ArrayList<BankBookDTO> arr = bankBookDAO.getList();
		model.addAttribute("list", arr);
		return "book/list";
	}
	
	@RequestMapping(value = "detail.iu", method = RequestMethod.GET)
	public ModelAndView detail(BankBookDTO bankBookDTO) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("디테일 실행");
		System.out.println(bankBookDTO.getBookNum());
		bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
		mv.addObject("detail", bankBookDTO);
		mv.setViewName("book/detail");
		return mv;
	}
	
	@RequestMapping(value = "add.iu", method = RequestMethod.GET)
	public void add() {
		
		System.out.println("add Form 실행");
		
		//return "book/add";
	}
	
	@RequestMapping(value = "add.iu", method = RequestMethod.POST)
	public ModelAndView add(BankBookDTO bankBookDTO, ModelAndView mv) throws Exception {
		
		System.out.println("add Post 실행");
		int result = bankBookDAO.setBankBook(bankBookDTO);
		System.out.println(result == 1);
		mv.setViewName("redirect:list.iu");
		return mv;
	}
	
	@RequestMapping(value = "update.iu", method = RequestMethod.GET)
	public ModelAndView update(BankBookDTO dto, ModelAndView mv) throws Exception {
		dto = bankBookDAO.getDetail(dto);
		mv.addObject("detail", dto);
		System.out.println("Update Get 실행");
		mv.setViewName("book/update");
		return mv;
	}
	
	@RequestMapping(value = "update.iu", method = RequestMethod.POST)
	public ModelAndView update(BankBookDTO dto) throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println("Update POST 실행");
		int result = bankBookDAO.setUpdate(dto);
		System.out.println(result==1);
//		mv.setViewName("redirect:detail?bookNum="+dto.getBookNum());
		mv.setViewName("redirect:list.iu");
		return mv;
	}
	
	@RequestMapping(value = "delete.iu", method = RequestMethod.GET)
	public ModelAndView delete(BankBookDTO dto) throws Exception {
		ModelAndView mv = new ModelAndView();
		int result = bankBookDAO.setDelete(dto);
		System.out.println(result == 1);
		mv.setViewName("redirect:list.iu");
		return mv;
	}
}