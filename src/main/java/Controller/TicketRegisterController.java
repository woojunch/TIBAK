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
import org.springframework.web.multipart.MultipartFile;

import Command.TicketCommand;
import Model.TicketDTO;
import Service.TicketRegisterService;

@Controller
public class TicketRegisterController {
	
	List<TicketDTO> ticketList;
	TicketDTO dto;
	@Autowired
	private TicketRegisterService ticketRegisterService;
	
	//티켓상품등록페이지
	@RequestMapping(value="/ticket/register", method=RequestMethod.GET)
	public String handleTicketRegisterView(@RequestParam("conNum") String num, Model model) {
		model.addAttribute("num",num);
		return "ticket/ticket_register";
	}
	
	//티켓등록
	@RequestMapping(value="/ticket/register", method=RequestMethod.POST)
	public String handleTickertRegister(TicketCommand cmd, HttpServletRequest request) {
		String path=ticketRegisterService.regist(cmd, request);
		return "redirect:/ticket/list";
	}
	
	//티켓상품관리리스트
	@RequestMapping(value="/ticket/list",  method={RequestMethod.GET, RequestMethod.POST})
	public String handleTicketList(Model model) {
		ticketList=ticketRegisterService.ticketList();
		model.addAttribute("ticketList",ticketList);
		return "ticket/ticket_list";
	}
	
	//티켓상품메인리스트
	@RequestMapping(value="/ticket/mainview",method={RequestMethod.GET, RequestMethod.POST})
	public String handleTicketView(HttpServletRequest request, Model model) {
		ticketList=ticketRegisterService.ticketList();
		model.addAttribute("ticketList",ticketList);
		
		return "ticket_view_main/con_main";
	}
	
	//티켓상품디테일
	@RequestMapping(value="/ticket/detail", method=RequestMethod.GET)
	public String handleTicketDetailView(@RequestParam("num") String proNum, Model model) {
		dto=ticketRegisterService.ticketDetail(proNum);
		model.addAttribute("dto",dto);
		return "ticket_view_main/ticket_detail";
	}
	//장르/지역
	@RequestMapping(value="/ticket/search", method=RequestMethod.GET)
	public String handleSearch(Model model) {
		ticketList=ticketRegisterService.ticketList();
		model.addAttribute("ticketList",ticketList);
		return "ticket_view_main/ticket_search";
	}
	
	//장르검색결과리스트
	@RequestMapping(value="/ticket/search", method=RequestMethod.POST)
	public String handleSearchResult(@RequestParam("theme") String theme, @RequestParam("area") String area, Model model) {
		ticketList=ticketRegisterService.ticketListResult(theme, area);
		model.addAttribute("ticketList",ticketList);
		return "ticket_view_main/ticket_search";
	}
	
	@RequestMapping(value="/ticket/delete", method=RequestMethod.GET)
	public String handleDelete(@RequestParam("proNum") String proNum) {
		System.out.println("번호:"+proNum);
		ticketRegisterService.ticketDelete(proNum);
		return "redirect:/ticket/list";
	}
}
