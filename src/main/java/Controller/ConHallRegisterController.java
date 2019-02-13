package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.ConHallCommand;
import Model.ConHallDTO;
import Service.ConHallRegisterService;

@Controller
public class ConHallRegisterController {
	
	List<ConHallDTO> conHallList;
	@Autowired
	private ConHallRegisterService conHallRegisterService;
	
	//공연장등록페이지
	@RequestMapping(value="/conhall/register", method=RequestMethod.GET)
	public String ConHallRegisterView() {
		return "conhall/conhall_register";
	}
	//공연장등록
	@RequestMapping(value="/conhall/register", method=RequestMethod.POST)
	public String ConHallRegister(ConHallCommand cmd) {
		conHallRegisterService.conHallRegist(cmd);
		return "redirect:/conhall/list";
	}
	//공연장리스트
	@RequestMapping(value="/conhall/list", method={RequestMethod.GET, RequestMethod.POST})
	public String ConHallList(ConHallCommand cmd, Model model) {
		conHallList=conHallRegisterService.conHallList();
		model.addAttribute("conHallList", conHallList);
		return "conhall/conhall_list";
	}
	
	@RequestMapping(value="/conhall/popuplist", method=RequestMethod.GET)
	public String ConHallPopList(Model model) {
		conHallList=conHallRegisterService.conHallList();
		model.addAttribute("conHallList", conHallList);
		return "conhall/conhall_popuplist";
	}
}
