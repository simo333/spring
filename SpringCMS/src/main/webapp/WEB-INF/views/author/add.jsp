<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a new Author</title>
</head>
<body>
<form:form method="post" modelAttribute="author">
    <legend>New author:</legend>
    <form:hidden path="id" value="${author.id}"/>
    First name: <form:input path="firstName" value="${author.firstName}"/><br>
    Last name: <form:input path="lastName" value="${author.lastName}"/><br>
    <button type="submit">Save</button>
</form:form>
<a href="/authors"><button>Back to list</button></a>
</body>
</html>
