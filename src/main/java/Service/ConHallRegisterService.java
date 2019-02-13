package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import Command.ConHallCommand;
import Model.ConHallDTO;
import Model.TicketDAO;

public class ConHallRegisterService {

	private List<ConHallDTO> conHallList;
	
	@Autowired
	private TicketDAO ticketDao;
	
	public void conHallRegist(ConHallCommand cmd) {
		ConHallDTO dto = new ConHallDTO();
		//공연장번호는 쿼리로 바로 넣는다
		dto.setName(cmd.getName());
		System.out.println();
		dto.setCapacity(cmd.getCapacity());
		dto.setAddr(cmd.getAddr()+" "+cmd.getDetailAddr());
		dto.setRow(cmd.getRow());
		dto.setColumn(cmd.getColumn());
		ticketDao.conHallRegist(dto);
		
	}
	
	public List<ConHallDTO> conHallList(){
		conHallList=ticketDao.conHallList();
		return conHallList;
	}
}
