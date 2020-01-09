<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Context-Type" content="text/html; charset=UTF-8">
<title>고객 등록 정보</title>
</head>
<body>
    <h1>고객 등록 정보</h1>
    <spring:message code="customer.enroll">
    	<spring:argument value="${ customer.name }" />
    	<spring:argument value="${ customer.address }" />
    	<spring:argument value="${ customer.email }" />
    </spring:message>
    <hr>
    <a href="/java">홈으로</a>
</body>
</html>