package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.MemberVO;
import query.MemberDAO;
import query.RankDAO;

/**
 * Servlet implementation class WinLoseController
 */
@WebServlet("/winlosecon")
public class WinLoseController extends HttpServlet {
   private static final long serialVersionUID = 1L;

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      RankDAO rdao = RankDAO.getInstance();
      request.setCharacterEncoding("utf-8");
      response.setContentType("text/html;charset=utf-8");
      int win = Integer.parseInt(request.getParameter("win"));
      int lose = Integer.parseInt(request.getParameter("lose"));
      
      
      String sessionid = request.getRequestedSessionId();
      System.out.println(sessionid);
      
      MemberDAO dao = MemberDAO.getInstance();
      MemberVO vo = dao.checkUserWithSessionKey(sessionid);


      if (win == 1 && lose == 0) {
         rdao.updateWINRATE(vo.getUserId());
         System.out.println(vo.getUserId()+ " 이김");
      } else if (win == 0 && lose == 1) {
         rdao.updateLOSERATE(vo.getUserId());
         System.out.println(vo.getUserId()+ " ");
      }

   }

}