package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login7")
public class LoginTest extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String user_name=request.getParameter("user_name");
		String user_pw=request.getParameter("user_pw");
		System.out.println("아이디 : " + user_name);
		System.out.println("비밀번호 : " + user_pw);
		
		out.print("<html><body>");
		out.print("이름은 " + user_name + "<br>");
		out.print("비밀번호는 " + user_pw + "<br>");
		out.print("</body>");
		out.print("</html>");
	}

}