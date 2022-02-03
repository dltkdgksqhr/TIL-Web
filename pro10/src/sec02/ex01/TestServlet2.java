package sec02.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/first/*")
public class TestServlet2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
	 request.setCharacterEncoding("utf-8");
	  response.setContentType("text/html;charset=utf-8");
	  PrintWriter out = response.getWriter();
	  ServletContext ctx = getServletContext();
	  HttpSession sess = request.getSession();
	  String context = request.getContextPath();
	  String url = request.getRequestURL().toString();
	  String mapping = request.getServletPath();
	  String uri= request.getRequestURI();
	
	
	 out.print("<html><head>");
	 out.print("<title>Test Servlet2</title>");
	 out.print("</head>");
	 out.print("<body bgcolor='yellow'>");
	 out.print("<b>TestServlet2입니다.</b><br>");
	 out.print("<b>컨텍스트 이름 : " + context + "</b><br>");
	 out.print("<b>전체 경로 : " + url + "</b><br>");
	 out.print("<b>매핑 이름 : " + mapping + "</b><br>");
	 out.print("<b>URI : " + uri + "</b>");
	 out.print("</body>");
	 out.print("</html>");
	 out.close();
	}
}
