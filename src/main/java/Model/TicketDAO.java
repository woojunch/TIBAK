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
	List<ConHallDTO> conHallList;
	List<TicketDTO> ticketList;
	
	@Autowired
	public TicketDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	//공연등록
	public void conRegist(ConDTO con) {
		System.out.println("제발");
		sql="insert into CONCERT(T_NUM, T_NAME, T_SHOWTIME, T_MANAGEMENT_INFORM) values(concat('C',(select nvl(max(substr(t_num,2)),0)+1 from concert)),?,?,?)";
		jdbcTemplate.update(sql, con.getName(), con.getShowTime(), con.getManagementInform());
	}
	
	//공연리스트
	public List<ConDTO> conList(){
		System.out.println("여기는나오나요");
		sql="select T_NUM, T_NAME, T_SHOWTIME, T_MANAGEMENT_INFORM from CONCERT";
		conList = jdbcTemplate.query(sql,  new ConDTORowMapper());
		return conList;
	}
	
	//공연장등록
	public void conHallRegist(ConHallDTO dto) {
		sql="insert into CONCERTHALL(T_CON_NUM, T_CON_NAME, T_CON_CAPACITY, T_CON_AREA, T_CON_ADDR, T_CON_ROW, T_CON_COLUMN) values(concat('H',(select nvl(max(substr(t_con_num,2)),0)+1 from concerthall)),?,?,?,?,?,?)";
		jdbcTemplate.update(sql, dto.getName(), dto.getCapacity(), dto.getAddr().substring(0,2), dto.getAddr(), dto.getRow(), dto.getColumn());
	}
	
	//공연장리스트
	public List<ConHallDTO> conHallList() {
		sql="select T_CON_NUM, T_CON_NAME, T_CON_CAPACITY, T_CON_AREA, T_CON_ADDR, T_CON_ROW, T_CON_COLUMN from CONCERTHALL";
		conHallList = jdbcTemplate.query(sql,  new ConHallDTORowMapper());
		return conHallList;
	}
	
	//티켓상품등록
	public void ticketRegist(TicketDTO dto, String ImgStoreFile, String TrafficStoreFile, String SeatStoreFile) {
		System.out.println("dto가"+dto.getName());
		sql="insert into T_PRODUCT(PRO_NUM, PRO_NAME, T_NUM, T_CON_NUM, PRO_IMAGE, PRO_STOREIMAGE, PRO_INFORM, PRO_PRICE, PRO_PHONE, PRO_TRAFFIC_INFORM, PRO_TRAFFIC_STOREIMAGE, PRO_RESERVE_INFORM, PRO_USE_INFORM, PRO_RESERVE_BAN, PRO_AD_TIME, PRO_EX_TIME, PRO_CON_DATE, T_PRO_PRO_TERM, T_PRO_PER_TERM, T_PRO_GENRE, T_PRO_AGE_BAN, T_PRO_VIEW_TIME, T_PRO_SEAT_MAP, T_PRO_STORESEAT)"
				+" values(concat('T',(select nvl(max(substr(t_con_num,2)),0)+1 from concerthall)),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		jdbcTemplate.update(sql, dto.getName(),dto.getNum(),dto.getHallNum(),dto.getImage(), ImgStoreFile, dto.getContent(),dto.getPrice(),dto.getPhone(),dto.getTrafficImage(), TrafficStoreFile, dto.getReserveInform(),dto.getUseInform(),dto.getReserveBan(),dto.getAdTime(),dto.getExTime(),dto.getConDate(),dto.getSaleTerm(),dto.getConTerm(),dto.getGenre(),dto.getAgeBan(),dto.getViewTime(),dto.getSeatMap(), SeatStoreFile);
	}
	
	//공연상품리스트
	public List<TicketDTO> ticketList() {
		sql="select*from T_PRODUCT";
		ticketList=jdbcTemplate.query(sql,  new TicketDTORowMapper());
		return ticketList;
	}
}
//공연리스트
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
//공연장리스트
class ConHallDTORowMapper implements RowMapper <ConHallDTO> {
	public ConHallDTO mapRow(ResultSet rs, int rowNum) throws SQLException{
		ConHallDTO dto = new ConHallDTO();
		dto.setNum(rs.getString("t_con_num"));
		dto.setName(rs.getString("t_con_name"));
		dto.setCapacity(rs.getInt("t_con_capacity"));
		dto.setArea(rs.getString("t_con_area"));
		dto.setAddr(rs.getString("t_con_addr"));
		dto.setRow(rs.getInt("t_con_row"));
		dto.setColumn(rs.getInt("t_con_column"));
		return dto;
	}
}

//티켓상품리스트
class TicketDTORowMapper implements RowMapper <TicketDTO> {
	public TicketDTO mapRow(ResultSet rs, int rowNum) throws SQLException{
		TicketDTO dto = new TicketDTO();
		dto.setProNum(rs.getString("pro_num"));
		dto.setName(rs.getString("pro_name"));
		dto.setNum(rs.getString("t_num"));
		dto.setHallNum(rs.getString("t_con_num"));
		dto.setImage(rs.getString("pro_image"));
		dto.setStoreImg(rs.getString("pro_storeimage"));
		dto.setContent(rs.getString("pro_inform"));
		dto.setPrice(rs.getInt("pro_price"));
		dto.setPhone(rs.getString("pro_phone"));
		dto.setTrafficImage(rs.getString("pro_traffic_inform"));
		dto.setStoreTraffic(rs.getString("pro_traffic_storeimage"));
		dto.setReserveInform(rs.getString("PRO_RESERVE_INFORM"));
		dto.setUseInform(rs.getString("PRO_USE_INFORM"));
		dto.setReserveBan(rs.getInt("PRO_RESERVE_BAN"));
		dto.setAdTime(rs.getString("PRO_AD_TIME"));
		dto.setExTime(rs.getString("PRO_EX_TIME"));
		dto.setConDate(rs.getString("PRO_CON_DATE"));
		dto.setSaleTerm(rs.getString("T_PRO_PRO_TERM"));
		dto.setConTerm(rs.getString("T_PRO_PER_TERM"));
		dto.setGenre(rs.getString("T_PRO_GENRE"));
		dto.setAgeBan(rs.getInt("T_PRO_AGE_BAN"));
		dto.setViewTime(rs.getInt("T_PRO_VIEW_TIME"));
		dto.setSeatMap(rs.getString("T_PRO_SEAT_MAP"));
		dto.setStoreSeat(rs.getString("T_PRO_STORESEAT"));
		return dto;
	}
}