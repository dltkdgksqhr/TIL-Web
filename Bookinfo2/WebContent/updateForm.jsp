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
	<h2 align="center"> Books information Update Form </h2>

	<form method="post" action="updatePro.jsp" align="center">
		<b>ISBN</b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="isbn" placeholder="숫자로 꼭 입력해주세요"><br><br>
		 <b>변경 할 Title</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="title"><br><br>
		 <b>변경 할 Price</b>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="price"><br><br>
		 <b>변경 할 Author</b>&nbsp;&nbsp;<input type="text" name="author"><br><br>
		<input type= "submit" value="입력완료 ">
		<input type= "reset" value="취소 ">
</form>
</body>
</html>