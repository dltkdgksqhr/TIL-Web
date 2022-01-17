<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body { background-color: aliceblue;
}
</style>
</head>
<body>
<h2 align="center"> Books information Delete Form </h2>

	<form method="post" action="deletePro.jsp" align="center">
		<b>삭제 할 ISBN</b> &nbsp;&nbsp; <input type="text" name="isbn" placeholder="숫자로 꼭 입력해주세요"><br><br>
		 
		<input type= "submit" value="입력완료 ">
		<input type= "reset" value="취소 ">
</form>

</body>
</html>