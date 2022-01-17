<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import= "java.sql.*"%>
<%   request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
			String isbn= request.getParameter("isbn");
			
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs=null;
			String str = " ";


	try{
		String jdbcUrl="jdbc:oracle:thin:@localhost:1521:xe";
		String dbId="whdytpq2";
		String dbpass="1234";


		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn=DriverManager.getConnection(jdbcUrl,dbId , dbpass);

		String sql= "select isbn from books_info where isbn= ?";
		pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,isbn);
		rs=pstmt.executeQuery();
		if(rs.next()){
			String risbn=rs.getString("isbn");

						if(isbn.equals(risbn)){
						sql= "delete from books_info where isbn= ? ";
						pstmt=conn.prepareStatement(sql);
						pstmt.setString(1,isbn);
						pstmt.executeUpdate();
						
						str="books_info 테이블의 레코드를 삭제했습니다.";
			%>
<%
	}
	}else{
		out.println(" 아이디가 틀렸습니다 .");
	}
	}catch(Exception e){
	e.printStackTrace();
	}finally{
	if(rs != null) try{rs.close();}catch(SQLException sqle){}
	if(pstmt != null) try{pstmt.close();}catch(SQLException sqle){}
	if(conn != null) try{conn.close();}catch(SQLException sqle){}
}
%>
<p>
<a href="info_list.jsp"> 조회페이지 이동 </a><br>
<%= str %>
</body>
</html>