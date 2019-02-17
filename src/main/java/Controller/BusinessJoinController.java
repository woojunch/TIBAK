package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.BusinessCommand;
import Service.BusinessJoinService; 

@Controller
public class BusinessJoinController {
	private BusinessJoinService businessJoinService;
	
	@Autowired
	public BusinessJoinController(BusinessJoinService businessJoinService) {
		this.businessJoinService = businessJoinService;
	}
	
	@RequestMapping(value="businessJoin",  method=RequestMethod.GET)
	public String join() { 
		return "business/businessJoin"; 
	}
	@RequestMapping(value="businessJoin", method=RequestMethod.POST)
	public String join1(BusinessCommand mem) {
		BusinessJoinService.join(mem);
		return "business/businessJoinSuccess";
	}
}
