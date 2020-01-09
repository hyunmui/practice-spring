<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<h2>로그인</h2>
	<spring:url var="authUrl" value="/static/j_spring_security_check" />
	<form method="post" class="signin" action="${ authUrl }">
		<fieldset>
			<table cellspacing="0">
				<tr>
					<th><label for="username_or_email">아이디</label></th>
					<td><input type="text" id="username_or_email" name="j_username" /></td>
				</tr>
				<tr>
					<th><label for="password">비밀번호</label></th>
					<td><input type="password" id="password" name="j_password" /></td>
				</tr>
				<tr>
					<th></th>
					<td>
						<input type="checkbox" id="remember_me" name="_spring_security_remember_me" />
						<label for="remember_me" class="inline">로그인 저장</label>
					</td>
				</tr>
				<tr>
					<th></th>
					<td>
						<input name="commit" type="submit" value="로그인" />
					</td>
				</tr>
			</table>
		</fieldset>
	</form>
	
	<script>
		document.getElementById('username_or_email').focus();
	</script>
</body>
</html>