<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>camping 상단</title>
</head>
<style>
#topMenu {           
   height: 70px; 
   width: 1900px;
}
 #topMenu ul li {                      
	 list-style: none;       
	 float: left;                
	line-height: 70px;          
	vertical-align: middle;     
	 text-align: center;
	         
                }
#topMenu .menuLink {                          
	text-decoration:none;                      
	display: block;                            
	width: 300px;                              
	font-size: 12px;                           
	font-weight: bold;                         
	
 }
#topMenu .menuLink:hover {                           
  background-color: #4d4d4d;   
                }
table {
  height:80px;
  width:600px;
  border-collapse: collapse;
  table-layout: fixed;
}                
 
.logo {

}
#title {

}
</style>
<body>
 <table border="1" width="600">
 <tr>
<td align="left"><img class="logo" src="./images/campinglogo.jpg" width=100 hegith=50></td>
 <td><font id="title" size=15> 낭만 캠핑</font> </td>
</tr>
<tr>
 <td><nav id="topMenu">
  <ul>
   <li><a class="menuLink">텐트</a></li>
   <li><a class="menuLink">의자</a></li>
   <li><a class="menuLink">식기류</a></li>
   <li><a class="menuLink">침낭</a></li>
   <li><a class="menuLink">테이블</a></li>
   <li><a class="menuLink">화롯대</a></li>
   
  </ul>
 </nav></td>
 </tr>
 </table>

</body>
</html>