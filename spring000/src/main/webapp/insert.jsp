<%@page import="com.multi.www000.MemberDAO"%>
<%@page import="com.multi.www000.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 받아라, 가방을 만들어서 집어넣고, 프린트 -->
    <%
    	String id = request.getParameter("id");
    	String pw = request.getParameter("pw");
    	String name = request.getParameter("name");
    	String tel = request.getParameter("tel");
    	
    	MemberDTO bag = new MemberDTO();
    	bag.setId(id);
    	bag.setPw(pw);
    	bag.setName(name);
    	bag.setTel(tel);
    	
    	MemberDAO dao = new MemberDAO();
    	dao.insert(bag);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
받은 데이터는 <%=id %> <br>
받은 데이터는 <%=pw %> <br>
받은 데이터는 <%=name %> <br>
받은 데이터는 <%=tel %> <br>
</body>
</html>
