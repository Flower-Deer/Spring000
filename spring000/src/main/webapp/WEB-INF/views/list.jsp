<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- @지시자, @taglib는 c를 앞에 붙여서 사용하면,
	jsp/servlet엔진이 자바문법으로 바꾸어줘! -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:forEach var="dto" items="${list}">
검색한 id >> ${dto.id} <br>
검색한 classes >> ${dto.classes} <br> <!-- dto.getName() -->
검색한 name >> ${dto.name} <br>
검색한 grade >> ${dto.grade} 
<hr color="blue">
</c:forEach>
</body>
</html>