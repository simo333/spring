<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a new Category</title>
    <style>
        .error {
            font-weight: bold;
            color: red;
            padding-left: 3px;
        }
    </style>
</head>
<body>
<form:form method="post" modelAttribute="category">
    <legend>New category:</legend>
    <form:hidden path="id" value="${category.id}"/>
    Name: <form:input path="name" value="${category.name}"/><form:errors path="name" cssClass="error"/><br>
    Description: <form:input path="description" value="${category.description}"/><br>
    <button type="submit">Save</button>
</form:form>
<a href="/categories"><button>Back to list</button></a>
</body>
</html>
