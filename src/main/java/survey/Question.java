package survey;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
// surveyForm에 들어갈 내용을 저장하기 위한 command객체
public class Question {
	private String title;
	private List<String> options;
	
	public Question(String title, List<String> options) {
		super();
		this.title = title;
		this.options = options;
	}
	
	public Question(String title) {
		// this생성자
		this(title,Collections.<String>emptyList());
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<String> getOptions() {
		return options;
	}
	public void setOptions(List<String> options) {
		this.options = options;
	}
	public boolean isChoice() {
		return options != null && !options.isEmpty();
	}
}
