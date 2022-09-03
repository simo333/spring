<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Author form</title>
    <style>
        .errors {
            color: red;
        }
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/views/menu.jsp"/>
<form:form method="post" modelAttribute="author" action="/authorForm/form">
    <form:hidden path="id" value="${author.id}"/>
    Title: <form:input path="firstName" value="${author.firstName}"/> <form:errors path="firstName" cssClass="errors"/><br>
    Rating: <form:input path="lastName" value="${author.lastName}"/> <form:errors path="lastName" cssClass="errors"/><br>
    Pesel: <form:input path="pesel" value="${author.pesel}"/> <form:errors path="pesel" cssClass="errors"/><br>
    Email: <form:input path="email" value="${author.email}"/> <form:errors path="email" cssClass="errors"/><br>
    <button type="submit">Save</button>
</form:form>
</body>
</html>
