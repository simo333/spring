<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book form</title>
    <style>
        .errors {
            color: red;
        }
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/views/menu.jsp"/>
<form:form method="post" modelAttribute="book" action="/bookForm/form">
    <form:hidden path="id" value="${book.id}"/>
    Title: <form:input path="title" value="${book.title}"/><form:errors path="title" cssClass="errors"/><br>
    Rating: <form:input path="rating" type="number" step="0.1" min="0" value="${book.rating}"/><form:errors path="rating" cssClass="errors"/><br>
    Description: <form:textarea path="description" rows="5" cols="10" value="${book.description}"/><form:errors path="description" cssClass="errors"/><br>
    Publisher: <form:select path="publisher" items="${publishers}" itemLabel="name" itemValue="id" selected="${book.publisher}"/><form:errors path="publisher" cssClass="errors"/><br>
    Authors: <form:select path="authors" items="${allAuthors}" itemLabel="fullName" itemValue="id"/><form:errors path="authors" cssClass="errors"/><br>
    Pages: <form:input path="pages" type="number" step="1" min="1" value="${book.pages}"/><form:errors path="pages" cssClass="errors"/><br>
    <button type="submit">Save</button>
</form:form>
</body>
</html>
