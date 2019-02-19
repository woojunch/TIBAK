package Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import Command.AccomodationSerachCommand;
import Model.AccomodationDao;
import Model.AccomodationRegisterDTO;

public class AccomodationRoomListService {
	@Autowired	  
	private AccomodationDao accomodationDao;
	
	List<AccomodationRegisterDTO> list = new ArrayList<AccomodationRegisterDTO>();
	
	public List<AccomodationRegisterDTO> accomodationRoomList(){
	
		System.out.println("여기왔어");
		list=accomodationDao.detailRoomlist();
	
		
		return list;
		
	}
	public List<AccomodationRegisterDTO> accomodationRoomListSerach(AccomodationSerachCommand accomodationSerachCommand){
		String time1;
		String time2;
		int priceM;
		int pricesM;
		AccomodationRegisterDTO accomodationRegisterDTO = new AccomodationRegisterDTO();
		
		accomodationRegisterDTO.setAproKind(accomodationSerachCommand.getaProKind());
		accomodationRegisterDTO.setAproMeal(accomodationSerachCommand.getaProMeal());
		accomodationRegisterDTO.setbFacilityArea(accomodationSerachCommand.getArea());
		time1=accomodationSerachCommand.getProAdTime1()+" "+accomodationSerachCommand.getProAdTime2()+":"+accomodationSerachCommand.getProAdTime3();
        time2=accomodationSerachCommand.getProExTime1()+" "+accomodationSerachCommand.getProExTime2()+":"+accomodationSerachCommand.getProExTime3();
		accomodationRegisterDTO.setProAdTime(time1);
		accomodationRegisterDTO.setProExTime(time2);
		accomodationRegisterDTO.setProReserveBan(accomodationSerachCommand.getProReserveBan());
		accomodationRegisterDTO.setProPrice(accomodationSerachCommand.getaProPrice());
		accomodationRegisterDTO.setProPrices(accomodationSerachCommand.getaProPrices());
		priceM=accomodationSerachCommand.getaProPriceM();
		pricesM=accomodationSerachCommand.getaProPricesM();
		
		
		System.out.println("스텝2");
		list=accomodationDao.detailRoomSerach(accomodationRegisterDTO,priceM,pricesM);
	
		
		return list;
		
	}
	
	
	}

