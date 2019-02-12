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

	List<ConDTO> conList;
	
	@Autowired
	public TicketDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
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