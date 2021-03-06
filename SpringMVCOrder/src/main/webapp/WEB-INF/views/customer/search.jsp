<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>고객 정보 등록</title>
<style>
th {
	background: blue;
	color: white;
	text-align: center;
}
</style>
</head>
<body>
	<h3>고객 검색</h3>
	<fieldset>
		<form:form method="get" modelAttribute="customerCondition">
			<form:label path="name">이름 : </form:label>
			<form:input path="name" type="text" />
			<input type="submit" value="검색" />
		</form:form>
	</fieldset>
	<c:if test="${ not empty customers }">
		<table>
			<tr>
				<th>이름</th>
				<th>주소</th>
				<th>이메일</th>
			</tr>
			<c:forEach var="customer" items="${ customers }">
				<tr>
					<td>${ customer.name }</td>
					<td>${ customer.address }</td>
					<td>${ customer.email }</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<hr>
	<a href="/java">홈으로</a>
</body>
</html>