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
	private TicketDTO dto;
	
	@Autowired
	public TicketRegisterService(TicketDAO ticketDao) {
		this.ticketDao = ticketDao;
	}
	
	File ImgFile = null;
	File ContentFile = null;


	
	
	String imgOriginalFile = null;
	String contentOriginalFile = null;


	
	String imgOriginalFileExtension = null;
	String contentOriginalFileExtension = null;


	
	String ImgStoreFile = null;
	String ContentStoreFile = null;


	
	
	String ImgFileSize = null;
	String ContentFileSize= null;


	
	String originalFiles = "";
	String storeFiles = "";
	String filesSize = "";
	
	
	public String regist(TicketCommand cmd, HttpServletRequest request) {

		String path = null;
		System.out.println(request.getRealPath("/WEB-INF/view/")+"upfile\\");
		String filePath = request.getRealPath("/WEB-INF/view/")+"upfile\\";
		MultipartFile img = cmd.getImg();
		MultipartFile content = cmd.getContent();
		MultipartFile seatImg = cmd.getSeatImg();
		
		imgOriginalFile = img.getOriginalFilename();
		contentOriginalFile = content.getOriginalFilename();

		// 확장자 추출  (.hwp  .doc)
		
		imgOriginalFileExtension = imgOriginalFile.substring(imgOriginalFile.lastIndexOf("."));
		contentOriginalFileExtension = contentOriginalFile.substring(contentOriginalFile.lastIndexOf("."));

		
		//임의의이름
		ImgStoreFile = UUID.randomUUID().toString().replaceAll("-", "");
		ContentStoreFile = UUID.randomUUID().toString().replaceAll("-", "");

		
		ImgStoreFile = ImgStoreFile+imgOriginalFileExtension;
		ContentStoreFile = ContentStoreFile+contentOriginalFileExtension;


		
		ImgFileSize = Long.toString(img.getSize());
		ContentFileSize =  Long.toString(content.getSize());

		
		ImgFile = new File(filePath+ImgStoreFile); //파일생성
		ContentFile = new File(filePath+ContentStoreFile);

		
		try {
			img.transferTo(ImgFile);
			content.transferTo(ContentFile);

		} catch(Exception e){
			e.printStackTrace();
			return "ticket/ticket_register";
		}
		
		TicketDTO dto = new TicketDTO(cmd.getName(), cmd.getNum(), cmd.getConhallNum(), imgOriginalFile, contentOriginalFile, cmd.getPrice(), cmd.getPhone(), cmd.getReserveInform(), cmd.getUseInform(), cmd.getReserveBan(), cmd.getAdTime(), cmd.getExTime(), cmd.getConDate(), cmd.getStartSaleTerm()+" ~ "+cmd.getEndSaleTerm(),cmd.getStartConTerm()+" ~ "+cmd.getEndConTerm(),cmd.getGenre(),cmd.getAgeBan(),cmd.getViewTime());
		
		ticketDao.ticketRegist(dto, ImgStoreFile, ContentStoreFile);
		
		return null;
		
	}
	
	public List<TicketDTO> ticketList(){
		ticketList = ticketDao.ticketList();
		return ticketList;
	}
	
	public List<TicketDTO> ticketListResult(String theme, String area){
		ticketList = ticketDao.ticketListResult(theme, area);
		return ticketList;
	}

	
	public TicketDTO ticketDetail(String proNum) {
		dto = ticketDao.ticketDetail(proNum);
		return dto;
	}
	
	public void ticketDelete(String proNum) {
		ticketDao.ticketDelete(proNum);
	}
	
	
	
}
