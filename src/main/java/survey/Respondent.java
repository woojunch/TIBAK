package survey;

public class Respondent {
	private int age;
	private String location;
	private Test test;
	public Test getTest() {
		return test;
	}
	public void setTest(Test test) {
		this.test = test;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
