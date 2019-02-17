package Model;

public class TicketOrderDTO {
	private String proNum; //상품번호
	private String oNum; //주문번호
	private String cNum; //결제번호
	private String cWay; //결제방법
	private String id; //회원아이디
	private int price; //결제금액
	private String cDate; //결제날짜
	private String cardName; //카드사명
	private String cardNum; //카드번호
	private String halbu; //할부기간
	private String seatNum; //좌석위치
	private String hallName; //공연장명
	private String conDate; //공연날짜
	private String conName; //공연이름
	private String img; //이미지
	private String conTerm; //공연기간
	
	
	
	
	public String getConTerm() {
		return conTerm;
	}
	public void setConTerm(String conTerm) {
		this.conTerm = conTerm;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getConName() {
		return conName;
	}
	public void setConName(String conName) {
		this.conName = conName;
	}
	public String getConDate() {
		return conDate;
	}
	public void setConDate(String conDate) {
		this.conDate = conDate;
	}
	public String getHallName() {
		return hallName;
	}
	public void setHallName(String hallName) {
		this.hallName = hallName;
	}
	public String getSeatNum() {
		return seatNum;
	}
	public void setSeatNum(String seatNum) {
		this.seatNum = seatNum;
	}
	public String getProNum() {
		return proNum;
	}
	public void setProNum(String proNum) {
		this.proNum = proNum;
	}
	public String getoNum() {
		return oNum;
	}
	public void setoNum(String oNum) {
		this.oNum = oNum;
	}
	public String getcNum() {
		return cNum;
	}
	public void setcNum(String cNum) {
		this.cNum = cNum;
	}
	public String getcWay() {
		return cWay;
	}
	public void setcWay(String cWay) {
		this.cWay = cWay;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getcDate() {
		return cDate;
	}
	public void setcDate(String cDate) {
		this.cDate = cDate;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public String getCardNum() {
		return cardNum;
	}
	public void setCardNum(String cardNum) {
		this.cardNum = cardNum;
	}
	public String getHalbu() {
		return halbu;
	}
	public void setHalbu(String halbu) {
		this.halbu = halbu;
	}
	
	

	
	
	
}
