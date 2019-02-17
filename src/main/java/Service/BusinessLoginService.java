package Service;

import org.springframework.beans.factory.annotation.Autowired;

import Model.AuthInfo;
import Model.BusinessAuthInfo;
import Model.BusinessDAO;
import Model.BusinessDTO;

public class BusinessLoginService {
	@Autowired
	private BusinessDAO businessDao;
	
	public void setMemberJoinDao(BusinessDAO businessDao) {
		this.businessDao = businessDao;
	}
	
	public BusinessAuthInfo chkLogin(String id, String password) {
		BusinessDTO member = businessDao.bselectById(id);
		if(member==null) {
			System.out.println("아이디가 존재하지 않음 로그인 페이지로 돌아갈");

		}
		
		BusinessAuthInfo businessAuthInfo = new BusinessAuthInfo(member.getId(), member.getPasswd());
		

		if(!member.getPasswd().equals(password)) {
			System.out.println("service 비밀번호 : "+member.getPasswd()+","+ password);
			System.out.println("비밀번호가다릅니다"); 
		}

		return businessAuthInfo;
	}

}
