package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class TicketDAO {
	private JdbcTemplate jdbcTemplate;
	private String sql;
	List<TibakMember> memberList;
	List<ConDTO> conList;
	
	@Autowired
	public TicketDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public void insert(TibakMember member) {
		sql="insert into member(M_ID, M_GRADE, M_NAME,M_PASSWORD,M_BIRTH,M_GENDER,M_EMAIL,M_ADDR,M_MAIL_RECEIVED,M_MESSAGE_RECEIVED,M_DATE,M_PHONE) values(?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, member.getmId(), member.getmGrade(), member.getmName(), member.getmPassword(), member.getmBirth(), member.getmGender(), member.getmEmail(),
				 member.getmAddr(), member.getmMailReceived(), member.getmMessageReceived(), member.getmDate(), member.getmPhone());
	}
	
	public List<TibakMember> memberList(){
		sql="select*from member";
		memberList = jdbcTemplate.query(sql, new TibakMemberRowMapper());
		return memberList;
	}
	//공연등록
	public void conRegist(ConDTO con) {
		sql="insert into CONCERT(T_NUM, T_NAME, T_SHOWTIME, T_MANAGEMENT_INFORM) values(concat('T',(select nvl(max(substr(t_num,2)),0)+1 from concert)),?,?,?)";
		jdbcTemplate.update(sql, con.getName(), con.getShowTime(), con.getManagementInform());
	}
	
	//공연리스트
	public List<ConDTO> conList(){
		sql="select T_NUM, T_NAME, T_SHOWTIME, T_MANAGEMENT_INFORM from CONCERT";
		conList = jdbcTemplate.query(sql,  new ConDTORowMapper());
		return conList;
	}
		
}
class TibakMemberRowMapper implements RowMapper <TibakMember> {
	public TibakMember mapRow(ResultSet rs, int rowNum) 
			throws SQLException {
		// TODO Auto-generated method stub
		TibakMember member = new TibakMember() ;
		member.setmId(rs.getString("m_id"));
		member.setmGrade(rs.getString("m_grade"));
		member.setmName(rs.getString("m_name"));
		member.setmPassword(rs.getString("m_password"));
		member.setmBirth(rs.getString("m_birth"));
		member.setmGender(rs.getString("m_gender"));
		member.setmEmail(rs.getString("m_email"));
		member.setmAddr(rs.getString("m_addr"));
		member.setmMailReceived(rs.getString("m_mail_received"));
		member.setmMessageReceived(rs.getString("m_message_received"));
		member.setmDate(rs.getString("m_date"));
		member.setmPasswordDate(rs.getString("m_password_date"));
		member.setmPhone(rs.getString("m_phone"));
		System.out.println(member.getmName());
		return member;
	}
}

class ConDTORowMapper implements RowMapper <ConDTO> {
	public ConDTO mapRow(ResultSet rs, int rowNum) throws SQLException{
		ConDTO con = new ConDTO();
		con.setNum(rs.getString("t_num"));
		con.setName(rs.getString("t_name"));
		con.setShowTime(rs.getInt("t_showtime"));
		con.setManagementInform(rs.getString("t_management_inform"));
		System.out.println(con.getName());
		return con;
	}
	
}