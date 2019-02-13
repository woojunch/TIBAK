package Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import Command.TicketCommand;
import Service.TicketRegisterService;

@Controller
public class TicketRegisterController {
	
	@Autowired
	private TicketRegisterService ticketRegisterService;
	
	//티켓상품등록페이지
	@RequestMapping(value="/ticket/register", method=RequestMethod.GET)
	public String handleTicketRegisterView() {
		return "ticket/ticket_register";
	}
	//티켓등록
	@RequestMapping(value="/ticket/register", method=RequestMethod.POST)
	public String handleTickertRegister(
		@RequestParam("num") String num,
		@RequestParam("name") String name,
		@RequestParam("img") MultipartFile img,
		@RequestParam("content") String content,
		@RequestParam("price") int price,
		@RequestParam("conhallNum") String conhallNum,
		@RequestParam("phone") String phone,
		@RequestParam("trafficInform") MultipartFile trafficInform,
		@RequestParam("reserveInform") String reserveInform,
		@RequestParam("useInform") String useInform,
		@RequestParam("reserveBan") int reserveBan,
		@RequestParam("adTime") String adTime,
		@RequestParam("exTime") String exTime,
		@RequestParam("startConTerm") String startConTerm,
		@RequestParam("endConterm") String endConterm,
		@RequestParam("conDate") String conDate,
		@RequestParam("startSaleTerm") String startSaleTerm,
		@RequestParam("endSaleConterm") String endSaleConterm,
		@RequestParam("ageBan") int ageBan,
		@RequestParam("viewTime") int viewTime,
		@RequestParam("seatImg") MultipartFile seatImg,
		@RequestParam("genre") String genre,
		HttpServletRequest request, Model model){
		TicketCommand tcd = new TicketCommand(num,name,img,content,price,conhallNum,phone,trafficInform,
				reserveInform,useInform,reserveBan,adTime,exTime,startConTerm,endConterm,conDate,startSaleTerm,endSaleConterm,
				ageBan,viewTime,seatImg,genre);
		
/*		String path=ticketRegisterService.regist(tcd,request);*/
		
		
		
		
		
		
		
		
//		ticketRegisterService.regist(tcd);
		return "path";
	}

}
