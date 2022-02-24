<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     isELIgnored="false"
    %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <%
     request.setCharacterEncoding("utf-8");
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 출력창</title>
</head>
<body>
<table align="center" border="1">
    <tr align="center"  bgcolor="orange">
      <td width="7%"><b>아이디</b></td>
      <td width="7%"><b>비밀번호</b></td>
      <td width="7%"><b>이름</b></td>
      <td width="7%"><b>이메일</b></td>
      <td width="7%" ><b>가입일</b></td>
    </tr>

     <c:choose>
       <c:when test="${memberList==null }">
         <tr>
           <td colspan=5> 등록된 회원이 없습니다.</td>
        </tr>
       </c:when>
     
     <c:when test="${memberList!=null }">
       <c:forEach var="mem" items="${memberList }">
       <tr align="center">
        <td>${mem.id }</td>
        <td>${mem.pwd}</td>
        <td>${mem.name}</td>     
        <td>${mem.email}</td>     
        <td>${mem.joinDate}</td>   
       </tr>
       </c:forEach>
     </c:when>
   </c:choose>
  </table>
</body>
</html>