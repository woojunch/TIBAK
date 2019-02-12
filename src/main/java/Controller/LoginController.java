package Controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.MemberLogin;
import Model.AuthInfo;
import Service.LoginService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping(method=RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("memberLogin", new MemberLogin());

		return "login";
	}

	@RequestMapping(method=RequestMethod.POST)
	public String login1(MemberLogin memberLogin, HttpSession session) {
		try {
			
			AuthInfo authInfo = loginService.chkLogin(memberLogin.getId(), memberLogin.getPassword());
			System.out.println("여기");
			session.setAttribute("authInfo", authInfo);

			return "loginSuccess";
		}catch (Exception e) {
			return "login";
		}

	}
}
