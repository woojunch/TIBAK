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
import Service.TibakMemberRegisterService;

@Controller
public class ConRegisterConrtroller {
	
	private ConRegisterService conRegisterService;
	List<ConDTO> conList;
	
	@Autowired
	public ConRegisterConrtroller(ConRegisterService conRegisterService) {
		this.conRegisterService=conRegisterService;
	}
	
	@RequestMapping(value="/concert/register", method=RequestMethod.GET)
	public String handleConRegister() {
		return "concert/con_register";
	}
	
	@RequestMapping(value="/concert/list", method=RequestMethod.POST)
	public String handleConComplete(ConCommand cmd, Model model) {
		conRegisterService.conRegist(cmd);
		conList = conRegisterService.conList();
		model.addAttribute("conList", conList);
		return "concert/con_list";
	}
	
/*	@RequestMapping(value="/concert/list", method=RequestMethod.GET)
	public String handleConList(Model model) {
		conList = conRegisterService.conList();
		model.addAttribute("conList", conList);
		System.out.println(conList.get(0).getManagementInform());
		return "/concert/con_list";
	}*/
}
