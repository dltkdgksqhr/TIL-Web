<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="sec01.ex01.*"
    pageEncoding="UTF-8"%>
   <%
     request.setCharacterEncoding("utf-8");
     MemberBean member = new MemberBean("lee", "1234", "이순신", "lee@naver.com");
     request.setAttribute("member", member);
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>포워드2</title>
</head>
<body>
  <jsp:forward page="member2.jsp"></jsp:forward>
</body>
</html>