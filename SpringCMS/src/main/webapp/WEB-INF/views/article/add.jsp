<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a new Article</title>
</head>
<body>
<form:form method="post" modelAttribute="article">
    <legend>New article:</legend>
    <form:hidden path="id" value="${article.id}"/>
    Title: <form:input path="title" value="${article.title}"/><br>
    Content: <form:input path="content" value="${article.content}"/><br>
    Author: <form:select path="author" value="${article.author}">
                <form:option value="" label="Choose author.."/>
                <form:options items="${authors}" itemLabel="fullName" itemValue="id"/>
            </form:select><br>
    Category: <form:checkboxes path="categories" items="${categories}" itemLabel="name" itemValue="id" element="div"/><br>
    <button type="submit">Save</button>
</form:form>
<a href="/articles"><button>Back to list</button></a>
</body>
</html>
