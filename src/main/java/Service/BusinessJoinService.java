package Service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import Command.BusinessCommand;
import Model.BusinessDAO;
import Model.BusinessDTO;

public class BusinessJoinService {
	
	private static BusinessDAO businessDao; 
	@Autowired
	public BusinessJoinService(BusinessDAO businessDao) {
		this.businessDao = businessDao;
	}

	public static void join(BusinessCommand mem) { 
		BusinessDTO member = new BusinessDTO();
		member.setId(mem.getId());
		member.setName(mem.getName());
		member.setPasswd(mem.getPasswd());
		member.setBirth(mem.getBirth());
		member.setCompany(mem.getCom_name());
		member.setEmail(mem.getEmail());
		member.setPhone(mem.getStart_num()+"-"+mem.getPhone_second()+"-"+mem.getPhone_third());
		
		SimpleDateFormat dateForm = new SimpleDateFormat("yyyy-MM-dd");
		String date = dateForm.format(new Date());
		
		member.setDate(date);
		
		businessDao.businessAdd(member);
		
	}

}
