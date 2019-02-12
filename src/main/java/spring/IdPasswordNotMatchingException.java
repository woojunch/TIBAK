package spring;

public class IdPasswordNotMatchingException extends RuntimeException {
	public IdPasswordNotMatchingException(String message) {
		super(message);
	}
}
