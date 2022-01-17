<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
  String info_id = request.getParameter("id");
  String info_pass = request.getParameter("pass");
  String info_tel = request.getParameter("tel");
  String info_email = request.getParameter("email");
  
  out.println(info_id);
  out.println(info_pass);
  out.println(info_tel);
  out.println(info_email);
 %>
 
</body>
</html>