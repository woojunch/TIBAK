package Service;

import org.springframework.beans.factory.annotation.Autowired;

import Command.TicketCommand;
import Model.TicketDAO;

public class TicketRegisterService {
	private TicketDAO ticketDao;
	
	@Autowired
	public TicketRegisterService(TicketDAO ticketDao) {
		this.ticketDao = ticketDao;
	}
	
	public void regist(TicketCommand tcd) {
		
	}
}
