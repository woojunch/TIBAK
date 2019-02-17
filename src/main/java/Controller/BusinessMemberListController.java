package Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Model.BusinessDTO;
import Model.MemberJoinDTO;
import Service.BusinessMemberListService;
import Service.MemberListService;

@Controller
public class BusinessMemberListController {
	@Autowired
	private BusinessMemberListService businessMemberListService;
	
	public void setMemberListService(BusinessMemberListService businessMemberListService) {
		this.businessMemberListService = businessMemberListService;
	}
	
	@RequestMapping(value="bmemberList", method=RequestMethod.GET)
	public String list( Model model ) { 
		List<BusinessDTO> members = businessMemberListService.memberList(); 
		model.addAttribute("members", members);
		return "business/businessMemberList";
	}
}
