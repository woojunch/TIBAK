package Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import Command.OrderCommand;
import Model.AuthInfo;
import Model.ConHallDTO;
import Model.MemberJoinDTO;
import Model.OrderDAO;
import Model.OrderDetailDTO;
import Model.SeatDTO;
import Model.TicketDTO;
import Model.TicketOrderDTO;

public class TicketOrderService {

	String hallNum;
	ConHallDTO dto;
	TicketDTO ticketdto;
	MemberJoinDTO memberdto;
	List<SeatDTO> purchasedSeat;
	SeatDTO seatdto;
	 List<TicketOrderDTO> orderList;
	 OrderDetailDTO detail;

	@Autowired
	private OrderDAO orderDao;

	public ConHallDTO seatMap(String hallNum) {
		dto = orderDao.seatMap(hallNum);
		return dto;
	}

	public MemberJoinDTO memberInfo(AuthInfo authInfo) {

		memberdto = orderDao.memberInfo(authInfo);
		return memberdto;
	}

	public TicketDTO proInfo(String proNum) {
		ticketdto = orderDao.ticketInfo(proNum);
		return ticketdto;
	}

	public void orderInsert(OrderCommand cmd) {
		TicketOrderDTO dto = new TicketOrderDTO();
		dto.setProNum(cmd.getProNum());
		dto.setcWay(cmd.getcWay());
		dto.setId(cmd.getId());
		dto.setPrice(cmd.getPrice());

		SimpleDateFormat dateForm = new SimpleDateFormat("yyyy-MM-dd");
		String date = dateForm.format(new Date());
		dto.setcDate(date);
		dto.setCardName(cmd.getCard());
		dto.setCardNum(cmd.getCardNum1() + cmd.getCardNum2() + cmd.getCardNum3() + cmd.getCardNum4());
		dto.setHalbu(cmd.getHalbu());
		dto.setSeatNum(cmd.getSeatNum());
		orderDao.ticketInfo(dto);
	}

	public List<Integer> seatInfo(String proNum, ConHallDTO conhalldto) {
		List<Integer> seatNum = new ArrayList<Integer>();
		purchasedSeat = orderDao.seatInfo(proNum);

		if (purchasedSeat.size() == 0) {
			seatNum.add(0);
		} else {
			for (int i = 0; i < purchasedSeat.size(); i++) {
				int row = Integer.parseInt(purchasedSeat.get(i).getRowNum());
				int column = Integer.parseInt(purchasedSeat.get(i).getColumnNum());
				// 만약 5x5행렬에서 2행 2열 7이 나와야함

				int num = (row - 1) * conhalldto.getColumn() + column;

				seatNum.add(num);

			}
		}
		Collections.sort(seatNum);
		return seatNum;
	}
	
	public List<TicketOrderDTO> orderList(String id){
		orderList=orderDao.orderList(id);
		return orderList;
	}
	
	public OrderDetailDTO orderDetail(String onum){
		detail=orderDao.orderDetail(onum);
		return detail;
	}
}
