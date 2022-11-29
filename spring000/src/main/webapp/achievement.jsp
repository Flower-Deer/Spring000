<%@page import="com.multi.www000.AchievementDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>학생 성적 정보</h2>
<form action="insert4.multi">
	classes : <input name="classes"> <br>
	name : <input name="name"> <br>
	grade : <input name="grade"> <br>
	<button>성적 등록하기</button>
</form>
<hr>
<a href="list">전체 목록가지고오기</a>
<hr>
<form action="delete2">
	id : <input name="id"> <br>
	<button>성적 삭제하기</button>
</form>
</body>
</html>