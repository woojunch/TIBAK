package Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class OrderDAO {
	private JdbcTemplate jdbcTemplate;
	private String sql;
	private String row;
	private String column;
	private ConHallDTO dto;
	private TicketDTO ticketdto;
	private MemberJoinDTO memberdto;
	private List<SeatDTO> purchasedSeat;
	private List<TicketOrderDTO> orderList;
	private OrderDetailDTO orderDetail;
	
	@Autowired
	public OrderDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	//주문에서 공연장정보(좌석배치)가져오기
	public ConHallDTO seatMap(String hallNum) {
		System.out.println("공연장:"+hallNum);
		sql="select T_CON_NUM, T_CON_NAME, T_CON_CAPACITY, T_CON_AREA, T_CON_ADDR, T_CON_ROW, T_CON_COLUMN from CONCERTHALL where T_CON_NUM=?";
		dto=jdbcTemplate.queryForObject(sql, new Object[] {hallNum}, new ConhallInformMapper());
		return dto;
	}
	//구매상품정보
	public TicketDTO ticketInfo(String proNum) {
		sql="select*from T_PRODUCT where PRO_NUM=?";
		ticketdto = jdbcTemplate.queryForObject(sql,  new Object[] {proNum}, new ProInfoMapper());
		return ticketdto;
	}
	
	//구매회원정보
	public MemberJoinDTO memberInfo(AuthInfo authInfo) {
		sql="select*from member where M_ID=?";
		memberdto=jdbcTemplate.queryForObject(sql, new Object[] {authInfo.getId()}, new MemberInfoMapper());
		
		return memberdto;
	}
	//주문결제정보등록
	public void ticketInfo(TicketOrderDTO dto) {
		sql="insert into T_ORDER values(concat('O',(select nvl(max(to_number(substr(o_num,2))),0)+1 from T_ORDER)),?)"; 
		jdbcTemplate.update(sql, dto.getProNum());
		
		sql="insert into PRO_ORDER values(concat('O',(select nvl(max(to_number(substr(o_num,2))),0)+1 from PRO_ORDER)),?,?,?,?)";
		jdbcTemplate.update(sql, dto.getId(), dto.getProNum(), dto.getcDate(), dto.getSeatNum());
		
		sql="insert into PAYMENT values(concat('F',(select nvl(max(to_number(substr(c_num,2))),0)+1 from PAYMENT)),concat('O',(select nvl(max(substr(o_num,2)),0)+1 from PAYMENT)),?,?,?,?)";
		jdbcTemplate.update(sql, dto.getcWay(), dto.getId(), dto.getPrice(), dto.getcDate());
		
		sql="insert into C_PAYMENT values(concat('F',(select nvl(max(to_number(substr(c_num,2))),0)+1 from C_PAYMENT)),?,?,?)";
		jdbcTemplate.update(sql, dto.getCardName(), dto.getCardNum(), dto.getHalbu());
	}
	//구매된좌석불러오기
	public List<SeatDTO> seatInfo(String proNum){
		sql="select SEAT_NUM FROM PRO_ORDER WHERE PRO_NUM=?";
		purchasedSeat=jdbcTemplate.query(sql, new purchasedSeatRowMapper(), proNum);
		
		return purchasedSeat;
	}
	
	//구매목록
	public List<TicketOrderDTO> orderList(String id){
		sql="select P.O_NUM, P.M_ID, P.PRO_NUM, P.O_DATE, P.SEAT_NUM, H.T_CON_NAME, T.PRO_CON_DATE, T.PRO_NAME, T.PRO_STOREIMAGE, T.T_PRO_PER_TERM from PRO_ORDER P, T_PRODUCT T, CONCERTHALL H where P.M_ID=? AND P.PRO_NUM=T.PRO_NUM AND T.T_CON_NUM=H.T_CON_NUM";
		orderList=jdbcTemplate.query(sql,  new orderListRowMapper(), id);
		return orderList;
	}
	
	//구매상품디테일
	public OrderDetailDTO orderDetail(String onum){
		sql="select P.O_NUM, P.M_ID, M.M_EMAIL, T.PRO_NAME, P.PRO_NUM, T.PRO_STOREIMAGE, T.PRO_CON_DATE, F.C_DATE, H.T_CON_NAME, P.SEAT_NUM, T.T_PRO_VIEW_TIME, F.C_PRICE, C.C_CARD_NAME, C.C_CARD_NUM FROM PRO_ORDER P, T_PRODUCT T, CONCERTHALL H, PAYMENT F, C_PAYMENT C, MEMBER M WHERE P.O_NUM=? AND P.PRO_NUM=T.PRO_NUM AND P.O_NUM=F.O_NUM AND F.C_NUM=C.C_NUM AND T.T_CON_NUM=H.T_CON_NUM";
		orderDetail=jdbcTemplate.queryForObject(sql, new Object[] {onum}, new OrderDetailMapper());
		return orderDetail;
	}
	
	
}
//공연장정보
class ConhallInformMapper implements RowMapper <ConHallDTO> {
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

//회원정보
class MemberInfoMapper implements RowMapper <MemberJoinDTO> {
	public MemberJoinDTO mapRow(ResultSet rs, int rowNum) throws SQLException{
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
		return member;
	}
}
//구매상품정보
class ProInfoMapper implements RowMapper <TicketDTO> {
	public TicketDTO mapRow(ResultSet rs, int rowNum) throws SQLException{
		TicketDTO dto = new TicketDTO();
		dto.setProNum(rs.getString("pro_num"));
		dto.setName(rs.getString("pro_name"));
		dto.setNum(rs.getString("t_num"));
		dto.setHallNum(rs.getString("t_con_num"));
		dto.setImage(rs.getString("pro_image"));
		dto.setStoreImg(rs.getString("pro_storeimage"));
		dto.setContent(rs.getString("pro_inform"));
		dto.setStoreContent(rs.getString("pro_storeinform"));
		dto.setPrice(rs.getInt("pro_price"));
		dto.setPhone(rs.getString("pro_phone"));
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
		return dto;
	}
}


//구매된좌석정보
class purchasedSeatRowMapper implements RowMapper <SeatDTO> {
	public SeatDTO mapRow(ResultSet rs, int rowNum) throws SQLException{
		SeatDTO dto = new SeatDTO();
		String seat[] = rs.getString("seat_num").split(" ");
		String row=seat[0].substring(0, seat[0].length()-1);
		String column=seat[1].substring(0, seat[1].length()-1);
		dto.setRowNum(row);
		dto.setColumnNum(column);
		System.out.println("혹시");
		return dto;
	}
}

//회원구매목록
class orderListRowMapper implements RowMapper <TicketOrderDTO> {
	public TicketOrderDTO mapRow(ResultSet rs, int rowNum) throws SQLException{
		TicketOrderDTO dto = new TicketOrderDTO();
		dto.setoNum(rs.getString("o_num"));
		dto.setId(rs.getString("m_id"));
		dto.setProNum(rs.getString("pro_num"));
		dto.setConDate(rs.getString("pro_con_date"));
		dto.setcDate(rs.getString("o_date"));
		dto.setConName(rs.getString("pro_name"));
		dto.setImg(rs.getString("pro_storeimage"));
		dto.setConTerm(rs.getString("T_PRO_PER_TERM"));
		return dto;
	}
}

//구매상품디테일

class OrderDetailMapper implements RowMapper <OrderDetailDTO> {
	public OrderDetailDTO mapRow(ResultSet rs, int rowNum) throws SQLException{
		OrderDetailDTO dto = new OrderDetailDTO();
		dto.setoNum(rs.getString("o_num"));
		dto.setProNum(rs.getString("pro_num"));
		dto.setProName(rs.getString("pro_name"));
		dto.setImg(rs.getString("pro_storeimage"));
		dto.setConDate(rs.getString("pro_con_date"));
		dto.setBuyDate(rs.getString("c_date"));
		dto.setHallName(rs.getString("t_con_name"));
		dto.setSeatNum(rs.getString("seat_num"));
		dto.setShowTime(rs.getInt("t_pro_view_time"));
		dto.setPrice(rs.getInt("c_price"));
		dto.setCardName(rs.getString("c_card_name"));
		dto.setEmail(rs.getString("m_email"));
		dto.setCardNum(rs.getString("c_card_num"));
		return dto;
	}
}