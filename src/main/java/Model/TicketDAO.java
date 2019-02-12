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
		System.out.println("제발");
		sql="insert into CONCERT(T_NUM, T_NAME, T_SHOWTIME, T_MANAGEMENT_INFORM) values(concat('T',(select nvl(max(substr(t_num,2)),0)+1 from concert)),?,?,?)";
		jdbcTemplate.update(sql, con.getName(), con.getShowTime(), con.getManagementInform());
	}
	
	//공연리스트
	public List<ConDTO> conList(){
		System.out.println("여기는나오나요");
		sql="select T_NUM, T_NAME, T_SHOWTIME, T_MANAGEMENT_INFORM from CONCERT";
		conList = jdbcTemplate.query(sql,  new ConDTORowMapper());
		return conList;
	}
	
	//티켓상품등록
	public void ticketRegister(TicketDTO dto) {
		sql="insert into T_PRODUCT(PRO_NUM, PRO_NAME, T_NUM, T_CON_NUM, PRO_IMAGE, PRO_INFORM, PRO_PRICE, PRO_ADDR, PRO_PHONE, PRO_TRAFFIC_INFORM, PRO_RESERVE_INFORM, PRO_USE_INFORM, PRO_RESERVE_BAN, PRO_RESERVE_CON, PRO_AD_TIME, PRO_EX_TIME, PRO_CON_DATE, T_PRO_PRO_TERM, T_PRO_PER_TERM, T_PRO_GENRE, T_PRO_AGE_BAN, T_PRO_VIEW_TIME, T_PRO_SEAT_MAP)"
				+" values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,)";
		jdbcTemplate.update(sql, dto.getProNum(), dto.getName(), dto.getNum(), dto.getHallNum(), dto.getImage(), dto.getContent(), dto.getPrice(), dto.getAddr(), dto.getPhone(), dto.getTrafficImage(), dto.getReserveInform(), dto.getUseInform(), dto.getReserveBan(), dto.getReserveCon(), dto.getAdTime(), dto.getExTime(), dto.getConDate(), dto.getSaleTerm(), dto.getConTerm(), dto.getGenre(), dto.getAgeBan(), dto.getViewTime(),dto.getSeatMap());
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