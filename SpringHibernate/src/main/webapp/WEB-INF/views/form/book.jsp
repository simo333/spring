<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book form</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/menu.jsp"/>
<form:form method="post" modelAttribute="book" action="/bookForm/form">
    <form:hidden path="id" value="${book.id}"/>
    Title: <form:input path="title" value="${book.title}"/><br>
    Rating: <form:input path="rating" type="number" step="0.1" min="0" value="${book.rating}"/><br>
    Description: <form:textarea path="description" rows="5" cols="10" value="${book.description}"/><br>
    Publisher: <form:select path="publisher" items="${publishers}" itemLabel="name" itemValue="id" selected="${book.publisher}"/><br>
    Authors: <form:select path="authors" items="${allAuthors}" itemLabel="fullName" itemValue="id"/>
    <button type="submit">Save</button>
</form:form>
</body>
</html>
