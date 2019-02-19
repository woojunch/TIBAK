package Controller; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.MemberJoin; 
import Service.MemberJoinService;

@Controller
public class MemberJoinController {
	private MemberJoinService memberJoinService; 

	
	@Autowired
	public MemberJoinController(MemberJoinService memberJoinService) {
		this.memberJoinService  = memberJoinService;
	}
	
	
	 
	
	@RequestMapping(value="memberJoin", method=RequestMethod.GET)
	public String join() { 
		return "member/memberJoin"; 
	}
	@RequestMapping(value="memberJoin", method=RequestMethod.POST)
	public String join1(MemberJoin mem) {
		MemberJoinService.join(mem);
		return "member/memberJoin";
	}
	@RequestMapping(value="joinChoice", method=RequestMethod.GET)
	public String joinChoice() {
		return "member/joinChoice";
	}
}
