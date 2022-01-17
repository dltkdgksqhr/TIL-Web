<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>각 페이지 합치기</title>
<style type="text/css">
.logo {
 border-collapse:collapse;
 boder-right :none;
 boder-bottom :none;
 boder-left :none;
 boder-top :none;
 }
</style>
</head>
<body>
<table border="1" align="center" width="1900">
    <tr height="100">
      <td align="center" width="1000">
       <%@ include file="camping_top.jsp" %>
      </td>
     </tr>
     <tr height="200">
      <td align="center" width="600">
        <img alt="캠핑" src="./images/camping.jpg" width="400" height="300">
      </td>
     </tr>
    <tr height="100">
      <td align="center" width="300">
       <%@ include file="camping_bottom.jsp" %>
      </td>
     </tr>
  
  </table>

</body>
</html>