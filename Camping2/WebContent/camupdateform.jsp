<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import = "java.sql.*" %>
<%@ page import = "javax.sql.*" %>
<%@ page import = "javax.naming.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>캠핑 회원정보 수정페이지</title>
<%
	String id = request.getParameter( "id" );
%>
</head>
<style>
 tr td {
 border:1px solid;
 border-collapse: collapse;
 width:600px;
  height:50px;
 }
  table {
   border:1px solid;
 border-collapse: collapse;
  text-align:center;
  width:600px;
  height:50px;
  }
 #name {
  border:none;
  border-right:0px;
  border-top:0px;
  boder-left:0px;
  boder-bottom:0px


 }
</style>
<body>

<form name ="updateform"  action ="camupdatePro.jsp"  method ="post">
  <h2 align="center">회원정보 상세보기 수정 화면</h2>
	<table align="center">
		<tr>
			<td> 아이디  </td>
			<td><input id="name" type ="text" name ="id" value="<%=id %>" readonly/></td></tr>
		<tr>
			<td> 이메일  </td>
			<td><input type ="text" name="email"/></td></tr>
		<tr>
		<tr>
			<td> 전화번호  </td>
			<td><input type ="text" name="tel" size="15"/></td></tr>
		<tr>
			<td> 비밀번호  </td>
			<td><input type ="password" name="pass"/></td></tr>
		<tr>
		
		<td colspan = "2"  align = center>
		<input type="submit" value="회원정보 수정"/>
		<input type="reset" value="취소">
		<input type="submit" value="회원 전체 정보보기" onclick="location.href='campingjoin_list.jsp'"/>
		</td>
		</tr>
		</table>
	</form>

</body>
</html>