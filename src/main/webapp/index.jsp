<%@page import="java.net.http.HttpRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>오목게임</title>
<%
	/*
	if(request.getSession() == null || request.getSession().getAttribute("로그인세션") == null){ // 로그인 세션 없으면 로그인 페이지로 이동
		response.sendRedirect("login페이지");
	}else{// 로그인 세션 있으면 메인 페이지로 이동
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}
	*/
	request.getRequestDispatcher("main.jsp").forward(request, response);
%>
</head>
<body>
</body>
</html>