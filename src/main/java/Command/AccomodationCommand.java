package Command;

import org.springframework.web.multipart.MultipartFile;

public class AccomodationCommand {
	private String bFacilityName;
	private int bFacilityRoom;
	private String address;
	private String addressDetail;
	private String bFacilityImform;
	private MultipartFile boardFile;
	
	
	
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddressDetail() {
		return addressDetail;
	}
	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}
	public String getbFacilityImform() {
		return bFacilityImform;
	}
	public void setbFacilityImform(String bFacilityImform) {
		this.bFacilityImform = bFacilityImform;
	}
	public MultipartFile getBoardFile() {
		return boardFile;
	}
	public void setBoardFile(MultipartFile boardFile) {
		this.boardFile = boardFile;
	}
}
