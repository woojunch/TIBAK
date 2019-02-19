package Model;

public class AccomodationRegisterDTO {

	private	    int proNum;
	private		int proPrice;
	private	    int proPrices;
	private	    int proReserveBan;
	private		String proAdTime;
	private		String proExTime;
	private		String AproMeal;
	private		String AproKind;
	private		String file;
	private		String originalFile;
	private     String bFacilityName;
	private     String bFacilityArea;
	private     String bFaciltityAddr;
	public AccomodationRegisterDTO() {}

	public AccomodationRegisterDTO(int proNum,int proPrice, int proPrices, int proReserveBan, String proAdTime, String proExTime,
			String aproMeal, String aproKind, String file, String originalFile) {
		this.proNum=proNum;
		this.proPrice = proPrice;
		this.proPrices = proPrices;
		this.proReserveBan = proReserveBan;
		this.proAdTime = proAdTime;
		this.proExTime = proExTime;
		this.AproMeal = aproMeal;
		this.AproKind = aproKind;
		this.file = file;
		this.originalFile = originalFile;
	}

	public String getbFacilityName() {
		return bFacilityName;
	}

	public void setbFacilityName(String bFacilityName) {
		this.bFacilityName = bFacilityName;
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

	public int getProNum() {
		return proNum;
	}

	public void setProNum(int proNum) {
		this.proNum = proNum;
	}

	public int getProPrice() {
		return proPrice;
	}

	public void setProPrice(int proPrice) {
		this.proPrice = proPrice;
	}

	public int getProPrices() {
		return proPrices;
	}

	public void setProPrices(int proPrices) {
		this.proPrices = proPrices;
	}

	public int getProReserveBan() {
		return proReserveBan;
	}

	public void setProReserveBan(int proReserveBan) {
		this.proReserveBan = proReserveBan;
	}

	public String getProAdTime() {
		return proAdTime;
	}

	public void setProAdTime(String proAdTime) {
		this.proAdTime = proAdTime;
	}

	public String getProExTime() {
		return proExTime;
	}

	public void setProExTime(String proExTime) {
		this.proExTime = proExTime;
	}

	public String getAproMeal() {
		return AproMeal;
	}

	public void setAproMeal(String aproMeal) {
		AproMeal = aproMeal;
	}

	public String getAproKind() {
		return AproKind;
	}

	public void setAproKind(String aproKind) {
		AproKind = aproKind;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public String getOriginalFile() {
		return originalFile;
	}

	public void setOriginalFile(String originalFile) {
		this.originalFile = originalFile;
	};

	





}
