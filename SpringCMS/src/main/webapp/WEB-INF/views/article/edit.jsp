<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Article</title>
</head>
<body>
<form:form method="post" modelAttribute="article" action="/articles/edit">
    <legend>Edit article:</legend>
    <form:hidden path="id" value="${article.id}"/>
    <form:hidden path="created" value="${article.created}"/>
    Title: <form:input path="title" value="${article.title}"/><br>
    Content: <form:input path="content" value="${article.content}"/><br>
    Author: <form:select path="author" value="${article.author}">
                <form:options items="${authors}" itemLabel="fullName" itemValue="id"/>
            </form:select><br>
    <button type="submit">Edit</button>
</form:form>
<a href="/articles"><button>Back to list</button></a>
</body>
</html>
