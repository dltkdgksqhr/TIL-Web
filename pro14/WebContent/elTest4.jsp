<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false"
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>표현 언어에서 사용되는 데이터들</title>
</head>
<body>
  <h1>여러 가지 논리 연산자</h1>
  <h1>
     \${(10==10) && (20==20) } : ${(10==10) && (20==20) }<br>
     \${(10==10) and (20!=20) }: ${(10==10) and (20!=20)}<br><br>
     
     \${(10==10) || (20!=30) }: ${(10==10) || (20!=30) }<br>
     \${(10==10) or (20!=30) } : ${(10==10) or (20!=30) }<br><br>
  </h1>
</body>
</html>