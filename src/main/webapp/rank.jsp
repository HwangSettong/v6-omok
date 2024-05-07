<%@page import="object.rankVO"%>
<%@page import="java.util.List"%>
<%@page import="query.rankDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>명예의 전당</title>
<style>
		body{
			/* display: flex; */
			align-items:center;
			height: 100vh;
			width: 1010px;
		    background: no-repeat center;
		    background-image: linear-gradient( rgba(0, 0, 0, 0.3), rgba(0, 0, 0, 0.3)), url(img/omok-bg.png);
		    background-size: cover;
		   	margin: auto;
		}
		.header{
			float: right;
			margin: 50px;
		}
		.colbox{
			background-color: #fef5e8;
			border: solid 10px #eca63d;
			width: 400px;
			min-height: 200px;
			max-height: 700px;
			margin: 50px;
			display: inline-block;
			box-sizing: border-box;
			text-align: center;
		}
		table{
			margin: auto;
			border-collapse: collapse;
		}
		th{
			background-color: #eca63d44;
		}
		th, td{
			text-align: center;
			height: 50px;
		}
		.notResult{
			height: 200px;
		}
		span{
			font-size: 12px;
			color: gray;
		}
		input{
			padding:15px;
			border-radius: 15px;
			border: none;
			background-color: #ECE9E9;
			color: #000000;
			font-size: 15px;
		}
</style>
</head>
<body>
<% 
rankDAO dao = new rankDAO();
List<rankVO> winRateList = dao.listWinRate(); 
List<rankVO> winCountList = dao.listWinCount();
%>
<div class='header'>
	<input type='button' onclick="location.href='<%=request.getContextPath()%>'" value="메인화면">
</div>
<div style="clear: right">
	<div class="colbox">
		<h2>👑 승률 👑</h2>
		<table style="width:370px">
			<tr>
				<th>순위</th>
				<th style="width:70%">
					닉네임<br>
					<span>ID</span>	
				</th>
				<th>승률(%)</th>
			</tr>
			<% if(winRateList.size() == 0){ %>
				<tr><td class="notResult" colspan="3">결과가 존재하지 않습니다.</td></tr>
			<% } else{
				for(rankVO vo: winRateList) {%>
					<tr>
						<td><%=vo.getRank()%></td>
						<td>
							<%=vo.getUserNickname()%><br>
							<span><%=vo.getUserId()%></span>	
						</td>
						<td><%=vo.getPoint()%>%</td>
					</tr>
			<%}}%>
		</table>
	</div>
	<div  class="colbox">
		<h2>👑 승리 횟수 👑</h2>
		<table style="width:370px">
			<tr>
				<th>순위</th>
				<th style="width:70%">
					닉네임<br>
					<span>ID</span>	
				</th>
				<th>승 수</th>
			</tr>
			<% if(winCountList.size() == 0){ %>
				<tr><td class="notResult" colspan="3">결과가 존재하지 않습니다.</td></tr>
			<% } else{
				for(rankVO vo: winCountList) {%>
					<tr>
						<td><%=vo.getRank()%></td>
						<td>
							<%=vo.getUserNickname()%><br>
							<span><%=vo.getUserId()%></span>	
						</td>
						<td><%=(int) vo.getPoint()%></td>
					</tr>
			<%}}%>
		</table>
	</div>
</div>
</body>
</html>