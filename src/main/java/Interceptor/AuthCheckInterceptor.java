package Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthCheckInterceptor extends HandlerInterceptorAdapter {
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession(false);// session이 있는지 확인
		if(session != null) {
			Object authInfo = session.getAttribute("authInfo");
			if(authInfo != null) return true;
		}
		response.sendRedirect(request.getContextPath()+"/login"); // http://lochalhost:8080/sp4-chap09/login
		return false;
	}
}
