package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import object.MemberVO;
import query.MemberDAO;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
//

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");

		MemberDAO dao = MemberDAO.getInstance();
		MemberVO vo = new MemberVO();
		vo.setUserId(id);
		vo.setUserPw(pwd);
		MemberVO loginVO = dao.login(vo);
		if (loginVO == null) {
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('아이디 비밀번호가 올바르지 않습니다.');");
			out.println("location.href='login.jsp';");
			out.println("</script>");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("login", loginVO);
			Cookie cookie = new Cookie("loginCookie", session.getId());
			cookie.setPath("/");
			cookie.setMaxAge(60 * 60 * 24 * 7);
			response.addCookie(cookie);

			Date expirationDate = new Date(System.currentTimeMillis() + (7 * 24 * 60 * 60 * 1000));

			cookie.setMaxAge((int) (expirationDate.getTime() / 1000));

			dao.keepLogin(loginVO.getUserId(), session.getId(), expirationDate);
			System.out.println(session.getId());
			System.out.println(expirationDate + "");
			System.out.println(loginVO.getUserId());

			request.getRequestDispatcher("main.jsp").forward(request, response);

		}
	}

}
