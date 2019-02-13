package Service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import Command.TicketCommand;
import Model.TicketDAO;
import Model.TicketDTO;

public class TicketRegisterService {
	private TicketDAO ticketDao;
	
	@Autowired
	public TicketRegisterService(TicketDAO ticketDao) {
		this.ticketDao = ticketDao;
	}
	
	File file = null;
	String imgOriginalFile = null;
	String trafficOriginalFile = null;
	String seatOriginalFile = null;
	
	String imgOriginalFileExtension = null;
	String trafficOriginalFileExtension = null;
	String seatOriginalFileExtension = null;
	
	String storeFile = null;
	String fileSize = null;
	
	String originalFiles = "";
	String storeFiles = "";
	String filesSize = "";
	
	
	public String regist(TicketCommand tcd,HttpServletRequest request) {
		System.out.println("뭐야");
		String path = null;
		System.out.println(request.getRealPath("/WEB-INF/view/")+"ticket\\upfile\\");
		String filePath = request.getRealPath("/WEB-INF/view/")+"ticket\\upfile\\";
		MultipartFile img = tcd.getImg();
		MultipartFile trafficInform = tcd.getTrafficInform();
		MultipartFile seatImg = tcd.getSeatImg();
		
		imgOriginalFile = img.getOriginalFilename();
		trafficOriginalFile= trafficInform.getOriginalFilename();
		seatOriginalFile=seatImg.getOriginalFilename();
		// 확장자 추출  (.hwp  .doc)
		
		imgOriginalFileExtension = imgOriginalFile.substring(imgOriginalFile.lastIndexOf("."));
		trafficOriginalFileExtension = trafficOriginalFile.substring(trafficOriginalFile.lastIndexOf("."));
		seatOriginalFileExtension = seatOriginalFile.substring(seatOriginalFile.lastIndexOf("."));
		
		
		return null;
		
		
/*		
		
		
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
		
		ticketDao.ticketRegister(dto);*/
		
	}
}
