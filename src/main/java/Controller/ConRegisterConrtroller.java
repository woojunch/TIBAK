package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public String handleConRegister() {
		return "concert/con_register";
	}
	//공연등록
	@RequestMapping(value="/concert/register", method=RequestMethod.POST)
	public String handleConComplete(ConCommand cmd) {
		conRegisterService.conRegist(cmd);
		return "redirect:/concert/list";
	}
	
	//공연등록
	@RequestMapping(value="/concert/list", method={RequestMethod.GET, RequestMethod.POST})
	public String handleConComplete(ConCommand cmd, Model model) {
		conList = conRegisterService.conList();
		model.addAttribute("conList", conList);
		return "concert/con_list";
	}
}
