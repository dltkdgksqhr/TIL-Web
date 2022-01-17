<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import= "java.sql.*"%>
	<%@ page import= "javax.sql.*" %>
    <%@ page import= "javax.naming.*" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     <%
    request.setCharacterEncoding("UTF-8");

    String id= null;
    if ((session.getAttribute("id")==null)) {
    	out.println("<script>");
    	out.println("camjoinform.href='camjoinform.jsp'");
    	out.println("</script>");
    	}
    Connection conn= null;
    PreparedStatement pstmt= null;
    ResultSet rs= null;

    try {
	    	Context init = new InitialContext();
	    	DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
	    	conn = ds.getConnection();
	    	pstmt=conn.prepareStatement("SELECT * FROM teammember");
	    	rs=pstmt.executeQuery();
	    	} catch(Exception e){
	    	e.printStackTrace();
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 보기</title>
</head>
<body>
 <h2 align="center"> 회원 정보 보기 </h2>
  <table border= "1" width="700" align="center">
	<tr align= center>
		<th>아이디</th>
		<th>이메일</th>
		<th>전화번호</th>
		<th>취미</th>
		<th>직업</th>
		<th>연령</th>
		<th>하고 싶은 말</th>
		</tr>
		  <% while(rs.next()) {%>
		<tr align= center>
		 <td>
		 <a href="camping_info.jsp?id=<%=rs.getString("id") %>">
		     <%=rs.getString("id") %> </td>
		 <td><%=rs.getString("email") %> </td>
		 <td><%=rs.getString("tel") %> </td>
		 <td><%=rs.getString("hob") %> </td>
		 <td><%=rs.getString("job") %> </td>
		 <td><%=rs.getString("age") %> </td>
		 <td><%=rs.getString("info") %> </td>
		</a>
	</tr>
	<%} %>
	
</table>

</body>
</html>