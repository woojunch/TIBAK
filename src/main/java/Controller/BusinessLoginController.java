package Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.BusinessLoginCommand;
import Model.BusinessAuthInfo;
import Service.BusinessLoginService;

@Controller
public class BusinessLoginController {
	@Autowired
	private BusinessLoginService businessLoginService;
	
	@RequestMapping(value="blogin", method=RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("bmemberLogin", new BusinessLoginCommand());

		return "business/businessLogin";
	}

	@RequestMapping(value="bloginSuccess", method=RequestMethod.POST)
	public String login1(BusinessLoginCommand memberLogin, HttpSession session) {
		try {  
			BusinessAuthInfo authInfo = businessLoginService.chkLogin(memberLogin.getId(), memberLogin.getPassword()); 
			session.setAttribute("authInfo", authInfo);

			return "business/businessLoginSuccess";
		}catch (Exception e) {
			return "business/businessLogin";
		}

	}

}
