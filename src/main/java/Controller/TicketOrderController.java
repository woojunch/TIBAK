package Controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import Command.OrderCommand;
import Model.AuthInfo;
import Model.ConHallDTO;
import Model.MemberJoinDTO;
import Model.OrderDetailDTO;
import Model.SeatDTO;
import Model.TicketDTO;
import Model.TicketOrderDTO;
import Service.TicketOrderService;

@Controller
public class TicketOrderController {
	
	ConHallDTO conhalldto;
	TicketDTO ticketdto;
	MemberJoinDTO memberdto;
	List<SeatDTO> purchasedSeat;
	List<Integer> seatNum;
	List<TicketOrderDTO> orderList;
	OrderDetailDTO detail;
	
	
	@Autowired
	private TicketOrderService ticketOrderService;
	
	//좌석선택
	@RequestMapping(value="/seatChoice", method=RequestMethod.GET)
	public String handleOrder(@RequestParam("proNum") String proNum,
								@RequestParam("hallNum") String hallNum, Model model) {
		
		conhalldto = ticketOrderService.seatMap(hallNum);

		seatNum = ticketOrderService.seatInfo(proNum, conhalldto);
		System.out.println(conhalldto.getRow());
		model.addAttribute("conhalldto", conhalldto);
		model.addAttribute("proNum", proNum);
		model.addAttribute("seatNum", seatNum);
		return "order/seatChoice";
	}
	
	@RequestMapping(value="/buyPage", method=RequestMethod.POST)
	public String handleBuyPage(@RequestParam("proNum") String proNum,
								@RequestParam("rowNum") String rowNum,
								@RequestParam("columnNum") String columnNum,
								Model model,HttpServletRequest request) {
		
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		memberdto = ticketOrderService.memberInfo(authInfo);
		ticketdto = ticketOrderService.proInfo(proNum);
					
		model.addAttribute("proNum", proNum);
		model.addAttribute("rowNum", rowNum);
		model.addAttribute("columnNum", columnNum);
		model.addAttribute("memberdto", memberdto);
		model.addAttribute("ticketdto", ticketdto);
		
		return "order/buyPage";
		
	}
	
	@RequestMapping(value="/orderComplete", method=RequestMethod.POST)
	public String handleOrderComplete(OrderCommand cmd) {
		ticketOrderService.orderInsert(cmd);
		return "order/orderComplete";
	}
	
	@RequestMapping(value="/order/orderhistory", method=RequestMethod.GET)
	public String handleOrderHistory(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		AuthInfo authInfo = (AuthInfo)session.getAttribute("authInfo");
		String id = authInfo.getId();
		orderList = ticketOrderService.orderList(id);
		model.addAttribute("orderList", orderList);
		return "order/orderHistory";
	}
	
	@RequestMapping(value="/order/orderDetail", method=RequestMethod.GET)
	public String handleOrderDetail(@RequestParam("oNum") String onum, Model model) {
		detail = ticketOrderService.orderDetail(onum);
		model.addAttribute("detail", detail);
		return "order/orderDetail";
	}
}
