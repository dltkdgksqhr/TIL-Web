package sec01.ex04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/second")
public class SecondServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		  response.setContentType("text/html;charset=utf-8");
		  PrintWriter out = response.getWriter();
		  String name = request.getParameter("name");
		  out.println("<html><body>");
		  out.println("이름 : " + name);
		  out.println("</html></body>");
	  }
}
