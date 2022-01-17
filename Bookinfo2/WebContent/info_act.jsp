<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ page import= "java.sql.*"%>
    <% request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String isbn = request.getParameter("isbn");
	String title= request.getParameter("title");
	int price = Integer.parseInt(request.getParameter("price"));
	String author = request.getParameter("author");
	String publisher = request.getParameter("publisher");
	String category = request.getParameter("category");
	String description = request.getParameter("description");
	
				Connection conn=null;
				PreparedStatement pstmt=null;
				String str="";
		try{
			String jdbcUrl="jdbc:oracle:thin:@localhost:1521:xe";
			String dbId="whdytpq2";
			String dbpass="1234";


		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn=DriverManager.getConnection(jdbcUrl,dbId , dbpass);
		String sql= "insert into books_info values (?,?,?,?,?,?,?)";
		pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,isbn);
		pstmt.setString(2,title);
		pstmt.setInt(3,price);
		pstmt.setString(4,author);
		pstmt.setString(5,publisher);
		pstmt.setString(6,category);
		pstmt.setString(7,description);
		pstmt.executeUpdate();
		str= "books_info 테이블에 새로운 레코드를 추가했습니다 .";


	}catch(Exception e){
	e.printStackTrace();
	str="books_info 테이블에 새로운 레코드를 추가에 실패했습니다 ";
		}finally{
		if(pstmt != null) try{pstmt.close();}catch(SQLException sqle){
			out.println("pstmt 객체를 닫는데 실패하였습니다.");
		}
		if(conn != null) try{conn.close();}catch(SQLException sqle){
			out.println("conn 객체를 닫는데 실패하였습니다.");
		}
	}
%>
<%=str %>
<br>
<a href="info_list.jsp">조회 페이지로 이동</a>
</body>
</html>