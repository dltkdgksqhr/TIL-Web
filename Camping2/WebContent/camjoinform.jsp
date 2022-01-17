<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 회원관리  시스템  회원가입  페이지 </title>
</head>
<style>
table {
  text-align:center;
}

</style>
<body>

<form name="joinform" action="camjoinformPro.jsp" method="post">
     <h2 align="center"> 회원 가입 </h2>
	<table border="1" align="center">

<tr>
	<td width="150" height="50"> 아이디    </td >
	<td width="550" height="50"><input  type="text" name="id" size="65"  /></td>
</tr>

<tr>
	<td width="150" height="50"> 패스워드 </td>
	<td width="550" height="50"><input type="password" name="pass1" size="65"/></td>
</tr>

<tr>
	<td width="150" height="50"> 패스워드확인   </td>
	<td width="550" height="50"><input type="password" name="pass2" size="65" /></td>
</tr>

<tr>
	<td width="150" height="50"> 이메일   </td>
	<td width="550" height="50"><input type="email" name="email" size="65"/></td>
</tr>

<tr>
	<td width="150" height="50"> 전화번호  </td>
	<td width="550" height="50"><input type="text" name="tel" size="65"/></td>
</tr>

<tr>
	<td width="150" height="50"> 당신의 관심분야 </td>
	<td width="550" height="50">
	<input type="checkbox" name="hob" value="캠핑"/>캠핑
	<input type="checkbox" name="hob" value="등산"/>등산
	<input type="checkbox" name="hob" value="영화"/>영화
	<input type="checkbox" name="hob" value="독서"/>독서</td>
</tr>

	<tr>
	<td width="150" height="50">당신의 직업은 </td>
	<td>
	 <select name="job">
	   <option value="교사">교사</option>
	   <option value="공무원">공무원</option>
	   <option value="의사">의사</option>
	   <option value="연구원" >연구원</option>
	   <option value="아나운서">아나운서</option>
	 </select>
	</td>
</tr>
 <tr>
	<td width="150" height="50"> 당신의 연령은 </td>
	<td width="550" height="50"><input type="radio" name="age" value="10대"/>10대
	<input type="radio" name="age" value="20대"/>20대
	<input type="radio" name="age" value="30대"/>30대
	<input type="radio" name="age" value="40대"/>40대</td>
</tr>
<tr>
	<td> 하고싶은 말   </td>
	<td> <textarea cols="60" rows="8" name="info"></textarea></td></tr>
<tr>
	<td colspan="2" align="center" >
	<input type="submit" value="회원가입"> &nbsp;&nbsp;
	<input type="reset" value="취소"> 
	</td>
</tr>
	</table>
</form>
</body>
</html>