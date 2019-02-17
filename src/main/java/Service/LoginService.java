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
		if(member==null) {
			System.out.println("아이디가 존재하지 않음 로그인 페이지로 돌아갈");

		}
		
		AuthInfo authInfo = new AuthInfo(member.getId(), member.getPasswd());
		

		if(!member.getPasswd().equals(password)) {
			System.out.println("service 비밀번호 : "+member.getPasswd()+","+ password);
			System.out.println("비밀번호가다릅니다");
			throw new IdPasswordNotMatchingException("비밀번호가 틀립니다.");
		}

		return authInfo;
	} 

}
