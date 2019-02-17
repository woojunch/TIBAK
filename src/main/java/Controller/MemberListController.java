package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Model.MemberJoinDTO;
import Service.MemberListService;

@Controller
public class MemberListController {
	@Autowired
	private MemberListService memberListService;
	
	public void setMemberListService(MemberListService memberListService) {
		this.memberListService = memberListService;
	}
	
	@RequestMapping(value="memberList", method=RequestMethod.GET)
	public String list(Model model ) { 
		List<MemberJoinDTO> members = memberListService.memberList();
		model.addAttribute("members", members);
		return "member/memberList";
	}
}
