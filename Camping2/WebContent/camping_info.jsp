<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import = "java.sql.*" %>
<%@ page import = "javax.sql.*" %>
<%@ page import = "javax.naming.*" %>

<%

	String id = request.getParameter( "id" );
	Connection conn= null ;
	PreparedStatement pstmt= null ;
	ResultSet rs= null ;
	
try {
	Context init = new InitialContext();
	DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
	conn = ds.getConnection();
	
	pstmt=conn.prepareStatement("SELECT * FROM teammember WHERE id=?");
	pstmt.setString(1,id);
	rs=pstmt.executeQuery();
	rs.next();
	} catch(Exception e){
	e.printStackTrace();
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록 보기</title>
</head>
<body>
 <h2 align="center">회원정보 상세보기</h2>
	<table border= 1 width=300 align="center">
	<tr align= center><td> 아이디  </td>
	<td><%=rs.getString("id") %></td></tr>
	
	<tr align= center>
	<td> 이메일 주소 </td>
	<td><%=rs.getString("email") %></td>
	</tr>
	<tr align= center>
	<td> 전화번호 </td>
	<td><%=rs.getString("tel") %></td>
	</tr>
	<tr align= center>
	<td> 관심분야 </td>
	<td><%=rs.getString("hob")%></td>
	</tr>
	<tr align= center>
	<td> 직업 </td>
	<td><%=rs.getString("job") %></td>
	</tr>
	<tr align= center>
	<td> 나이 : </td>
	<td><%=rs.getString("age") %></td>
	</tr>
	<tr align= center>
	<td> 하고싶은 말 : </td>
	<td><%=rs.getString("info") %></td>
	</tr>
	
	<tr align= center>
	  <td colspan= 2>
	  <input type="submit" value="목록보기" onclick="location.href='campingjoin_list.jsp'"/>
	  <input type="submit" value="회원가입" onclick="location.href='camjoinform.jsp'"/>
	  <input type="submit" value="수정" onclick="location.href='camupdateform.jsp?id=<%=rs.getString("id") %>'"/>
	  <input type="submit" value="삭제" onclick="location.href='camjoinform.jsp'"/>
	  </td>
	</tr>
</table>
</body>
</html>