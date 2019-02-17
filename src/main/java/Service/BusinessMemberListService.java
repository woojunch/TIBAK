package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import Model.BusinessDAO;
import Model.BusinessDTO;

public class BusinessMemberListService { 
	
	@Autowired
	private BusinessDAO businessDao;
	List<BusinessDTO> members;
	
	public void setBusinessDao(BusinessDAO businessDao) {
		this.businessDao = businessDao;
	}


	public List<BusinessDTO> memberList() {
		members =businessDao.bmemberList();
		return members;
	}

}
