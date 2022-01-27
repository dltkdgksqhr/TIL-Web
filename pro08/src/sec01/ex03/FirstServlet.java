package sec01.ex03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/first")
public class FirstServlet extends HttpServlet {
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
	  response.setContentType("text/html;charset=utf-8");
	  PrintWriter out = response.getWriter();
	  out.print("<script type='text/javascript'>");
	  out.print("location.href='second';");
	  out.print("</script>");
  }

}