<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Context-Type" content="text/html; charset=UTF-8">
<title>고객 정보 등록</title>

<style>
.error {
	background: white;
	color: red;
	text-align: left;
}
</style>
</head>
<body>
	<h3>고객 정보 입력</h3>
	<fieldset>
		<form:form method="post" modelAttribute="customer">
			<form:label path="name" cssErrorClass="error">
				<spring:message code="customer.name" /> : 
			</form:label>
			<form:input type="text" path="name" />
			<form:errors path="name" cssClass="error" />
			<br />
			<form:label path="address" cssErrorClass="error">
				<spring:message code="customer.address" /> : 
			</form:label>
			<form:input type="text" path="address" />
			<form:errors path="address" cssClass="error" />
			<br />
			<form:label path="email" cssErrorClass="error">
				<spring:message code="customer.email" /> : 
			</form:label>
			<form:input type="text" path="email" />
			<form:errors path="email" cssClass="error" />
			<br />
			<%-- <form:password path="password" />
			<form:errors path="password" cssClass="error" />
			<br /> --%>
			<input type="submit" value="저장" />
		</form:form>
	</fieldset>
</body>
</html>