<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>
	<title>Home</title>
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type=""/>
	<script src="<%=request.getContextPath() %>/js/script.js"></script> 
</head>
<body>
<h1>
	Hello world!  홈페이지
</h1>

<P> ${username }<br/>
	<ul>
		<c:forEach var="i" items="${data}">
			<li>${i}</li>
		</c:forEach>
	</ul> 
</P>
<!-- 서버로 데이터 보내기 -->
	
	
<!-- 			/webapp이 구해진다.    스프링에서 외부파일은 jsp가 기준점이 아니다. -->
<a href="/myapp/aLink?no=200&name=hong"><img src="<%=request.getContextPath()%>/img/31.jpg"/></a>
<img src="<%=request.getContextPath()%>/img/32.jpg" id="i1" onclick="setBorder()"/> <!-- 폴더를 추가하더라도 servlet-context에 추가하지 않으면 찾아가지 못한다. -->
<div>
	<form method="post" action="/myapp/form1">
		이름 : <input type="text" name="username"/><br/>
		연락처 : <input type="text" name="tel"/><br/>
		주소 : <input type="text" name="addr"/><br/>
		<input type="submit" value="전송"/>
	</form>
	<hr/>
</div>
<div>
	<form method="post" action="/myapp/form2">
		이름 : <input type="text" name="username"/><br/>
		연락처 : <input type="text" name="tel"/><br/>
		주소 : <input type="text" name="addr"/><br/>
		<input type="submit" value="전송"/>
	</form>
	<hr/>
</div>
<div>
	<form method="post" action="/myapp/form3">
		이름 : <input type="text" name="username"/><br/>
		연락처 : <input type="text" name="tel"/><br/>
		주소 : <input type="text" name="addr"/><br/>
		<input type="submit" value="전송"/>
	</form>
	<hr/>
</div>
</body>
</html>
