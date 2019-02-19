package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Command.ConCommand;
import Model.ConDTO;
import Service.ConRegisterService;

@Controller
public class ConRegisterConrtroller {
	
	private ConRegisterService conRegisterService;
	List<ConDTO> conList;
	
	@Autowired
	public ConRegisterConrtroller(ConRegisterService conRegisterService) {
		this.conRegisterService=conRegisterService;
	}
	
	//공연등록페이지
	@RequestMapping(value="/concert/register", method=RequestMethod.GET)
	public String handleConRegisterView() {
		return "concert/con_register";
	}
	//공연상품등록하기 위해 공연리스트불러오기
	@RequestMapping(value="/concert/register", method=RequestMethod.POST)
	public String handleConRegister(ConCommand cmd) {
		conRegisterService.conRegist(cmd);
		return "redirect:/concert/list";
	}
	
	@RequestMapping(value="/concert/list", method=RequestMethod.GET)
	public String handleConComplete(Model model) {
		conList = conRegisterService.conList();
		model.addAttribute("conList", conList);
		return "concert/con_list";
	}
	
	
	
	//공연등록
	@RequestMapping(value="/concert/list", method=RequestMethod.POST)
	public String handleConComplete(ConCommand cmd, Model model) {
		conList = conRegisterService.conList();
		model.addAttribute("conList", conList);
		return "concert/con_list";
	}
	
	//공연삭제
	@RequestMapping(value="/concert/delete", method=RequestMethod.GET)
	public String handleDelete(@RequestParam("conNum") String num) {
		conRegisterService.conDelete(num);
		return "redirect:/concert/list";
		
	}
}
