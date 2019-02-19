package Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.AccomodationRegisterCommand;
import Service.AccomodationRegisterService;

@RequestMapping("/register")
@Controller
public class AccomodationRegisterController {

		@Autowired
		AccomodationRegisterService accomodationRegisterService;
		
		@RequestMapping(method = RequestMethod.POST)
		
		public String submit(AccomodationRegisterCommand accomodationRegisterCommand, HttpServletRequest request) {

			
			String path = accomodationRegisterService.accomodationsRegister(accomodationRegisterCommand,request);

				return "/main";
	}

	}
	

