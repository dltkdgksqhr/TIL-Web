<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    import="java.util.*, sec02.ex01.*"
    %>
   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%
  request.setCharacterEncoding("utf-8");
 %>
  <jsp:useBean id="m" class="sec02.ex01.MemberBean"/>
  <jsp:setProperty name="m" property="*"/>
  <%
     MemberDAO memDAO= new MemberDAO();
     memDAO.addMember(m);
     List memberList = memDAO.listMembers();
     request.setAttribute("memberList", memberList);
  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터베이스 연동</title>
</head>
<body>
  <jsp:forward page="memberList.jsp"/>
</body>
</html>