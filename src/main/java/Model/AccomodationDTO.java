package Model;

public class AccomodationDTO {
	private int bFacilityNum;
	private String bFacilityName;
	private int bFacilityRoom;
	private String bFacilityArea;
	private String bFaciltityAddr;
	private String bFacilityInform;
	private String orginalFile;
	private String storeFile;
	
	
	public int getbFacilityNum() {
		return bFacilityNum;
	}
	public void setbFacilityNum(int bFacilityNum) {
		this.bFacilityNum = bFacilityNum;
	}
	public AccomodationDTO() {}
	public AccomodationDTO(String bFacilityName, int bFacilityRoom, String bFacilityArea, String bFaciltityAddr,
			String bFacilityInform, String orginalFile, String storeFile) {
		super();
		
		this.bFacilityName = bFacilityName;
		this.bFacilityRoom = bFacilityRoom;
		this.bFacilityArea = bFacilityArea;
		this.bFaciltityAddr = bFaciltityAddr;
		this.bFacilityInform = bFacilityInform;
		this.orginalFile = orginalFile;
		this.storeFile = storeFile;
	}
	public String getbFacilityName() {
		return bFacilityName;
	}
	public void setbFacilityName(String bFacilityName) {
		this.bFacilityName = bFacilityName;
	}
	public int getbFacilityRoom() {
		return bFacilityRoom;
	}
	public void setbFacilityRoom(int bFacilityRoom) {
		this.bFacilityRoom = bFacilityRoom;
	}
	public String getbFacilityArea() {
		return bFacilityArea;
	}
	public void setbFacilityArea(String bFacilityArea) {
		this.bFacilityArea = bFacilityArea;
	}
	public String getbFaciltityAddr() {
		return bFaciltityAddr;
	}
	public void setbFaciltityAddr(String bFaciltityAddr) {
		this.bFaciltityAddr = bFaciltityAddr;
	}
	public String getbFacilityInform() {
		return bFacilityInform;
	}
	public void setbFacilityInform(String bFacilityInform) {
		this.bFacilityInform = bFacilityInform;
	}
	public String getOrginalFile() {
		return orginalFile;
	}
	public void setOrginalFile(String orginalFile) {
		this.orginalFile = orginalFile;
	}
	public String getStoreFile() {
		return storeFile;
	}
	public void setStoreFile(String storeFile) {
		this.storeFile = storeFile;
	}
	
	
	
	
	
}
