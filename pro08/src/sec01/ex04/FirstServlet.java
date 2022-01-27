package sec01.ex04;

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
	  response.sendRedirect("second?name=lee");
  }

}
