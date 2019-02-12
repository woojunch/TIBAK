package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.TicketCommand;
import Service.TicketRegisterService;

@Controller
public class TicketRegisterController {
	
	private TicketRegisterService ticketRegisterService;
	
	
	@RequestMapping(value="/register/ticket", method=RequestMethod.GET)
	public String handleTicketRegister() {
		return "ticket/ticket_register";
	}
	
	@RequestMapping(value="/register/ticket", method=RequestMethod.POST)
	public String handleTicketRegisterComplete(TicketCommand tcd) {
		ticketRegisterService.regist(tcd);
		return "ticket/ticket_register2";
	}
}
