package Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import Command.MemberCommand;
import Model.TibakMember;
import Model.TicketDAO;

public class TibakMemberRegisterService {
	
	private TicketDAO ticketDao;
	private List<TibakMember> memberList;
	
	@Autowired
	public TibakMemberRegisterService(TicketDAO ticketDao) {
		this.ticketDao = ticketDao;
	}
	
	public void regist(MemberCommand mcd) {
		TibakMember member= new TibakMember();
		member.setmName(mcd.getName());
		member.setmAddr(mcd.getAddr());
		member.setmId(mcd.getId());
		member.setmPassword(mcd.getPassword());
		member.setmGender(mcd.getGender());
		member.setmBirth(mcd.getBirth());
		String phoneNum = mcd.getFirstNum()+"-"+mcd.getSecondNum()+"-"+mcd.getThirdNum();
		member.setmPhone(phoneNum);
		String addr = mcd.getAddr()+" "+mcd.getDetailAddr();
		member.setmAddr(addr);
		
		if(mcd.isMailReceived()==true) {
			member.setmMailReceived("동의");
		} else {
			member.setmMailReceived("비동의");
		}
		
		if(mcd.isMessageReceived()==true) {
			member.setmMessageReceived("동의");
		} else {
			member.setmMessageReceived("비동의");
		}
		member.setmGrade("Bronze");
		member.setmEmail("woojunch@naver.com");
		SimpleDateFormat dateForm = new SimpleDateFormat("yyyy-MM-dd");
		String date = dateForm.format(new Date());
		member.setmDate(date);
		
		ticketDao.insert(member);
	}
	
	public List<TibakMember> memberList() {
		memberList = ticketDao.memberList();
		return memberList;
	}
	
}
