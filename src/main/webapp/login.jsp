<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<script type="text/javascript">
window.onload = getCookieValue();

function getCookieValue(){
	if(document.cookie.startsWith("loginCookie=")){
    	console.log(document.cookie);
        return location.href="${pageContext.request.contextPath}/autoLogin";
    }
}

function fnLogin(){
    var frmLogin = document.frmLogin;
    var id = frmLogin.id.value;
    var pwd = frmLogin.pwd.value;

    if(id.length == 0 || id == ""){
        alert("아이디를 입력해 주세요.");
    }else if(pwd.length = 0 || pwd == ""){
        alert("비밀번호를 입력해 주세요.")
    }else{
        frmLogin.method ="post";
        frmLogin.action="login";
        frmLogin.submit();
    }
}
function fnJoin(){
    frmLogin.method="get";
    frmLogin.action="register" //회원가입 주소 넣기
    frmLogin.submit();
}
</script>
</head>
<body>
	<form name="frmLogin">
		아이디 :<input type='text' name= "id"><br>
		비밀번호:<input type= "password" name= "pwd" ><br>
        <input type= "button" value= "회원가입" onclick="fnJoin()"> 
		<input type= "button" value= "로그인" onclick="fnLogin()">
        <input type= "button" value= "쿠키" onclick="getCookieValue()">
		
		
	</form>
</body>
</html>