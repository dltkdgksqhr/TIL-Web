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
 Connection conn=null;
 PreparedStatement pstmt=null;
 ResultSet rs =null;
 
 try{
	 Context init= new InitialContext();
	 DataSource ds =(DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
	 conn =ds.getConnection();
	 
	 pstmt=conn.prepareStatement("insert into teammember values (?,?,?,?,?,?,?,?)");
	 
	 pstmt.setString(1,id);
	 pstmt.setString(2, pass);
	 pstmt.setString(3, email);
	 pstmt.setString(4, tel);
	 pstmt.setString(5, hob);
	 pstmt.setString(6, job);
	 pstmt.setString(7, age);
	 pstmt.setString(8, info);
	 
	 int result=pstmt.executeUpadate();
	 
	 if(result!=0){
		 out.println("<script>");
		 out.println("location.href='campingjoin_list.jsp'");
		 out.println("<script>");
	 }
	 
 } catch(Exception e) {
	 e.printStackTrace();
 }
%>

</body>
</html>