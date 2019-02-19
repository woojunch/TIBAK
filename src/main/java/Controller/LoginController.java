package Controller;

import javax.servlet.http.HttpServletRequest;
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
public class LoginController {

	@Autowired
	private LoginService loginService;

	//로그인 선택
	@RequestMapping(value="loginChoice")
	public String loginChoice() {
		return "member/loginChoice";
	}
	
	
	
	
	//로그인
	@RequestMapping(value="login", method=RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute("memberLogin", new MemberLogin());

		return "member/login";
	}

	@RequestMapping(value="main", method=RequestMethod.GET)
	public String main() {
		return "main";
	}
	
	
	@RequestMapping(value="main", method=RequestMethod.POST)
	public String login1(MemberLogin memberLogin, HttpSession session) {
		try {  
			AuthInfo authInfo = loginService.chkLogin(memberLogin.getId(), memberLogin.getPassword()); 
			if(authInfo!=null) {
				session.setAttribute("authInfo", authInfo);
			}
			return "main";
		}catch (Exception e) {
			System.out.println("뭐야 ㅠㅠ");
			return "member/login";
		}
		
	}
	//로그아웃
	@RequestMapping(value="main/logout", method=RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate(); //session삭제
		return "redirect:/main";
	}
}
