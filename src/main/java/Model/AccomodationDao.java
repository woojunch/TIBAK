package Model;

import java.security.NoSuchAlgorithmException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class AccomodationDao {
	private JdbcTemplate jdbcTemplate;
	private String sql;
	
    @Autowired
	public AccomodationDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
    public Integer insert(AccomodationDTO accomodationDTO) throws NoSuchAlgorithmException {
    	System.out.println(accomodationDTO.getbFacilityInform());
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
}


