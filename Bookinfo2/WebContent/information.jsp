<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>도서정보 입력</title>
<style>
body { background-color: aliceblue;
	background-size : cover;
	background-image : url("image/sum3.jpg");
	background-repeat : no-repeat;
	background-position : bottom center; }
</style>
</head>
<script type="text/javascript">
	function listMethod() {
		location.href="info_list.jsp";
	}
</script>
<body>
 <h2 align="center"> Books Information </h2>
 <form action="info_act.jsp" method="post" align="center">
		 <b>ISBN</b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;  <input type="text" name="isbn" placeholder="숫자로 꼭 입력해주세요"><br><br>
		 <b>Title</b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="title"><br><br>
		 <b>Price</b> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <input type="text" name="price"><br><br>
		 <b>Author</b> &nbsp;&nbsp;&nbsp;&nbsp;  <input type="text" name="author"><br><br>
		 <b>Publisher</b> &nbsp;&nbsp;  <input type="text" name="publisher"><br><br>
		<b>Category</b> &nbsp;&nbsp;  <input type="text" name="category"><br><br>
		<b>description</b> <textarea name="description" cols="30" rows="10"  style="overflow-y:scroll">  </textarea><br><br>
		&nbsp;&nbsp;&nbsp;&nbsp; <input type="submit" value="전송" style="width:50pt;height:18pt;">
		&nbsp;&nbsp;&nbsp;&nbsp; <input type="reset" value="삭제" style="width:50pt;height:18pt;">
		&nbsp;&nbsp;&nbsp;&nbsp; <input type="button" value="list" style="width:50pt;height:18pt;" onclick='listMethod()'>
 </form>
 
</body>
</html>