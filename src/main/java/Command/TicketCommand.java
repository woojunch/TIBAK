package Command;

import org.springframework.web.multipart.MultipartFile;

public class TicketCommand {
	private String num; //공연번호
	private String name; //상품명
	private MultipartFile img;  //상품이미지
	private String content;  //상품설명
	private int price;  //가격
	private String conhallNum;
	private String phone;  //연락처
	private MultipartFile trafficInform;  //교통안내
	private String reserveInform; //예매안내
	private String useInform;  //이용안내
	private int reserveBan; //예매수제한
	private String adTime; //입장시간
	private String exTime; //퇴장시간
	private String startConTerm; //공연기간시작일
	private String endConterm; //공연기간종료일
	private String conDate; // 공연날짜
	private String startSaleTerm; //판매기간시작날짜
	private String endSaleTerm; //판매기간종료날짜
	private int ageBan; //관람나이제한
	private int viewTime; //상영시간
	private MultipartFile seatImg; //좌석배치도
	private String genre; //장르
	
	public TicketCommand() {}
	public TicketCommand(String num, String name, MultipartFile img, String content, int price, String conhallNum,
			String phone, MultipartFile trafficInform, String reserveInform, String useInform, int reserveBan,
			String adTime, String exTime, String startConTerm, String endConterm, String conDate, String startSaleTerm,
			String endSaleTerm, int ageBan, int viewTime, MultipartFile seatImg, String genre) {
		super();
		this.num = num;
		this.name = name;
		this.img = img;
		this.content = content;
		this.price = price;
		this.conhallNum = conhallNum;
		this.phone = phone;
		this.trafficInform = trafficInform;
		this.reserveInform = reserveInform;
		this.useInform = useInform;
		this.reserveBan = reserveBan;
		this.adTime = adTime;
		this.exTime = exTime;
		this.startConTerm = startConTerm;
		this.endConterm = endConterm;
		this.conDate = conDate;
		this.startSaleTerm = startSaleTerm;
		this.endSaleTerm = endSaleTerm;
		this.ageBan = ageBan;
		this.viewTime = viewTime;
		this.seatImg = seatImg;
		this.genre = genre;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public MultipartFile getImg() {
		return img;
	}
	public void setImg(MultipartFile img) {
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
	public String getConhallNum() {
		return conhallNum;
	}
	public void setConhallNum(String conhallNum) {
		this.conhallNum = conhallNum;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public MultipartFile getTrafficInform() {
		return trafficInform;
	}
	public void setTrafficInform(MultipartFile trafficInform) {
		this.trafficInform = trafficInform;
	}
	public String getReserveInform() {
		return reserveInform;
	}
	public void setReserveInform(String reserveInform) {
		this.reserveInform = reserveInform;
	}
	public String getUseInform() {
		return useInform;
	}
	public void setUseInform(String useInform) {
		this.useInform = useInform;
	}
	public int getReserveBan() {
		return reserveBan;
	}
	public void setReserveBan(int reserveBan) {
		this.reserveBan = reserveBan;
	}
	public String getAdTime() {
		return adTime;
	}
	public void setAdTime(String adTime) {
		this.adTime = adTime;
	}
	public String getExTime() {
		return exTime;
	}
	public void setExTime(String exTime) {
		this.exTime = exTime;
	}
	public String getStartConTerm() {
		return startConTerm;
	}
	public void setStartConTerm(String startConTerm) {
		this.startConTerm = startConTerm;
	}
	public String getEndConterm() {
		return endConterm;
	}
	public void setEndConterm(String endConterm) {
		this.endConterm = endConterm;
	}
	public String getConDate() {
		return conDate;
	}
	public void setConDate(String conDate) {
		this.conDate = conDate;
	}
	public String getStartSaleTerm() {
		return startSaleTerm;
	}
	public void setStartSaleTerm(String startSaleTerm) {
		this.startSaleTerm = startSaleTerm;
	}
	public String getEndSaleTerm() {
		return endSaleTerm;
	}
	public void setEndSaleTerm(String endSaleTerm) {
		this.endSaleTerm = endSaleTerm;
	}
	public int getAgeBan() {
		return ageBan;
	}
	public void setAgeBan(int ageBan) {
		this.ageBan = ageBan;
	}
	public int getViewTime() {
		return viewTime;
	}
	public void setViewTime(int viewTime) {
		this.viewTime = viewTime;
	}
	public MultipartFile getSeatImg() {
		return seatImg;
	}
	public void setSeatImg(MultipartFile seatImg) {
		this.seatImg = seatImg;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	

	
}
