package Model;

public class MemberJoinDTO {
	private String id;
	private String name; 
	private String passwd;
	private String birth;
	private String gender;
	private String email;
	private String addr;
	private String mailrecv;
	private String smsrecv;  
	private String date;
	private String passdate;
	private String phone;
	
	public MemberJoinDTO() {}
	
	public MemberJoinDTO(String id, String name, String passwd, String birth, String gender, String email, String addr,
			String mailrecv, String smsrecv, String date, String passdate, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.passwd = passwd;
		this.birth = birth;
		this.gender = gender;
		this.email = email;
		this.addr = addr;
		this.mailrecv = mailrecv;
		this.smsrecv = smsrecv;
		this.date = date;
		this.passdate = passdate;
		this.phone = phone;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getMailrecv() {
		return mailrecv;
	}
	public void setMailrecv(String mailrecv) {
		this.mailrecv = mailrecv;
	}
	public String getSmsrecv() {
		return smsrecv;
	}
	public void setSmsrecv(String smsrecv) {
		this.smsrecv = smsrecv;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPassdate() {
		return passdate;
	}
	public void setPassdate(String passdate) {
		this.passdate = passdate;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}


	
}














