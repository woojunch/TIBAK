package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class BusinessDAO {
	private JdbcTemplate jdbcTemplate;
	private String sql;
	private List<BusinessDTO> list = new ArrayList<BusinessDTO>();
	@Autowired
	public BusinessDAO(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	public void businessAdd(BusinessDTO member) {
		sql = "insert into b_member ( b_id, b_name, b_password, b_birth, b_company, b_email, b_phone, b_date, b_password_date)"
				+ " values(?, ?, ?, ?, ?, ?, ?, ?, sysdate)";
		
		jdbcTemplate.update(sql, member.getId(), member.getName(), member.getPasswd(), member.getBirth(), member.getCompany(),
				member.getEmail(), member.getPhone(), member.getDate());
	}
	public BusinessDTO bselectById(String id) {
		BusinessDTO bmember = null;
		
		sql = "select  b_id, b_name, b_password, b_birth, b_company, b_email, b_phone, b_date, b_password_date "
				+ " from b_member where b_id = ?";
		list = jdbcTemplate.query(sql, new MemberRowMapper(), id); 
		
		bmember = list.isEmpty() ? null : list.get(0); 
		if(bmember==null) {
			System.out.println("나와주세욘");
		}
		return bmember;
	} 
	
	public List<BusinessDTO> bmemberList() {
		sql = "select b_id, b_name, b_email, b_birth, b_password , b_phone, b_company, b_date,"
				+ " b_password_date from b_member order by b_date desc ";
		list = jdbcTemplate.query(sql, new MemberRowMapper());
		return list;
	}
	
	class MemberRowMapper implements RowMapper<BusinessDTO>  {
		public BusinessDTO mapRow(ResultSet rs, int rowNum) throws SQLException { 
			BusinessDTO member = new BusinessDTO();

			member.setId(rs.getString("b_id"));
			member.setName(rs.getString("b_name"));
			member.setPasswd(rs.getString("b_password"));
			member.setBirth(rs.getString("b_birth")); 
			member.setEmail(rs.getString("b_email")); 
			member.setDate(rs.getString("b_date"));
			member.setPassdate(rs.getString("b_password_date"));
			member.setPhone(rs.getString("b_phone"));
			System.out.println("mapRow:"+member.getId());
			return member;

		}
	}

}
