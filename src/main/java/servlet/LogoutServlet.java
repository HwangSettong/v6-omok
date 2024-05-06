package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	// 세션 또는 쿠키 삭제 후 login 페이지로 리다이렉트
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// 세션 삭제 시...
//		HttpSession session = request.getSession();
//		session.invalidate();
		System.out.println("hihi");
		// 리다이렉트
		response.sendRedirect(request.getContextPath());
	}

}
