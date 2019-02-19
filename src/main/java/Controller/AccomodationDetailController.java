package Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import Model.AccomodationDTO;
import Model.AccomodationRegisterDTO;
import Service.AccomodationDetailService;
import Service.AccomodationMainService;


@Controller

public class AccomodationDetailController {
	@Autowired
	AccomodationDetailService accomodationDetailService;
	
	
	@RequestMapping("/detail")
	public String form(Model model,@RequestParam(value="no", defaultValue = "false" ) int num	) {
	
		
		
		List<AccomodationDTO> list = new ArrayList<AccomodationDTO>();
		List<AccomodationRegisterDTO> list1 = new ArrayList<AccomodationRegisterDTO>();

		list=accomodationDetailService.detetail(num);
		list1=accomodationDetailService.detetail1(num);
		model.addAttribute("list", list);
		model.addAttribute("list1", list1);
	return "AccomodationDetail/AccomodationDetail";
	}
	
}

	
	
	
