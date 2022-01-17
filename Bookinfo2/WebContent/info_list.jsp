<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import= "java.sql.*"%>
     <% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	body {
		background-color:aliceblue;
		font-weight: bold;
		 align: center;
	}
	
	div {
		
	}
	
	table,th,td {
			border-collapse: collapse;
			border: 3px solid #BDBDBD;
			text-align: center;
			
	  }
	  
	  th {
	    background-color: #bbdefb;
	  }
</style>
</head>
<body>
<h2 align="center"> Books information List </h2>
	<table width= "600" border="1" align="center">
		<tr>
			<th width="120" align="center"> ISBN </th>
			<th width="120" align="center"> Title</th>
			<th width="110" align="center"> Price </th>
			<th width="110" align="center"> Author </th>
			<th width="110" align="center"> Publisher</th>
			<th width="110" align="center"> Category </th>
			<th width="250" align="center"> Description</th>
		</tr>
<%
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try{
			String jdbcUrl="jdbc:oracle:thin:@localhost:1521:xe";
			String dbId="whdytpq2";
			String dbpass="1234";


			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection(jdbcUrl,dbId ,dbpass );


					String sql= "select * from books_info";
					pstmt=conn.prepareStatement(sql);
					rs=pstmt.executeQuery();


			while(rs.next()){
					String isbn= rs.getString("isbn");
					String title= rs.getString("title");
					int price= rs.getInt("price");
					String author= rs.getString("author");
					String publisher= rs.getString("publisher");
					String category= rs.getString("category");
					String description= rs.getString("description");
					
			%>
				<tr>
					<td width= "120"><%=isbn%></td>
					<td width= "120"><%=title%></td>
					<td width= "110"><%=price%></td>
					<td width= "110"><%=author%></td>
					<td width= "110"><%=publisher%></td>
					<td width= "110"><%=category%></td>
					<td width= "250"><%=description%></td>
				</tr>
		<%   }
			}catch(Exception e){
						e.printStackTrace();
			}finally{
			if(rs != null)
				try{rs.close();}
				catch(SQLException sqle){
					System.out.println("rs 객체를 닫는데 실패하였습니다.");
				}
				if(pstmt != null)
				try{pstmt.close();}
				catch(SQLException sqle){
					System.out.println("pstmt 객체를 닫는데 실패하였습니다.");
				}
				if(conn != null)
				try{conn.close();}
				catch(SQLException sqle){
					System.out.println("conn 객체를 닫는데 실패하였습니다.");
				}
						}
		%>
		
</table>
	<div style="text-align: center;">
	
	<select name="catgo">
        <option value="title">ISBN</option>
        <option value="name">Title</option>
        <option value="content">Author</option>
      </select>&nbsp;
      <input type="text" name="search">&nbsp;
	<button align="center">search</button>
	&nbsp;<button>list all</button>
	
	<p>
	<a href="information.jsp"> 입력페이지 이동 </a><br>
	<a href=""> 수정페이지 이동 </a><br>
	<a href=""> 삭제페이지 이동 </a>
	</div>
</body>
</html>