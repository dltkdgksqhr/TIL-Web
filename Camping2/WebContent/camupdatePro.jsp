<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@  page  import = "java.sql.*" %>
<%@  page  import = "javax.sql.*"  %>
<%@  page  import = "javax.naming.*"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정 프로그램</title>
</head>
<body>
<%
  String info_id = request.getParameter("id");
  String info_pass = request.getParameter("pass");
  String info_tel = request.getParameter("tel");
  String info_email = request.getParameter("email");
  String id="";
  String pass1="";

	  Connection conn= null;
	  PreparedStatement pstmt= null;
	  ResultSet rs= null;

  try {
      // 쿼리 - 먼저 입력된 아이디로 DB에서 비밀번호를 조회한다
	    	Context init = new InitialContext();
	    	DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
	    	conn = ds.getConnection();
	    	
	    	
	    	
	    	pstmt=conn.prepareStatement("SELECT * FROM  teammember  WHERE pass1= ? and id= ? " );
	    	pstmt.setString(1,pass1); //첫번째 물음표의 값 지정
	    	pstmt.setString(2,id); // 두번째 물음표의 값지정 
	    	
	    	rs = pstmt.executeQuery();
	    	
	    	 if(rs.next()){
	    	 if (pass1.equals(rs.getString("pass"))){
	    		session.setAttribute("id",id);
	       	
	    	pstmt=conn.prepareStatement("update teammember set tel=?, email=? where id=?");
	    	pstmt.setString(1, info_tel);
	    	pstmt.setString(2, info_email);
	    	pstmt.setString(3, info_id);
	    	    	
	    	pstmt.executeUpdate();
	    	 }
	    	 } else {
	    		 out.println("빈값");
     		 }
			
	    	
	    	} catch(Exception e){
	    	e.printStackTrace();
  	}
%>

 <%=info_id %>님의 정보가 수정되었습니다.
 <input type="submit" value="목록보기" onclick="location.href='campingjoin_list.jsp'"/>

</body>
</html>