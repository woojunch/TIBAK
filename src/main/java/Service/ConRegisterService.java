package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import Command.ConCommand;
import Model.ConDTO;
import Model.TicketDAO;

public class ConRegisterService {
	private TicketDAO ticketDao;
	private List<ConDTO> conList;
	
	@Autowired
	public ConRegisterService(TicketDAO ticketDao) {
		this.ticketDao = ticketDao;
	}
	
	public ConRegisterService() {
		
	}
	
	public void conRegist(ConCommand cmd) {
		ConDTO con=new ConDTO();
		con.setName(cmd.getName());
		con.setShowTime(cmd.getShowTime());
		con.setManagementInform(cmd.getManagementInform());
		System.out.println(con.getName());
		ticketDao.conRegist(con);
	}
	
	public List<ConDTO> conList(){
		conList = ticketDao.conList();
		return conList;
	}
	
	public void conDelete(String num) {
		ticketDao.conDelete(num);
	}
}
