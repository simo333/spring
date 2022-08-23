<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Author form</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/menu.jsp"/>
<form:form method="post" modelAttribute="author" action="/authorForm/form">
    <form:hidden path="id" value="${author.id}"/>
    Title: <form:input path="firstName" value="${author.firstName}"/><br>
    Rating: <form:input path="lastName" value="${author.lastName}"/><br>
    Books: <form:select path="books" items="${allBooks}" itemLabel="title" itemValue="id"/>
    <button type="submit">Save</button>
</form:form>
</body>
</html>
