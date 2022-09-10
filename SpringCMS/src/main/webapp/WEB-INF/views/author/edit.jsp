<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Author</title>
    <style>
        .error {
            font-weight: bold;
            color: red;
            padding-left: 3px;
        }
    </style>
</head>
<body>
<form:form method="post" modelAttribute="author" action="/authors/edit">
    <legend>Edit author:</legend>
    <form:hidden path="id" value="${author.id}"/>
    First name: <form:input path="firstName" value="${author.firstName}"/><form:errors path="firstName" cssClass="error"/><br>
    Last name: <form:input path="lastName" value="${author.lastName}"/><form:errors path="lastName" cssClass="error"/><br>
    <button type="submit">Edit</button>
</form:form>
<a href="/authors"><button>Back to list</button></a>
</body>
</html>
