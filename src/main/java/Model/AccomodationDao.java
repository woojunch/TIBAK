package Model;

import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;



public class AccomodationDao {
	private JdbcTemplate jdbcTemplate;
	private String sql;
	private List<AccomodationDTO> list = new ArrayList<AccomodationDTO>();
	private List<AccomodationRegisterDTO> list1 = new ArrayList<AccomodationRegisterDTO>();
	@Autowired
	public AccomodationDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
  
	public Integer Register(AccomodationRegisterDTO accomodationRegisterDTO) throws NoSuchAlgorithmException {
		Integer i = null;
		
		System.out.println(accomodationRegisterDTO.getProNum()+"마지막");
		sql = "insert into A_PRODUCT(PRO_NUM,PRO_PRICE,PRO_PRICES,PRO_RESERVE_BAN,"
				+ " PRO_AD_TIME,PRO_EX_TIME,A_PRO_MEAL,A_PRO_KIND,STORE_FILE,ORIGINAL_FILE,B_FACILITY_NUM) "
				+ " values((select nvl(max(PRO_NUM),0) +1 from A_PRODUCT) "
				+ " ,?,?,?,?,?,?,?,?,?,?) ";

		i = jdbcTemplate.update(sql,accomodationRegisterDTO.getProPrice(),accomodationRegisterDTO.getProPrices(),
				accomodationRegisterDTO.getProReserveBan(),accomodationRegisterDTO.getProAdTime(),accomodationRegisterDTO.getProExTime(),
				accomodationRegisterDTO.getAproMeal(),accomodationRegisterDTO.getAproKind(),accomodationRegisterDTO.getFile(),
				accomodationRegisterDTO.getOriginalFile(),accomodationRegisterDTO.getProNum()
				);		 
		return i;
	}
	public Integer insert(AccomodationDTO accomodationDTO) throws NoSuchAlgorithmException {
		Integer i = null;
		sql = "insert into B_FACILITY(B_FACILITY_NUM,B_FACILITY_NAME,B_FACILITY_ROOM,B_FACILITY_AREA,"
				+ " B_FACILITY_ADDR,B_FACILITY_INFORM, ORIGINAL_FILE,STORE_FILE) "
				+ " values((select nvl(max(B_FACILITY_NUM),0) +1 from B_FACILITY) "
				+ " ,?,?,?,?,?,?,?) ";

		i = jdbcTemplate.update(sql,accomodationDTO.getbFacilityName(),accomodationDTO.getbFacilityRoom(),
				accomodationDTO.getbFacilityArea(),accomodationDTO.getbFaciltityAddr(),accomodationDTO.getbFacilityInform(),
				accomodationDTO.getOrginalFile(),accomodationDTO.getStoreFile()
				);		 
		return i;
	}
	public List<AccomodationDTO> list() {
 
		sql = "select B_FACILITY_NUM,B_FACILITY_NAME,B_FACILITY_ROOM,B_FACILITY_AREA,B_FACILITY_ADDR,B_FACILITY_INFORM,ORIGINAL_FILE,STORE_FILE from B_FACILITY "
				+"order by B_FACILITY_NUM";
		 System.out.println("여기까지");
		list  = jdbcTemplate.query(sql, new MemberRowMapper1());
   
		return list;
	}
	
	public List<AccomodationDTO> detail(int num) {
		 
		sql = "select B_FACILITY_NUM,B_FACILITY_NAME,B_FACILITY_ROOM,B_FACILITY_AREA,B_FACILITY_ADDR,B_FACILITY_INFORM,ORIGINAL_FILE,STORE_FILE from B_FACILITY "
				+"where B_FACILITY_NUM=?";
		 
		list  = jdbcTemplate.query(sql, new MemberRowMapper1(),num);
   
		return list;
	}


	
	public List<AccomodationRegisterDTO> detailRegister(int num) {
		 
		sql = "select PRO_NUM,PRO_PRICE,PRO_PRICES,PRO_RESERVE_BAN,PRO_AD_TIME,PRO_EX_TIME,A_PRO_MEAL,A_PRO_KIND,A_PRODUCT.STORE_FILE s,A_PRODUCT.ORIGINAL_FILE b, "
				+ "B_FACILITY_NAME,B_FACILITY_AREA,B_FACILITY_ADDR from B_FACILITY join A_PRODUCT "
				+" on(B_FACILITY.B_FACILITY_NUM =A_PRODUCT.B_FACILITY_NUM) where A_PRODUCT.B_FACILITY_NUM=? order by PRO_NUM";
		 
		list1  = jdbcTemplate.query(sql, new MemberRowMapperss(),num);
   
		return list1;
	}
	
