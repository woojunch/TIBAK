package Service;

import org.springframework.beans.factory.annotation.Autowired;

import Command.TicketCommand;
import Model.TicketDAO;
import Model.TicketDTO;

public class TicketRegisterService {
	private TicketDAO ticketDao;
	
	@Autowired
	public TicketRegisterService(TicketDAO ticketDao) {
		this.ticketDao = ticketDao;
	}
	
	public void regist(TicketCommand tcd) {
		TicketDTO dto = new TicketDTO();
		//상품번호는 db에서
		dto.setProNum(1234);
		
		
		dto.setNum(tcd.getNum());
		//공연장번호는 공연장테이블에서
		dto.setHallNum("4321");
		dto.setImage(tcd.getImg());
		dto.setPrice(tcd.getPrice());
		dto.setContent(tcd.getContent());
		dto.setPrice(tcd.getPrice());
		//공연장주소는 공연장테이블에서
		dto.setTrafficImage(tcd.getTrafficInform());
		dto.setReserveInform(tcd.getReserveInform());
		dto.setUseInform(tcd.getUseInform());
		dto.setReserveBan(tcd.getReserveBan());
		dto.setReserveCon("판매예정"); //판매상태
		dto.setAdTime(tcd.getAdTime());
		dto.setExTime(tcd.getExTime());
		dto.setConDate(tcd.getConDate());
		dto.setSaleTerm(tcd.getStartSaleTerm()+"~"+tcd.getEndSaleTerm());
		dto.setConTerm(tcd.getStartConTerm()+"~"+tcd.getEndConterm());
		dto.setGenre(tcd.getGenre());
		dto.setAgeBan(tcd.getAgeBan());
		
		//상영시간 db에서
		dto.setViewTime(200);
		dto.setSeatMap(tcd.getSeatImg());
		
		ticketDao.ticketRegister(dto);
		
	}
}
