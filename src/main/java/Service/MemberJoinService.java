package Service;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
 
import Command.MemberJoin;
import Model.MemberJoinDAO;
import Model.MemberJoinDTO;

public class MemberJoinService {
	private static MemberJoinDAO memberJoinDao;
	@Autowired
	public MemberJoinService(MemberJoinDAO memberJoinDao) {
		this.memberJoinDao = memberJoinDao;
	}
	public static void join(MemberJoin mem) {
		MemberJoinDTO newMember = new MemberJoinDTO();
		newMember.setId(mem.getId());
		newMember.setName(mem.getName());
		newMember.setEmail(mem.getEmail());
		newMember.setPasswd(mem.getPasswd());
		newMember.setBirth(mem.getBirth());
		newMember.setGender(mem.getGender());
		newMember.setPhone(mem.getStart_num()+"-"+mem.getPhone_second()+"-"+mem.getPhone_third());
		newMember.setAddr(mem.getSample6_address()+" "+mem.getSample6_detailAddress());

		newMember.setMailrecv(mem.getMailrecv());
		newMember.setSmsrecv(mem.getSmsrecv());

		SimpleDateFormat dateForm = new SimpleDateFormat("yyyy-MM-dd");
		String date = dateForm.format(new Date());
		
		newMember.setDate(date);
		
		memberJoinDao.memberAdd(newMember);
	} 
}
