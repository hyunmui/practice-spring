<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Context-Type" content="text/html; charset=UTF-8">
<title>제 정보 등록</title>
</head>
<body>
    <h3>제 정보 입력</h3>
    <fieldset>
        <form:form method="post" modelAttribute="product" enctype="multipart/form-data">
            <form:label path="name" classErrorClass="error">제품명 : </form:label>
            <form:input path="name" type="text"/>
            <form:errors path="name" cssClass="error" /><br />
            <form:label path="price" classErrorClass="error">가격 : </form:label>
            <form:input path="price" type="text"/>
            <form:errors path="price" cssClass="error" /><br />
            <form:label path="description" classErrorClass="error">설명 : </form:label>
            <form:input path="description" type="text"/>
            <form:errors path="description" cssClass="error" /><br />
            <input name="image" type="file" /><br />
            <input type="submit" value="저장" />
        </form:form>
    </fieldset>
</body>
</html>