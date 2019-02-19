package Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import Model.AccomodationDTO;
import Model.AccomodationDao;
import Model.AccomodationRegisterDTO;

public class AccomodationDetailService {

	@Autowired
	private AccomodationDao accomodationDao;
	List<AccomodationDTO> list = new ArrayList<AccomodationDTO>();
	List<AccomodationRegisterDTO> list1 = new ArrayList<AccomodationRegisterDTO>();
	
	public List<AccomodationDTO> detetail(int num) {
	
		list=accomodationDao.detail(num);
		
		
		return list;
	}
	
	
	public List<AccomodationRegisterDTO> detetail1(int num) {
		list1=accomodationDao.detailRegister(num);
		
		
		return list1;
	}
	
	
	
}
