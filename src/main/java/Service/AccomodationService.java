package Service;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import Command.AccomodationCommand;
import Model.AccomodationDTO;
import Model.AccomodationDao;


public class AccomodationService {
	@Autowired
	private AccomodationDao accomodationDao;
	private File file = null;
	private String originalFile = null;
	private String originalFileExtension = null;
	private String storeFile = null;
	private String fileSize = null;

	


	public String accomodations(AccomodationCommand accomodationCommand,
			HttpServletRequest request) {
		String path = null;

		System.out.println(request.getRealPath("/WEB-INF/view/")+"Accomodation\\upfile\\");

		String filePath = request.getRealPath("/WEB-INF/view/")+"Accomodation\\upfile\\";
		System.out.println(accomodationCommand.getBoardFile()+"이거");
		MultipartFile report = accomodationCommand.getBoardFile();

		originalFile = report.getOriginalFilename();
		System.out.println(originalFile);
		originalFileExtension =originalFile.substring(originalFile.lastIndexOf("."));
		storeFile = UUID.randomUUID().toString().replaceAll("-", "");
		storeFile = storeFile + originalFileExtension;

		fileSize = Long.toString(report.getSize());
		file = new File(filePath+storeFile); 
		try {
			report.transferTo(file);
		} catch (IllegalStateException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String a=accomodationCommand.getAddress();
		String area=a.substring(0, 2);
		String address=accomodationCommand.getAddress()+" "+accomodationCommand.getAddressDetail();
		AccomodationDTO accomodationDTO  = 
				new AccomodationDTO(accomodationCommand.getbFacilityName(),
						accomodationCommand.getbFacilityRoom(),
						area,address,accomodationCommand.getbFacilityImform(), originalFile, storeFile);
		Integer i1;
		try {
			i1 = accomodationDao.insert(accomodationDTO);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	


		return path;
	}




}


