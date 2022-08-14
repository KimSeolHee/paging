package com.iu.start.board;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/board/*")
public class BoardController {

	BankBoardDAO bankBoardDAO;
	
	public BoardController() {
		bankBoardDAO = new BankBoardDAO();
	}
	
	@RequestMapping(value = "/list.iu", method = RequestMethod.GET)
	public String getList(Model model) throws Exception {
		
		ArrayList<BankBoardDTO> arr = bankBoardDAO.getList();
		model.addAttribute("list", arr);
		
		return "/board/list";
	}
	
	@RequestMapping(value = "add.iu", method = RequestMethod.GET)
	public void setWriting() throws Exception {
		
	}
	
	@RequestMapping(value = "add.iu", method = RequestMethod.POST)
	public String setWriting(BankBoardDTO bankBoardDTO) throws Exception {

		int result = bankBoardDAO.setWriting(bankBoardDTO);
		System.out.println(result == 1);
		
		return "redirect:list.iu";
	}
	
	@RequestMapping(value = "detail.iu", method = RequestMethod.GET)
	public String getDetail(BankBoardDTO bankBoardDTO, Model model) throws Exception {
		
		int result = bankBoardDAO.addHit(bankBoardDTO);
		System.out.println(result == 1);
		bankBoardDTO = bankBoardDAO.getDetail(bankBoardDTO);
		model.addAttribute("detail", bankBoardDTO);
		
		return "/board/detail";
	}
	
	@RequestMapping(value = "update.iu", method = RequestMethod.GET)
	public void update(Model model, BankBoardDTO bankBoardDTO) throws Exception {
		model.addAttribute("no", bankBoardDTO.getNo());
	}
	
	@RequestMapping(value = "update.iu", method = RequestMethod.POST)
	public String update(BankBoardDTO bankBoardDTO) throws Exception {
		int result = bankBoardDAO.updateWriting(bankBoardDTO);
		System.out.println(result == 1);
		
		return "redirect:list.iu";
	}
	
	@RequestMapping(value = "delete.iu", method = RequestMethod.GET)
	public String delete(BankBoardDTO bankBoardDTO) throws Exception {
		int result = bankBoardDAO.deleteWriting(bankBoardDTO);
		System.out.println(result == 1);
		
		return "redirect:list.iu";
	}
}