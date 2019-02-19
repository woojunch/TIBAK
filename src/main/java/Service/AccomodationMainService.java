package Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import Model.AccomodationDTO;
import Model.AccomodationDao;

public class AccomodationMainService {
	@Autowired	  
	private AccomodationDao accomodationDao;
	List<AccomodationDTO> list = new ArrayList<AccomodationDTO>();
	
	public List<AccomodationDTO> accomodationList(){
	
		AccomodationDTO accomodationDTO=new AccomodationDTO();
		System.out.println("여기왔어");
		list=accomodationDao.list();
	
		
		return list;
		
	}
	}
	

