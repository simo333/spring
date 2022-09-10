<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Article</title>
    <style>
        .error {
            font-weight: bold;
            color: red;
            padding-left: 3px;
        }
    </style>
</head>
<body>
<form:form method="post" modelAttribute="article" action="/articles/edit">
    <legend>Edit article:</legend>
    <form:hidden path="id" value="${article.id}"/>
    <form:hidden path="created" value="${article.created}"/>
    Title: <form:input path="title" value="${article.title}"/><form:errors path="title" cssClass="error"/><br>
    Content: <form:input path="content" value="${article.content}"/><form:errors path="content" cssClass="error"/><br>
    Author: <form:select path="author" value="${article.author}">
                <form:options items="${authors}" itemLabel="fullName" itemValue="id"/>
            </form:select><form:errors path="author" cssClass="error"/><br>
    Category: <form:checkboxes path="categories" items="${categories}" itemLabel="name" itemValue="id" element="div"/>
    <form:errors path="categories" cssClass="error"/><br>
    <button type="submit">Edit</button>
</form:form>
<a href="/articles"><button>Back to list</button></a>
</body>
</html>
