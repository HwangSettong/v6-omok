<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>오목게임</title>
	<style>
		body{
			align-items: center;
			width:810px;
			height: 100vh;
		    background: no-repeat center;
		    background-image: linear-gradient( rgba(0, 0, 0, 0.3), rgba(0, 0, 0, 0.3)), url(img/omok-bg.png);
		    background-size: cover;
		    margin: auto;
		   	display: flex;
			align-items: center;
		}
		div{
			margin:auto;
			text-align:center}
		.btn_main{
			width:340px;
			height:300px;
			border-radius: 30px;
			border: none;
			background-color: #d9d9d9b3;
			color: #000000;
			font-size: 35px;
			margin: 30px;
		}
		.logout{
			width:170px;
			height:80px;
			border-radius: 0px;}
	</style>
</head>
<body>
	<div>
		<div>
			<input class='btn_main' type='button' value='매칭하기'/>
			<input class='btn_main' type='button' value='명예의 전당' onclick="location.href='rank.jsp'"/>
		</div>
		<div>
			<input class='btn_main logout' type='button' value='로그아웃' onclick="location.href='logout'"/>
		</div>
	</div>	
</body>
</html>