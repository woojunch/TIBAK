package Service;

import org.springframework.beans.factory.annotation.Autowired;

import Model.AuthInfo;
import Model.MemberJoinDAO;
import Model.MemberJoinDTO;
import Exception.IdPasswordNotMatchingException;

public class LoginService {
	@Autowired
	private MemberJoinDAO memberJoinDao;
	 
	
	public void setMemberJoinDao(MemberJoinDAO memberJoinDao) {
		this.memberJoinDao = memberJoinDao;
	}
	public AuthInfo chkLogin(String id, String password) {
		
		MemberJoinDTO member = memberJoinDao.selectById(id);
		//System.out.println(id);
		AuthInfo authInfo = new AuthInfo(member.getId(), member.getPasswd());
		
		if(member==null) {
			 throw new IdPasswordNotMatchingException("아이디가 존재하지 않습니다.");
		 }
		
		if(member.getPasswd()!= password) {
			 throw new IdPasswordNotMatchingException("비밀번호가 틀립니다.");
		 }
		 return authInfo;
	} 

}
