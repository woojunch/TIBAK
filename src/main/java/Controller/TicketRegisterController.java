package Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import Command.TicketCommand;
import Service.TicketRegisterService;

@Controller
public class TicketRegisterController {
	
	@Autowired
	private TicketRegisterService ticketRegisterService;
	
	
	@RequestMapping(value="/ticket/register", method=RequestMethod.GET)
	public String handleTicketRegister() {
		return "ticket/ticket_register";
	}
	
	@RequestMapping(value="/ticket/list", method=RequestMethod.POST)
	public String handleTicketRegisterComplete(TicketCommand tcd) {
		ticketRegisterService.regist(tcd);
		return "ticket/ticket_register2";
	}
}
