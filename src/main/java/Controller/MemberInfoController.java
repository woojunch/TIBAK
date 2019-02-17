package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.MemberInfoCommand;
import Service.MemberInfoService;

@Controller
public class MemberInfoController {
	private MemberInfoService memberInfoService;
	
	@Autowired
	public MemberInfoController(MemberInfoService memberInfoService) {
		this.memberInfoService = memberInfoService;
	}
	
	
	@RequestMapping(value="memberInfo", method=RequestMethod.GET)
	public String Info() {
		return "mypage/memberInfo";
	}
	@RequestMapping(value="memberInfo", method=RequestMethod.POST)
	public String Info1(MemberInfoCommand mem) {
		MemberInfoService.update(mem);
		return "mypage/memberInfo";
	}
	
}
