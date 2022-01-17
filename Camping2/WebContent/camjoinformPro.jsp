<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import= "java.sql.*"%>
	<%@ page import= "javax.sql.*" %>
    <%@ page import= "javax.naming.*" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
    request.setCharacterEncoding("UTF-8");

    String id=request.getParameter("id");
    String pass=request.getParameter("pass1");
    String email=request.getParameter("email");
    String tel=request.getParameter("tel");
    String job=request.getParameter("job");
    String age=request.getParameter("age");
    String info=request.getParameter("info");
    
    String[] hoby =request.getParameterValues("hob");
    String hob="";
    for(int i=0;i<hoby.length;i++){
    	 hob=hoby[i];
    }

    Connection conn= null;
    PreparedStatement pstmt= null;
    ResultSet rs= null;
    
    try {
    	Context init = new InitialContext();
    	DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
    	conn = ds.getConnection();
    	
    	pstmt=conn.prepareStatement("INSERT INTO teammember VALUES (?,?,?,?,?,?,?,?)");
    	pstmt.setString(1,id);
    	pstmt.setString(2,pass);
    	pstmt.setString(3,email);
    	pstmt.setString(4,tel);
        pstmt.setString(5,hob);
    	pstmt.setString(6,job);
    	pstmt.setString(7,age);
    	pstmt.setString(8,info);
    	
    	int result=pstmt.executeUpdate();

    	if(result!=0){
    		out.println("<script>");
    		out.println("location.href='campingjoin_list.jsp'");
    		out.println("</script>");
    	} else{
    		out.println("<script>");
    		out.println("location.href='camjoinform.jsp'");
    		out.println("</script>");
    	}
    } catch(Exception e){
    	e.printStackTrace();
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>