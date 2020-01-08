<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Context-Type" content="text/html; charset=UTF-8">
<title>고객 정보 등록</title>
</head>
<body>
    <h3>고객 정보 입력</h3>
    <fieldset>
        <form:form method="post" modelAttribute="customer">
            <label for="name">이름 : </label>
            <form:input type="text" path="name" /><br />
            <label for="address">주소 : </label><br />
            <form:input type="text" path="address"/>
            <label for="email">이메일 : </label><br />
            <form:input type="text" path="email"/>
            <input type="submit" value="저장" />
        </form:form>
    </fieldset>
</body>
</html>