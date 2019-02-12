package Command;

public class TicketCommand {
	private String name; //상품명
	private String img;  //상품이미지
	private String content;  //상품설명
	private int price;  //가격
	private String addr;  //공연장소
	private String phone;  //연락처
	private String trafficInform;  //교통안내
	private String reserveInform;  //이용안내
	private int reserveBan; //예매수제한
	private String startDate; // 공연시작일
	private String endDate; // 공연종료일
	private String manageInform; // 기획사정보
	private int ageBan; //관람나이제한
	private String seatImg; //좌석배치도
	private String genre; //장르
	private String viewTime; //관람시간
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTrafficInform() {
		return trafficInform;
	}
	public void setTrafficInform(String trafficInform) {
		this.trafficInform = trafficInform;
	}
	public String getReserveInform() {
		return reserveInform;
	}
	public void setReserveInform(String reserveInform) {
		this.reserveInform = reserveInform;
	}
	public int getReserveBan() {
		return reserveBan;
	}
	public void setReserveBan(int reserveBan) {
		this.reserveBan = reserveBan;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getManageInform() {
		return manageInform;
	}
	public void setManageInform(String manageInform) {
		this.manageInform = manageInform;
	}
	public int getAgeBan() {
		return ageBan;
	}
	public void setAgeBan(int ageBan) {
		this.ageBan = ageBan;
	}
	public String getSeatImg() {
		return seatImg;
	}
	public void setSeatImg(String seatImg) {
		this.seatImg = seatImg;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getViewTime() {
		return viewTime;
	}
	public void setViewTime(String viewTime) {
		this.viewTime = viewTime;
	}
	
}
