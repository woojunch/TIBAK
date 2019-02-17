package Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import Model.MemberJoinDAO;
import Model.MemberJoinDTO;

public class MemberListService {
	@Autowired
	private MemberJoinDAO memberJoinDao;
	List<MemberJoinDTO> members;
	
	 
	public void setMemberJoinDao(MemberJoinDAO memberJoinDao) {
		this.memberJoinDao = memberJoinDao;
	} 
	public List<MemberJoinDTO> memberList() {
		members = memberJoinDao.memberList();
		System.out.println(members.get(0).getDate());
		return members;
	}

}
