package survey;

import java.util.List;
//AnsweredData는 surveyForm.jsp의 command객체
public class AnsweredData {
	private List<String> responses;
	private Respondent res;   // 의존객체
	public List<String> getResponses() {
		return responses;
	}
	public void setResponses(List<String> responses) {
		this.responses = responses;
	}
	public Respondent getRes() {
		return res;
	}
	public void setRes(Respondent res) {
		this.res = res;
	}
}
