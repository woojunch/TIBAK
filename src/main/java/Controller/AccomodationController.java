package Controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.AccomodationCommand;
import Service.AccomodationService;


@Controller
@RequestMapping("/Accomodation")
public class AccomodationController {
	@Autowired
	AccomodationService accomodationService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return "Accomodation/AccomodForm";
	}
	
	@RequestMapping(method = RequestMethod.POST)

	public String submit(AccomodationCommand accomodationCommand, HttpServletRequest request) {

		
		String path = accomodationService.accomodations(accomodationCommand,request);



			return "/main";
}

}


