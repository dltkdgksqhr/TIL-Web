<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="java.sql.*" %>
   <%@ page import="javax.sql.*" %>
   <%@ page import="javax.naming.*" %>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
  String id=request.getParameter("id");
  String pass=request.getParameter("pass1");
  String email=request.getParameter("pass1");
  String tel=request.getParameter("pass1");
  String job=request.getParameter("pass1");
  String age=request.getParameter("pass1");
  String info=request.getParameter("pass1");
  
  String[] hoby=request.getParameterValues("hob");
  String hob="";
  
  for(int i=0;i<hoby.length;i++) {
	  hob=hoby[i];
  }
  
  Connection conn=null;
  PreparedStatement pstmt=null;
  ResultSet rs=null;
  
  Context init= new InitialContext();
  DataSource ds =(DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
  conn =ds.getConnection();
		  

%>

</body>
</html>