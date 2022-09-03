<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Publisher form</title>
    <style>
        .errors {
            color: red;
        }
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/views/menu.jsp"/>
<form:form method="post" modelAttribute="publisher" action="/publisherForm/form">
    <form:hidden path="id" value="${publisher.id}"/>
    Name: <form:input path="name" value="${publisher.name}"/> <form:errors path="name" cssClass="errors"/><br>
    NIP: <form:input path="nip" value="${publisher.nip}"/> <form:errors path="nip" cssClass="errors"/><br>
    REGON: <form:input path="regon" value="${publisher.regon}"/> <form:errors path="regon" cssClass="errors"/><br>
    <button type="submit">Save</button>
</form:form>
</body>
</html>
