<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a new Category</title>
</head>
<body>
<form:form method="post" modelAttribute="category">
    <legend>New category:</legend>
    <form:hidden path="id" value="${category.id}"/>
    Name: <form:input path="name" value="${category.name}"/><br>
    Description: <form:input path="description" value="${category.description}"/><br>
    <button type="submit">Save</button>
</form:form>
</body>
</html>
