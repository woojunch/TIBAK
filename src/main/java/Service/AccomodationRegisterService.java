package Service;

import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import Command.AccomodationCommand;
import Command.AccomodationRegisterCommand;
import Model.AccomodationDao;
import Model.AccomodationRegisterDTO;



public class AccomodationRegisterService {
	@Autowired
	private AccomodationDao accomodationDao;
	private File file = null;
	private String originalFile = null;
	private String originalFileExtension = null;
	private String storeFile = null;
	private String fileSize = null;
	private String time1;
	private String time2;
	private String originalFiles = "";
	private String storeFiles = "";
	private String filesSize = "";

	
	
	public String accomodationsRegister(AccomodationRegisterCommand accomodationRegisterCommand,
			HttpServletRequest request) {
		String path = null;
		
		System.out.println(request.getRealPath("/WEB-INF/view/")+"Accomodation\\upfile1\\");
		
		String filePath = request.getRealPath("/WEB-INF/view/")+"Accomodation\\upfile1\\";
		MultipartFile[] reports = accomodationRegisterCommand.getBoardFile();
		
		System.out.println(reports.length);
		int i = 1;
		for(MultipartFile report : reports) {
            System.out.println(report.getOriginalFilename()+" report.getOriginalFilename()");
			originalFile = report.getOriginalFilename();
			  System.out.println(originalFile+" originalFile");
			originalFileExtension = originalFile.substring(originalFile.lastIndexOf("."));
			System.out.println(originalFileExtension+" originalFileExtension");
			storeFile = UUID.randomUUID().toString().replaceAll("-", "");
			System.out.println(storeFile+" storeFile");
			storeFile = storeFile + originalFileExtension;
			System.out.println(storeFile+" storeFile");
			file = new File(filePath+storeFile); 
			System.out.println(filePath+storeFile+" filePath+storeFile");
			try {
				report.transferTo(file);
				System.out.println(originalFile +" originalFile");
				originalFiles += originalFile +"-";
				storeFiles += storeFile + "-";
				filesSize += fileSize + "-";
			}catch(Exception e) {	
				e.printStackTrace();
				return "report/submissionForm";
			}
			System.out.println("여기서끝나");
		}
		time1=accomodationRegisterCommand.getProAdTime1()+" "+accomodationRegisterCommand.getProAdTime2()+":"+accomodationRegisterCommand.getProAdTime3();
        time2=accomodationRegisterCommand.getProExTime1()+" "+accomodationRegisterCommand.getProExTime2()+":"+accomodationRegisterCommand.getProExTime3();

		System.out.println(originalFiles+"originalFiles 끝");
		
		AccomodationRegisterDTO accomodationRegisterDTO =new AccomodationRegisterDTO
		(accomodationRegisterCommand.getNum(),accomodationRegisterCommand.getaProPrice(),accomodationRegisterCommand.getaProPrices(),
		accomodationRegisterCommand.getProReserveBan(),time1,time2,accomodationRegisterCommand.getaProMeal(),
		accomodationRegisterCommand.getaProKind(),storeFiles,originalFiles);
		Integer i1;
		
		try {
			i1=accomodationDao.Register(accomodationRegisterDTO);
			originalFiles="";
			storeFiles="";
			if(i1 > 0) {  
				path = "report/submissionComplete";
			}else {
				String[] fileNames = storeFiles.split("-");
				for(String fileName : fileNames) {
					File f = new File(filePath+fileName);
					if(f.exists()) 
						{	
							f.delete(); 
						}
				}
				path = "report/submissionForm";
			}
			
			
		
		
		
		
		
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return path;
	}
	
	
	
	
}


