package Service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import Command.TicketCommand;
import Model.TicketDAO;
import Model.TicketDTO;

public class TicketRegisterService {
	private TicketDAO ticketDao;
	private List<TicketDTO> ticketList;
	
	@Autowired
	public TicketRegisterService(TicketDAO ticketDao) {
		this.ticketDao = ticketDao;
	}
	
	File ImgFile = null;
	File TrafficFile = null;
	File SeatFile = null;
	String imgOriginalFile = null;
	String trafficOriginalFile = null;
	String seatOriginalFile = null;
	
	String imgOriginalFileExtension = null;
	String trafficOriginalFileExtension = null;
	String seatOriginalFileExtension = null;
	
	String ImgStoreFile = null;
	String TrafficStoreFile = null;
	String SeatStoreFile = null;
	
	
	String ImgFileSize = null;
	String TrafficFileSize = null;
	String SeatFileSize = null;
	
	String originalFiles = "";
	String storeFiles = "";
	String filesSize = "";
	
	
	public String regist(TicketCommand cmd, HttpServletRequest request) {
		System.out.println("뭐야");
		System.out.println(cmd.getNum());
		System.out.println(cmd.getImg());
		System.out.println(cmd.getPrice());
		System.out.println(cmd.getStartConTerm());
		String path = null;
		System.out.println(request.getRealPath("/WEB-INF/view/")+"ticket\\upfile\\");
		String filePath = request.getRealPath("/WEB-INF/view/")+"ticket\\upfile\\";
		MultipartFile img = cmd.getImg();
		MultipartFile trafficInform = cmd.getTrafficInform();
		MultipartFile seatImg = cmd.getSeatImg();
		
		imgOriginalFile = img.getOriginalFilename();
		trafficOriginalFile= trafficInform.getOriginalFilename();
		seatOriginalFile=seatImg.getOriginalFilename();
		// 확장자 추출  (.hwp  .doc)
		
		imgOriginalFileExtension = imgOriginalFile.substring(imgOriginalFile.lastIndexOf("."));
		trafficOriginalFileExtension = trafficOriginalFile.substring(trafficOriginalFile.lastIndexOf("."));
		seatOriginalFileExtension = seatOriginalFile.substring(seatOriginalFile.lastIndexOf("."));
		
		//임의의이름
		ImgStoreFile = UUID.randomUUID().toString().replaceAll("-", "");
		TrafficStoreFile = UUID.randomUUID().toString().replaceAll("-", "");
		SeatStoreFile = UUID.randomUUID().toString().replaceAll("-", "");
		
		ImgStoreFile = ImgStoreFile+imgOriginalFileExtension;
		TrafficStoreFile = TrafficStoreFile+trafficOriginalFileExtension;
		SeatStoreFile = SeatStoreFile+seatOriginalFileExtension;
		System.out.println("Asdf: "+ImgStoreFile);
		
		ImgFileSize = Long.toString(img.getSize());
		TrafficFileSize = Long.toString(trafficInform.getSize());
		SeatFileSize = Long.toString(seatImg.getSize());
		
		ImgFile = new File(filePath+ImgStoreFile); //파일생성
		TrafficFile = new File(filePath+TrafficStoreFile); //파일생성
		SeatFile = new File(filePath+SeatStoreFile); //파일생성
		
		try {
			img.transferTo(ImgFile);
			trafficInform.transferTo(TrafficFile);
			seatImg.transferTo(SeatFile);
		} catch(Exception e){
			e.printStackTrace();
			return "ticket/ticket_register";
		}
		
		TicketDTO dto = new TicketDTO(cmd.getName(), cmd.getName(), cmd.getConhallNum(), imgOriginalFile, cmd.getContent(), cmd.getPrice(), cmd.getPhone(), trafficOriginalFile, cmd.getReserveInform(), cmd.getUseInform(), cmd.getReserveBan(), cmd.getAdTime(), cmd.getExTime(), cmd.getConDate(), cmd.getStartSaleTerm()+"~"+cmd.getEndSaleTerm(),cmd.getStartConTerm()+"~"+cmd.getEndConTerm(),cmd.getGenre(),cmd.getAgeBan(),cmd.getViewTime(),seatOriginalFile);
		
		ticketDao.ticketRegist(dto, ImgStoreFile, TrafficStoreFile, SeatStoreFile);
		
		return null;
		
	}
	
	public List<TicketDTO> ticketList(){
		ticketList = ticketDao.ticketList();
		return ticketList;
	}
	
	public void ticketProRegist() {
		
	}
}
