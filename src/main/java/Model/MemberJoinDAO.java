package Model; 

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class MemberJoinDAO {

	private JdbcTemplate jdbcTemplate;
	private String sql;
	private List<MemberJoinDTO> list = new ArrayList<MemberJoinDTO>();
	@Autowired
	public MemberJoinDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public void memberAdd(MemberJoinDTO newMember) {

		sql ="insert into member (m_id, m_name, m_password, m_birth, m_gender,"
				+ "	m_email, m_addr, m_mail_received, m_message_received, m_date, m_password_date, m_phone)"
				+ " values( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate, ?)";

		jdbcTemplate.update(sql, newMember.getId(),  newMember.getName(), newMember.getPasswd(),
				newMember.getBirth(), newMember.getGender(), newMember.getEmail(), newMember.getAddr(), 
				newMember.getMailrecv(), newMember.getSmsrecv(), newMember.getDate(), newMember.getPhone());

	}
	public MemberJoinDTO selectById(String id) {
		MemberJoinDTO member = null;


		sql = "select m_id, m_name, m_password, m_birth, m_gender, "
				+ " m_email, m_addr, m_mail_received, m_message_received, m_date, m_password_date, m_phone "
				+ " from member where m_id = ?"; 
		list = jdbcTemplate.query(sql, new MemberRowMapper(), id); 

		member = list.isEmpty() ? null : list.get(0); 
		System.out.println("daㅁㅇ:"+id);
		if(member==null) {
			System.out.println("나와주세욘");
		}
		return member;
	} 
	public void memberupdate(MemberJoinDTO newMember) {
		sql = "update member set m_id = ?, m_password = ?, m_phone = ?, m_addr = ?,"
				+ "  m_mail_received = ? , m_message_received = ? , m_password_date = sysdate";
		jdbcTemplate.update(sql, newMember.getId(), newMember.getPasswd(), newMember.getPhone(),
				newMember.getAddr(), newMember.getMailrecv(), newMember.getSmsrecv());
	}
	public List<MemberJoinDTO> memberList() {
		sql = "select m_id, m_name, m_email, m_birth, m_password , m_phone, m_gender, m_addr, m_date,"
				+ " m_password_date, m_mail_received, m_message_received  from member order by m_date desc ";
		list = jdbcTemplate.query(sql, new MemberRowMapper());
		return list;
	}
 

}
class MemberRowMapper implements RowMapper<MemberJoinDTO>  {
	public MemberJoinDTO mapRow(ResultSet rs, int rowNum) throws SQLException { 
		MemberJoinDTO member = new MemberJoinDTO();

		member.setId(rs.getString("m_id"));
		member.setName(rs.getString("m_name"));
		member.setPasswd(rs.getString("m_password"));
		member.setBirth(rs.getString("m_birth"));
		member.setGender(rs.getString("m_gender"));
		member.setEmail(rs.getString("m_email"));
		member.setAddr(rs.getString("m_addr"));
		member.setMailrecv(rs.getString("m_mail_received"));
		member.setSmsrecv(rs.getString("m_message_received"));
		member.setDate(rs.getString("m_date"));
		member.setPassdate(rs.getString("m_password_date"));
		member.setPhone(rs.getString("m_phone"));
		System.out.println("mapRow:"+member.getId());
		return member;

	}
}
