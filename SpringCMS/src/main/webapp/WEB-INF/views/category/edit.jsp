<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Category</title>
</head>
<body>
<form:form method="post" modelAttribute="category" action="/categories/edit">
    <legend>New category:</legend>
    <form:hidden path="id" value="${category.id}"/>
    Name: <form:input path="name" value="${category.name}"/><br>
    Description: <form:input path="description" value="${category.description}"/><br>
    <button type="submit">Edit</button>
</form:form>
<a href="/categories"><button>Back to list</button></a>
</body>
</html>
