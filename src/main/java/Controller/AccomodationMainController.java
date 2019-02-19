package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.AccomodationCommand;
import Model.AccomodationDTO;
import Service.AccomodationMainService;
import Service.AccomodationService;


@Controller
public class AccomodationMainController {

	
	@Autowired
	AccomodationMainService accomodationMainService;
	@RequestMapping("/Accomodation/main")
	public String form(Model model) {
		List<AccomodationDTO> list = new ArrayList<AccomodationDTO>();


		list=accomodationMainService.accomodationList();
		model.addAttribute("list", list);

		return "AccomodationMain/main";
	}

}