	public List<AccomodationRegisterDTO> detailRoomlist() {
		 
		sql = "select PRO_NUM,PRO_PRICE,PRO_PRICES,PRO_RESERVE_BAN,PRO_AD_TIME,PRO_EX_TIME,A_PRO_MEAL,A_PRO_KIND,A_PRODUCT.STORE_FILE s,A_PRODUCT.ORIGINAL_FILE b, "
				+ "B_FACILITY_NAME,B_FACILITY_AREA,B_FACILITY_ADDR from B_FACILITY join A_PRODUCT "
				+" on(B_FACILITY.B_FACILITY_NUM =A_PRODUCT.B_FACILITY_NUM)";
		 
		list1  = jdbcTemplate.query(sql, new MemberRowMapperss());
   
		return list1;
	}
	
	public List<AccomodationRegisterDTO> detailRoomSerach(AccomodationRegisterDTO accomodationRegisterDTO,int priceM,int pricesM) {
		 System.out.println("스텝3");
		sql = "select PRO_NUM,PRO_PRICE,PRO_PRICES,PRO_RESERVE_BAN,PRO_AD_TIME,PRO_EX_TIME,A_PRO_MEAL,A_PRO_KIND,A_PRODUCT.STORE_FILE s,A_PRODUCT.ORIGINAL_FILE b, "
				+ "B_FACILITY_NAME,B_FACILITY_AREA,B_FACILITY_ADDR from B_FACILITY join A_PRODUCT "
				+" on(B_FACILITY.B_FACILITY_NUM =A_PRODUCT.B_FACILITY_NUM) where B_FACILITY_AREA=? and A_PRO_KIND=? "
				+ "and PRO_PRICE  between ? and ? and PRO_PRICES  between ? and ? and A_PRO_MEAL=? and PRO_RESERVE_BAN=? "
				+ " order by PRO_NUM";
		 
		list1  = jdbcTemplate.query(sql, new MemberRowMapperss(),accomodationRegisterDTO.getbFacilityArea(),accomodationRegisterDTO.getAproKind()
				,accomodationRegisterDTO.getProPrice(),priceM,accomodationRegisterDTO.getProPrices(),pricesM,accomodationRegisterDTO.getAproMeal()
				,accomodationRegisterDTO.getProReserveBan());
   
		return list1;
	}
}
class MemberRowMapper1 implements RowMapper<AccomodationDTO>{
	
	public AccomodationDTO mapRow(ResultSet rs,int rowNum) throws SQLException{
 
		AccomodationDTO accomodationDTO = new AccomodationDTO();
		accomodationDTO.setbFacilityNum(rs.getInt("B_FACILITY_NUM"));
		accomodationDTO.setbFacilityName(rs.getString("B_FACILITY_NAME"));
		accomodationDTO.setbFacilityRoom(rs.getInt("B_FACILITY_ROOM"));
		accomodationDTO.setbFacilityArea(rs.getString("B_FACILITY_AREA"));
		accomodationDTO.setbFaciltityAddr(rs.getString("B_FACILITY_ADDR"));
		accomodationDTO.setbFacilityInform(rs.getString("B_FACILITY_INFORM"));
		accomodationDTO.setOrginalFile(rs.getString("ORIGINAL_FILE"));
		accomodationDTO.setStoreFile(rs.getString("STORE_FILE"));
      
		return accomodationDTO;

	}
}

class MemberRowMapperss implements RowMapper<AccomodationRegisterDTO>{
		
	   public AccomodationRegisterDTO mapRow(ResultSet rs,int rowNum) throws SQLException{
		
		 
			   AccomodationRegisterDTO accomodationRegisterDTO = new AccomodationRegisterDTO();
			accomodationRegisterDTO.setProNum(rs.getInt("PRO_NUM"));
			accomodationRegisterDTO.setProPrice(rs.getInt("PRO_PRICE"));
			accomodationRegisterDTO.setProPrices(rs.getInt("PRO_PRICES"));
			accomodationRegisterDTO.setProReserveBan(rs.getInt("PRO_RESERVE_BAN"));
			accomodationRegisterDTO.setProAdTime(rs.getString("PRO_AD_TIME"));
			accomodationRegisterDTO.setProExTime(rs.getString("PRO_EX_TIME"));
			accomodationRegisterDTO.setAproMeal(rs.getString("A_PRO_MEAL"));
			accomodationRegisterDTO.setAproKind(rs.getString("A_PRO_KIND"));
			accomodationRegisterDTO.setFile(rs.getString("s"));
			accomodationRegisterDTO.setOriginalFile(rs.getString("b"));
			accomodationRegisterDTO.setbFacilityName(rs.getString("B_FACILITY_NAME"));
			accomodationRegisterDTO.setbFacilityArea(rs.getString("B_FACILITY_AREA"));
			accomodationRegisterDTO.setbFaciltityAddr(rs.getString("B_FACILITY_ADDR"));
		System.out.println("마지막입니다");
			return accomodationRegisterDTO;

		
		}


	}




