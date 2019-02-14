package Model;

public class TicketDTO {
	private String proNum; //상품번호

	private String name; //상품명
	private String num; //공연번호
	private String hallNum; //공연장번호
	private String image; //상품이미지
	private String storeImg;
	private String content; //상품설명
	private int price; //가격
	private String phone; //전화번호
	private String trafficImage; //교통안내
	private String storeTraffic;
	private String reserveInform; //예매안내
	private String useInform; //이용안내
	private int reserveBan; //건당예약인원제한
	private String adTime; //입장시간
	private String exTime; //퇴장시간
	private String conDate; //공연날짜
	private String saleTerm; //판매기간
	private String conTerm; //공연기간
	private String genre; //장르
	private int ageBan; //나이제한
	private int viewTime; //관람시간
	private String seatMap; //좌석배치도
	private String storeSeat;
	

	public TicketDTO() {}

	
	public TicketDTO(String name, String num, String hallNum, String image, String content, int price,
			String phone, String trafficImage, String reserveInform, String useInform, int reserveBan, String adTime,
			String exTime, String conDate, String saleTerm, String conTerm, String genre, int ageBan, int viewTime,
			String seatMap) {
		super();
		this.name = name;
		this.num = num;
		this.hallNum = hallNum;
		this.image = image;
		this.content = content;
		this.price = price;
		this.phone = phone;
		this.trafficImage = trafficImage;
		this.reserveInform = reserveInform;
		this.useInform = useInform;
		this.reserveBan = reserveBan;
		this.adTime = adTime;
		this.exTime = exTime;
		this.conDate = conDate;
		this.saleTerm = saleTerm;
		this.conTerm = conTerm;
		this.genre = genre;
		this.ageBan = ageBan;
		this.viewTime = viewTime;
		this.seatMap = seatMap;
	}


	public String getProNum() {
		return proNum;
	}


	public void setProNum(String proNum) {
		this.proNum = proNum;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getNum() {
		return num;
	}


	public void setNum(String num) {
		this.num = num;
	}


	public String getHallNum() {
		return hallNum;
	}


	public void setHallNum(String hallNum) {
		this.hallNum = hallNum;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getStoreImg() {
		return storeImg;
	}


	public void setStoreImg(String storeImg) {
		this.storeImg = storeImg;
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


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getTrafficImage() {
		return trafficImage;
	}


	public void setTrafficImage(String trafficImage) {
		this.trafficImage = trafficImage;
	}


	public String getStoreTraffic() {
		return storeTraffic;
	}


	public void setStoreTraffic(String storeTraffic) {
		this.storeTraffic = storeTraffic;
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


	public String getConDate() {
		return conDate;
	}


	public void setConDate(String conDate) {
		this.conDate = conDate;
	}


	public String getSaleTerm() {
		return saleTerm;
	}


	public void setSaleTerm(String saleTerm) {
		this.saleTerm = saleTerm;
	}


	public String getConTerm() {
		return conTerm;
	}


	public void setConTerm(String conTerm) {
		this.conTerm = conTerm;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre(String genre) {
		this.genre = genre;
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


	public String getSeatMap() {
		return seatMap;
	}


	public void setSeatMap(String seatMap) {
		this.seatMap = seatMap;
	}


	public String getStoreSeat() {
		return storeSeat;
	}


	public void setStoreSeat(String storeSeat) {
		this.storeSeat = storeSeat;
	}
}
