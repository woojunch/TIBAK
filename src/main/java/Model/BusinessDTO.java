package Model;

public class BusinessDTO {
	private String id;
	private String name; 
	private String passwd;
	private String birth;
	private String email;
	private String company;
	private String phone;
	private String date;
	private String passdate;
	
	public BusinessDTO()	{}
	
	public BusinessDTO(String id, String name, String passwd, String birth, String email, String company, String phone,
			String date, String passdate) {
		super();
		this.id = id;
		this.name = name;
		this.passwd = passwd;
		this.birth = birth;
		this.email = email;
		this.company = company;
		this.phone = phone;
		this.date = date;
		this.passdate = passdate;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
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
}
