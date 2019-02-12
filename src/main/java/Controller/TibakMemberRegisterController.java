package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.MemberCommand;
import Model.TibakMember;
import Service.TibakMemberRegisterService;


@Controller
public class TibakMemberRegisterController {
	
	private TibakMemberRegisterService tibakMemberRegisterService;
	List<TibakMember> memberList;

	@Autowired
	public TibakMemberRegisterController(TibakMemberRegisterService tibakMemberRegisterService) {
		this.tibakMemberRegisterService=tibakMemberRegisterService;
	}
	
	@RequestMapping(value="/register/member", method=RequestMethod.GET)
	public String handleMember(Model model) {
		//커맨드객체전달
		model.addAttribute("memberCommand", new MemberCommand());
		return "register/member";
	}
	
	@RequestMapping(value="/register/member2", method=RequestMethod.POST)
	public String handleMember2(MemberCommand mcd) {
		tibakMemberRegisterService.regist(mcd);
		return "register/member2";
	}
	
	@RequestMapping(value="/tibakmember/list", method=RequestMethod.GET)
	public String handleMemberList(Model model) {
		memberList = tibakMemberRegisterService.memberList();
		model.addAttribute("memberList", memberList);
		return "member/tibakMemberList";
	}
}
